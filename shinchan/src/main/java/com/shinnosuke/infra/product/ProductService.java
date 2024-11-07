package com.shinnosuke.infra.product;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.shinnosuke.common.util.UtilDateTime;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao ProductDao;
	
	@Autowired
	AmazonS3Client amazonS3Client;
	
	public int selectOneCount(ProductVo productVo) {
		return ProductDao.selectOneCount(productVo);
	}
	
		List<ProductDto> selectList(ProductVo productVo){
			return ProductDao.selectList(productVo);
		}
	
	public int insert(ProductDto productDto , int type) throws Exception {
		ProductDao.insert(productDto);
		for(int i=0; i<productDto.getUploadFiles().length; i++) {
			
		if(!productDto.getUploadFiles()[i].isEmpty()) {
				
			String className = productDto.getClass().getSimpleName().toString().toLowerCase();		
			String fileName = productDto.getUploadFiles()[i].getOriginalFilename();
			String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
			String uuid = UUID.randomUUID().toString();
			String uuidFileName = uuid + "." + ext;
			String pathModule = className;
			String nowString = UtilDateTime.nowString();
			String pathDate = nowString.substring(0,4) + "/" + nowString.substring(5,7) + "/" + nowString.substring(8,10); 
			String path = pathModule + "/" + type + "/" + pathDate + "/";
//			String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
				
	        ObjectMetadata metadata = new ObjectMetadata();
	        metadata.setContentLength(productDto.getUploadFiles()[i].getSize());
	        metadata.setContentType(productDto.getUploadFiles()[i].getContentType());
	        
	        amazonS3Client.putObject("shinnosuke", path + uuidFileName, productDto.getUploadFiles()[i].getInputStream(), metadata);
				
	        String objectUrl = amazonS3Client.getUrl("shinnosuke", path + uuidFileName).toString();
		    System.out.println(objectUrl + "@2@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	        productDto.setPfPath(objectUrl);
	        productDto.setPfOriginalName(fileName);
	        productDto.setPfUuidFileName(uuidFileName);
	        productDto.setPfExt(ext);
	        productDto.setPfSize(productDto.getUploadFiles()[i].getSize());
//			
//	        productDto.setPfTableName(tableName);
	        productDto.setPfType(type);
//			productDto.setPfDefaultNy();
//	        productDto.setPfSort(maxNumber + i);
	        productDto.setPfPseq(productDto.getPrseq());
				
	        ProductDao.insertUploaded(productDto);
			}
		}
		return 1;
	}
	
	public int insertUploaded(ProductDto productDto) {
		return ProductDao.insertUploaded(productDto);
	}
	
	public ProductDto selectOne(ProductDto productDto) {
		return ProductDao.selectOne(productDto);
	}
	
	public int update(ProductDto productDto , int type) throws Exception {
		ProductDao.update(productDto);
		for(int i=0; i<productDto.getUploadFiles().length; i++) {
			
		if(!productDto.getUploadFiles()[i].isEmpty()) {
				
			String className = productDto.getClass().getSimpleName().toString().toLowerCase();		
			String fileName = productDto.getUploadFiles()[i].getOriginalFilename();
			String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
			String uuid = UUID.randomUUID().toString();
			String uuidFileName = uuid + "." + ext;
			String pathModule = className;
			String nowString = UtilDateTime.nowString();
			String pathDate = nowString.substring(0,4) + "/" + nowString.substring(5,7) + "/" + nowString.substring(8,10); 
			String path = pathModule + "/" + type + "/" + pathDate + "/";
//			String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
				
	        ObjectMetadata metadata = new ObjectMetadata();
	        metadata.setContentLength(productDto.getUploadFiles()[i].getSize());
	        metadata.setContentType(productDto.getUploadFiles()[i].getContentType());
	        
	        amazonS3Client.putObject("shinnosuke", path + uuidFileName, productDto.getUploadFiles()[i].getInputStream(), metadata);
				
	        String objectUrl = amazonS3Client.getUrl("shinnosuke", path + uuidFileName).toString();
		    System.out.println(objectUrl + "@2@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	        productDto.setPfPath(objectUrl);
	        productDto.setPfOriginalName(fileName);
	        productDto.setPfUuidFileName(uuidFileName);
	        productDto.setPfExt(ext);
	        productDto.setPfSize(productDto.getUploadFiles()[i].getSize());
//			
//	        productDto.setPfTableName(tableName);
	        productDto.setPfType(type);
//			productDto.setPfDefaultNy();
//	        productDto.setPfSort(maxNumber + i);
	        productDto.setPfPseq(productDto.getPrseq());
				
	        ProductDao.insertUploaded(productDto);
			}		
		}
		return 2;
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
