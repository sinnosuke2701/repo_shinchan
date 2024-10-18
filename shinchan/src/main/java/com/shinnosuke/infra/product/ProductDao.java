package com.shinnosuke.infra.product;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {
	
	public int selectOneCount(ProductVo productVo);
	
	List<ProductDto> selectList(ProductVo productVo);
	
	public int insert(ProductDto productDto);
	
	public ProductDto selectOne(ProductDto productDto);
	
	public int update(ProductDto productDto);
	
	public int delete(ProductDto productDto);
	
	public int uelete(ProductDto productDto);
	
	List<ProductDto> selectListReview(ProductDto productDto);
	
	public int insertReview(ProductDto productDto);
	
//	public int insertOrder(ProductDto productDto);
}
