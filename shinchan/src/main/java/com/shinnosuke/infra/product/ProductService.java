package com.shinnosuke.infra.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao ProductDao;
	
	public int selectOneCount(ProductVo productVo) {
		return ProductDao.selectOneCount(productVo);
	}
	
		List<ProductDto> selectList(ProductVo productVo){
			return ProductDao.selectList(productVo);
		}
	
	public int insert(ProductDto productDto) {
		
		return ProductDao.insert(productDto);
	}
	
	public ProductDto selectOne(ProductDto productDto) {
		return ProductDao.selectOne(productDto);
	}
	
	public int update(ProductDto productDto) {
		return ProductDao.update(productDto);
				
	}
	
	public int delete(ProductDto productDto) {
		return ProductDao.delete(productDto);
	}
	
	public int uelete(ProductDto productDto) {
		return ProductDao.uelete(productDto);
	}
	
	List<ProductDto> selectListReview(ProductDto productDto){
		return ProductDao.selectListReview(productDto);
	}
	
}
