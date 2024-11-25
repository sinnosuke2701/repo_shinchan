package com.shinnosuke.infra.product;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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
	
	List<ProductDto> selectListPayment(ProductDto productDto){
		return ProductDao.selectListPayment(productDto);
	}
	
	 // application.properties에서 Secret Key를 불러옵니다.
    @Value("${kakao.pay.secretKey}")
    private String KAKAO_PAY_ADMIN_KEY;

    // 카카오페이 결제 준비
    public ProductDto kakaoPay(Map<String, Object> params) {
        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + KAKAO_PAY_ADMIN_KEY);

        // 결제 준비에 필요한 파라미터 설정
        MultiValueMap<String, Object> payParams = new LinkedMultiValueMap<>();
        payParams.add("cid", "TC0ONETIME");
        payParams.add("partner_order_id", "KAO20230318001");
        payParams.add("partner_user_id", "kakaopayTest");
        payParams.add("item_name", params.get("item_name"));
        payParams.add("quantity", params.get("quantity"));
        payParams.add("total_amount", params.get("total_amount"));
        payParams.add("tax_free_amount", params.get("tax_free_amount"));
        payParams.add("approval_url", "http://localhost:8080/pay/success");
        payParams.add("cancel_url", "http://localhost:8080/pay/cancel");
        payParams.add("fail_url", "http://localhost:8080/pay/fail");

        // RestTemplate을 사용해 API 호출
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(payParams, headers);
        RestTemplate template = new RestTemplate();
        String url = "https://kapi.kakao.com/v1/payment/ready";

        // API 호출 및 응답 확인
        try {
            ResponseEntity<ProductDto> response = template.exchange(url, HttpMethod.POST, request, ProductDto.class);
            ProductDto res = response.getBody();
            return res;
        } catch (Exception e) {
            e.printStackTrace(); // 예외 메시지 출력
            return null;
        }
    }

}
