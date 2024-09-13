package com.shinnosuke.infra.product;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {
	
	List<ProductDto> selectList(ProductDto productDto);
	
}
