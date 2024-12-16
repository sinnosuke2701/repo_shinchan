package com.shinnosuke.infra.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinnosuke.common.util.UtilDateTime;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {
    
    @Autowired
    ProductService ProductService;
    
    
    // 기존 ProductXdmList 메서드
    @RequestMapping(value="/xdm/v1/infra/product/ProductXdmList")
    public String ProductXdmList(Model model , @ModelAttribute("vo") ProductVo productVo) {
        productVo.setShStartDate(productVo.getShStartDate() == null || productVo.getShStartDate() == "" ? null : UtilDateTime.add00TimeString(productVo.getShStartDate()));
        productVo.setShEndDate(productVo.getShEndDate() == null || productVo.getShEndDate() == "" ? null : UtilDateTime.add59TimeString(productVo.getShEndDate()));
        productVo.setParamsPaging(ProductService.selectOneCount(productVo));
        List<ProductDto> products = ProductService.selectList(productVo);
        model.addAttribute("list", products);
        return "xdm/v1/infra/product/ProductXdmList";
    }

    @RequestMapping(value ="/xdm/v1/infra/product/ProductXdmForm")
    public String ProductXdmForm() {
        return "xdm/v1/infra/product/ProductXdmForm";
    }
    
    @RequestMapping(value ="/xdm/v1/infra/product/ProductXdmInst")
    public String ProductXdmInst(ProductDto productDto) throws Exception {
        ProductService.insert(productDto, 0);
        ProductService.insertUploaded(productDto);
        return "redirect:/xdm/v1/infra/product/ProductXdmList";
    }
    
    @RequestMapping(value="/xdm/v1/infra/product/ProductXdmMfom")
    public String ProductXdmMfom(ProductDto productDto,Model model) {
        model.addAttribute("item", ProductService.selectOne(productDto));
        return "xdm/v1/infra/product/ProductXdmMfom";
    }
    
    @RequestMapping(value="/xdm/v1/infra/product/ProductXdmPdt")
    public String ProductXdmPdt(ProductDto productDto) throws Exception {
        ProductService.update(productDto, 0);
        ProductService.insertUploaded(productDto);
        return "redirect:/xdm/v1/infra/product/ProductXdmList";
    }
    
    @RequestMapping(value = "/xdm/v1/infra/product/ProductXdmDele")
    public String ProductXdmDele(ProductDto productDto) {
        ProductService.delete(productDto);
        return "redirect:/xdm/v1/infra/product/ProductXdmList";
    }
    
    @RequestMapping(value = "/xdm/v1/infra/product/ProductXdmUele")
    public String ProductXdmUele(ProductDto productDto) {
        ProductService.uelete(productDto);
        return "redirect:/xdm/v1/infra/product/ProductXdmList";
    }
    
    @RequestMapping(value = "/usr/v1/infra/index/indexUsrView")
    public String indexUsrView (ProductDto productDto , Model model) {
    	List<ProductDto> best = ProductService.selectListBest(productDto);
    	model.addAttribute("bestList" , best);
        return "usr/v1/infra/index/indexUsrView";
    }
    
    @RequestMapping(value = "/usr/v1/infra/product/itemUsrList")
    public String itemUsrList(Model model ,@ModelAttribute("vo") ProductVo productVo ,@ModelAttribute("dto") ProductDto productDto) {
    	model.addAttribute("list", ProductService.selectList(productVo));
    	productVo.setRowNumToShow(6);
        productVo.setParamsPaging(ProductService.selectOneCount(productVo));
        List<ProductDto> products = ProductService.selectList(productVo);
        model.addAttribute("list", products);
        System.out.println("Product sizeCount???????: " + productDto.getSizeCount());
        List<ProductDto> product = ProductService.selectListReview(productDto);
        model.addAttribute("relist" , product);
        
        model.addAttribute("prInventory", productDto);
        return "usr/v1/infra/product/itemUsrList";
    }
    
    @RequestMapping(value = "/usr/v1/infra/product/detailUsrView")
    public String detailUsrView(Model model , ProductDto productDto , ProductVo productVo) {
    	model.addAttribute("list", ProductService.selectList(productVo));
        model.addAttribute("item", ProductService.selectOne(productDto));
        List<ProductDto> product = ProductService.selectListReview(productDto);
        model.addAttribute("relist" , product);
//        ProductService.insertPayment(productDto);
        return "usr/v1/infra/product/detailUsrView";
    }
    
    @RequestMapping(value = "/usr/v1/infra/product/poUsrInst")
    public String poUsrInst(ProductDto productDto) {
    	ProductService.insertProdOrder(productDto);
        return "redirect:/usr/v1/infra/product/checkoutUsrView";
    }
    
    @RequestMapping(value = "/usr/v1/infra/product/checkoutUsrView")
    public String checkoutUsrView(@ModelAttribute("dto") ProductDto productDto , Model model) {
    	ProductService.selectOne(productDto);
    	model.addAttribute("item",ProductService.selectOne(productDto));
        return "usr/v1/infra/product/checkoutUsrView";
    }
    @RequestMapping(value ="/usr/v1/infra/product/paymentUsrInst")
    public String paymentXdmInst(ProductDto productDto , HttpSession httpSession,Model model) {
        String memberMemseq = (String) httpSession.getAttribute("Member_memseq");
        productDto.setMember_memseq(memberMemseq);
        ProductService.insertPayment(productDto);
        return "redirect:/usr/v1/infra/product/cartUsrList";
    }
    
//    @RequestMapping(value="/usr/v1/infra/review/reviewUsrInst")
//    public String reviewUsrInst(ProductDto productDto) {
//        ProductService.insertReview(productDto);
//        return "redirect:/usr/v1/infra/index/indexUsrView";
//    }
    
//    @ResponseBody
//	@RequestMapping(value = "/usr/v1/infra/review/reviewUsrProc")
//	public Map<String, Object> reviewUsrProc(ProductDto productDto, HttpSession httpSession) throws Exception {
//		Map<String, Object> returnMap = new HashMap<String, Object>();
//		httpSession.setAttribute("sessIdUsr", productDto.getMemId());
//		returnMap.put("sessIdUsr",httpSession.getAttribute("sessIdUsr"));
//		return returnMap;
//    }
//    
//    @RequestMapping(value="/usr/v1/infra/review/reviewUsrInst", method=RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> reviewUsrInst(ProductDto productDto) {
//        // 리뷰 인서트 처리
//        ProductService.insertReview(productDto);
//        
//        // 서버에서 클라이언트로 반환할 데이터를 맵으로 구성
//        Map<String, Object> response = new HashMap<>();
//        response.put("memId", productDto.getMemId()); // 예시로 productDto에 memId가 포함되었다고 가정
//        response.put("reStar", productDto.getReStar());
//        response.put("reTitle", productDto.getReTitle());
//        response.put("reComment", productDto.getReComment());
//
//        // 작성된 리뷰 정보를 클라이언트로 반환
//        return response;
//    }
    
    @ResponseBody
    @RequestMapping(value="/usr/v1/infra/review/reviewUsrInst", method=RequestMethod.POST)
    public Map<String, Object> reviewUsrInst(ProductDto productDto, HttpSession httpSession) {
        String sessIdUsr = (String) httpSession.getAttribute("sessIdUsr");
        
        if (sessIdUsr == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "User not logged in");
            return errorResponse;
        }
        
        productDto.setMemId(sessIdUsr);
        
        ProductService.insertReview(productDto);
        
        Map<String, Object> response = new HashMap<>();
        response.put("memId", productDto.getMemId()); 
        response.put("reStar", productDto.getReStar());
        response.put("reTitle", productDto.getReTitle());
        response.put("reComment", productDto.getReComment());

        return response;
    }

    @RequestMapping(value="/usr/v1/infra/product/cartUsrList")
    public String cartUsrView(ProductDto productDto , Model model) {
        List<ProductDto> payment =ProductService.selectListPayment(productDto);
        model.addAttribute("list" , payment);
        return "usr/v1/infra/product/cartUsrList";
    }
    
    @RequestMapping(value="/usr/v1/infra/index/deliveryUsrView")
    public String deliveryUsrView() {
        return "usr/v1/infra/index/deliveryUsrView";
    }
   
}
