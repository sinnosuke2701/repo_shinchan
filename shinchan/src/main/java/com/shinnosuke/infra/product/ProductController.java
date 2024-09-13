package com.shinnosuke.infra.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@Autowired
	
	@RequestMapping(value="/xdm/v1/infra/product/ProductXdmList")
	public String ProductXdmList() {
		
//		List<ProductDto> products = ProductService.
		
		return "/xdm/v1/infra/product/ProductXdmList";
	}
	
}
