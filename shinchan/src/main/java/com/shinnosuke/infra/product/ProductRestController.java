package com.shinnosuke.infra.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/product")
public class ProductRestController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("")
	public List<ProductDto> selectList(ProductVo productVo) throws Exception {
		List<ProductDto> list = productService.selectList(productVo);
		return list;
	}
	
	@GetMapping("/{prseq}")
	public ProductDto selectOne(ProductDto productDto) throws Exception {
		ProductDto item = productService.selectOne(productDto);
		return item;
	}
	
}
