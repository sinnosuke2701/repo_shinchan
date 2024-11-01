package com.shinnosuke.infra.product;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.shinnosuke.common.util.UtilDateTime;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao ProductDao;
	
	@Autowired
	AmazonS3Client amazonS3Client;
	
	@Autowired
	MultipartFile[] multipartFiles;
	
	public int selectOneCount(ProductVo productVo) {
		return ProductDao.selectOneCount(productVo);
	}
	
		List<ProductDto> selectList(ProductVo productVo){
			return ProductDao.selectList(productVo);
		}
	
	public int insert(ProductDto productDto) {
		for(int i=0; i<multipartFiles.length; i++) {
			
		if(!multipartFiles[i].isEmpty()) {
				
			String className = productDto.getClass().getSimpleName().toString().toLowerCase();		
			String fileName = multipartFiles[i].getOriginalFilename();
			String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
			String uuid = UUID.randomUUID().toString();
			String uuidFileName = uuid + "." + ext;
			String pathModule = className;
			String nowString = UtilDateTime.nowString();
			String pathDate = nowString.substring(0,4) + "/" + nowString.substring(5,7) + "/" + nowString.substring(8,10); 
			String path = pathModule + "/" + type + "/" + pathDate + "/";
//			String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
				
	        ObjectMetadata metadata = new ObjectMetadata();
	        metadata.setContentLength(multipartFiles[i].getSize());
	        metadata.setContentType(multipartFiles[i].getContentType());
	        
	        amazonS3Client.putObject("ehgml1111", path + uuidFileName, multipartFiles[i].getInputStream(), metadata);
				
	        String objectUrl = amazonS3Client.getUrl("ehgml1111", path + uuidFileName).toString();
		        
	        productDto.setPfPath(objectUrl);
	        productDto.setPfOriginalName(fileName);
	        productDto.setPfUuidFileName(uuidFileName);
	        productDto.setPfExt(ext);
	        productDto.setPfSize(multipartFiles[i].getSize());
			
	        productDto.setPfTableName(tableName);
	        productDto.setPfType(type);
//			productDto.setDefaultNy();
	        productDto.setPfSort(maxNumber + i);
	        productDto.setPfPseq(pSeq);
				
	        ProductDao.insertUploaded(productDto);
			}
		}
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
	
	public int insertReview(ProductDto productDto) {
		return ProductDao.insertReview(productDto);
	}
	
	public int insertPayment(ProductDto productDto) {
		return ProductDao.insertPayment(productDto);
	}

}
