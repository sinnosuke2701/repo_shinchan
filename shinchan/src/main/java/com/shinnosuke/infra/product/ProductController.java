package com.shinnosuke.infra.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String ProductUsrInde () {
        return "usr/v1/infra/index/indexUsrView";
    }
    
    @RequestMapping(value = "/usr/v1/infra/product/topUsrList")
    public String topUsrList(Model model ,@ModelAttribute("vo") ProductVo productVo ,ProductDto productDto) {
        model.addAttribute("list", ProductService.selectList(productVo));
        productVo.setParamsPaging(ProductService.selectOneCount(productVo));
        List<ProductDto> products = ProductService.selectList(productVo);
        model.addAttribute("list", products);
        System.out.println("Product sizeCount????????????????: " + productDto.getSizeCount());
        List<ProductDto> product = ProductService.selectListReview(productDto);
        model.addAttribute("relist" , product);
        return "usr/v1/infra/product/topUsrList";
    }
    
    @RequestMapping(value = "/usr/v1/infra/product/detailUsrView")
    public String detailUsrView(Model model , ProductDto productDto) {
        model.addAttribute("item", ProductService.selectOne(productDto));
        List<ProductDto> product = ProductService.selectListReview(productDto);
        model.addAttribute("relist" , product);
        return "usr/v1/infra/product/detailUsrView";
    }
    
    @RequestMapping(value = "/usr/v1/infra/product/checkoutUsrView")
    public String checkoutUsrView(ProductDto productDto, Model model) {
        model.addAttribute("item", ProductService.selectOne(productDto));
     // 결제 준비를 위한 카카오페이 API 호출
        Map<String, Object> params = new HashMap<>();
        params.put("item_name", "아이폰 14 Pro");
        params.put("quantity", 1);
        params.put("total_amount", 1400000);
        
        // 카카오페이 준비 API 호출
        ProductDto productDto1 = ProductService.kakaoPay(params);

        // 결제 관련 정보를 모델에 추가
        model.addAttribute("product", productDto1);
        return "usr/v1/infra/product/checkoutUsrView"; // 결제 URL을 전달하고 checkoutUsrView 페이지로 이동
    }
    
    @RequestMapping(value ="/usr/v1/infra/product/paymentUsrInst")
    public String paymentXdmInst(ProductDto productDto , HttpSession httpSession,Model model) {
        String memberMemseq = (String) httpSession.getAttribute("Member_memseq");
        productDto.setMember_memseq(memberMemseq);
        ProductService.insertPayment(productDto);
        return "usr/v1/infra/product/cartUsrList";
    }
    
    @RequestMapping(value="/usr/v1/infra/review/reviewUsrInst")
    public String reviewUsrInst(ProductDto productDto) {
        ProductService.insertReview(productDto);
        return "redirect:/usr/v1/infra/product/detailUsrView";
    }
    
    @RequestMapping(value="/usr/v1/infra/product/cartUsrList")
    public String cartUsrView(ProductDto productDto , Model model) {
        List<ProductDto> payment =ProductService.selectListPayment(productDto);
        model.addAttribute("list" , payment);
        return "usr/v1/infra/product/cartUsrList";
    }
}
