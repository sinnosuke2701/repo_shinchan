package com.shinnosuke.infra.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinnosuke.common.util.UtilDateTime;
import com.shinnosuke.infra.code.CodeDto;

@Controller
public class ProductController {
	
	@Autowired
	ProductService ProductService;
	
	@RequestMapping(value="/xdm/v1/infra/product/ProductXdmList")
	public String ProductXdmList(Model model , @ModelAttribute("vo") ProductVo productVo) {
		
//		productVo.setShStartDate(productVo.getShStartDate()+ " 00:00:00");
//		productVo.setShEndDate(productVo.getShEndDate()+ " 23:59:59");
		
		/* 초기값 세팅이 없는 경우 사용 */
		productVo.setShStartDate(productVo.getShStartDate() == null || productVo.getShStartDate() == "" ? null : UtilDateTime.add00TimeString(productVo.getShStartDate()));
		productVo.setShEndDate(productVo.getShEndDate() == null || productVo.getShEndDate() == "" ? null : UtilDateTime.add59TimeString(productVo.getShEndDate()));
		
		productVo.setParamsPaging(ProductService.selectOneCount(productVo));
		
		List<ProductDto> products = ProductService.selectList(productVo);
		model.addAttribute("list", products);
		
		return "/xdm/v1/infra/product/ProductXdmList";
	}
	
	@RequestMapping(value ="/xdm/v1/infra/product/ProductXdmForm")
	public String ProductXdmForm() {
		return "/xdm/v1/infra/product/ProductXdmForm";
	}
	
	@RequestMapping(value ="/xdm/v1/infra/product/ProductXdmInst")
	public String ProductXdmInst(ProductDto productDto) {
		ProductService.insert(productDto);
		return "redirect:/xdm/v1/infra/product/ProductXdmList";
	}
	
	@RequestMapping(value="/xdm/v1/infra/product/ProductXdmMfom")
	public String ProductXdmMfom(ProductDto productDto,Model model) {
		model.addAttribute("item", ProductService.selectOne(productDto));
		return "/xdm/v1/infra/product/ProductXdmMfom";
	}
	
	@RequestMapping(value="/xdm/v1/infra/product/ProductXdmPdt")
	public String ProductXdmPdt(ProductDto productDto) {
		ProductService.update(productDto);
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
		return "/usr/v1/infra/index/indexUsrView";
	}
	
	@RequestMapping(value = "/usr/v1/infra/product/topUsrList")
	public String topUsrList(Model model ,@ModelAttribute("vo") ProductVo productVo) {
		model.addAttribute("list", ProductService.selectList(productVo));
		productVo.setParamsPaging(ProductService.selectOneCount(productVo));
		List<ProductDto> products = ProductService.selectList(productVo);
		model.addAttribute("list", products);
		return "/usr/v1/infra/product/topUsrList";
	}
	
	@RequestMapping(value = "/usr/v1/infra/product/detailUsrView")
	public String detailUsrView(Model model , ProductDto productDto) {
		model.addAttribute("item", ProductService.selectOne(productDto));
		List<ProductDto> product = ProductService.selectListReview(productDto);
		model.addAttribute("relist" , product);
//		ProductService.insertReview(productDto);
		return "/usr/v1/infra/product/detailUsrView";
	}
	
	@RequestMapping(value = "/usr/v1/infra/product/checkoutUsrView")
	public String checkoutUsrView(Model model , ProductDto productDto) {
		return "/usr/v1/infra/product/checkoutUsrView";
	}
}
