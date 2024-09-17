package com.shinnosuke.infra.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@Autowired
	ProductService ProductService;
	
	@RequestMapping(value="/xdm/v1/infra/product/ProductXdmList")
	public String ProductXdmList(Model model , ProductVo productVo) {
		
		productVo.setShStartDate(productVo.getShStartDate()+ " 00:00:00");
		productVo.setShEndDate(productVo.getShEndDate()+ " 23:59:59");
		
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
		return "/xdm/v1/infra/product/ProductXdmList";
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
	
	
}
