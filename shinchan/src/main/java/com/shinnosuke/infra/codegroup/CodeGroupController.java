package com.shinnosuke.infra.codegroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shinnosuke.common.util.UtilDateTime;

@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupService CodeGroupService;

	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList(Model model , @ModelAttribute("vo") CodeGroupVo codeGroupVo) throws IOException {
		
//		codeGroupVo.setSh_DateStart(codeGroupVo.getSh_DateStart()+ " 00:00:00");
//		codeGroupVo.setSh_DateEnd(codeGroupVo.getSh_DateEnd()+ " 23:59:59");
		
		/* 초기값 세팅이 없는 경우 사용 */
		codeGroupVo.setSh_DateStart(codeGroupVo.getSh_DateStart() == null || codeGroupVo.getSh_DateStart() == "" ? null : UtilDateTime.add00TimeString(codeGroupVo.getSh_DateStart()));
		codeGroupVo.setSh_DateEnd(codeGroupVo.getSh_DateEnd() == null || codeGroupVo.getSh_DateEnd() == "" ? null : UtilDateTime.add59TimeString(codeGroupVo.getSh_DateEnd()));

		codeGroupVo.setParamsPaging(CodeGroupService.selectOneCount(codeGroupVo));
		
		List<CodeGroupDto> codegroups = CodeGroupService.selectList(codeGroupVo);
		model.addAttribute("list",codegroups);
		
		//모든객체를 html로 넘길때 model을 사용 / codegroups의 내용을 list 에 담아서 리턴으로 보냄 .
//		model.addAttribute("list",CodeGroupService.selectList()); //내용을 담을게 없으면 축약형.
		
//	        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq"); /*URL*/
//	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=s3EoCZd6XTrLGuF1DyqzsTVzxBYJUAd8Rv8rDDBxPZQJU1gY73d00DuEE6tFGhcHN6nnesTAP%2Fj2n5SBd9zhDA%3D%3D"); /*Service Key*/
//	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
//	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /*한 페이지 결과 수*/
//	        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) default : xml*/
//	        urlBuilder.append("&" + URLEncoder.encode("YYYY","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*년도*/
//	        urlBuilder.append("&" + URLEncoder.encode("MM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*실적월*/
//	        URL url = new URL(urlBuilder.toString());
//	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//	        conn.setRequestMethod("GET");
//	        conn.setRequestProperty("Content-type", "application/json");
//	        System.out.println("Response code: " + conn.getResponseCode());
//	        BufferedReader rd;
//	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	        } else {
//	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//	        }
//	        StringBuilder sb = new StringBuilder();
//	        String line;
//	        while ((line = rd.readLine()) != null) {
//	            sb.append(line);
//	        }
//	        rd.close();
//	        conn.disconnect();
//	        System.out.println(sb.toString());
//	        
//	        ObjectMapper objectMapper = new ObjectMapper();
//			JsonNode node = objectMapper.readTree(sb.toString());
//			
//			System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
//			System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
//			System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("body").get("items").get(0).get("KIT_PROD_QTY").asText());
			
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getMmCovidDagnsRgntExprtStusInq"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=s3EoCZd6XTrLGuF1DyqzsTVzxBYJUAd8Rv8rDDBxPZQJU1gY73d00DuEE6tFGhcHN6nnesTAP%2Fj2n5SBd9zhDA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) default : xml*/
        urlBuilder.append("&" + URLEncoder.encode("YYYY","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*년도*/
        urlBuilder.append("&" + URLEncoder.encode("MM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*실적월*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node = objectMapper.readTree(sb.toString());
		
		System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("body").get("items").get(1).get("KIT_EXPRT_QTY").asText());
		return "xdm/v1/infra/codegroup/codeGroupXdmList";

	}
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmForm")
	public String codeGroupXdmForm() {
		
		return "xdm/v1/infra/codegroup/codeGroupXdmForm";
	}
	
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {
		
//		System.out.println("CodeGroupDto.getCg_Name: " + CodeGroupDto.getCg_Name());
		
		CodeGroupService.insert(codeGroupDto);
		
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
//	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmMfom")
//	public String codeGroupXdmMfom(CodeGroupDto codeGroupDto, Model model) {
//		CodeGroupDto dto = CodeGroupService.selectOne(codeGroupDto);
//		model.addAttribute("item",dto);
//		return "/xdm/v1/infra/codegroup/codeGroupXdmMfom";
//	}
	
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmMfom")
	public String codeGroupXdmMfom(CodeGroupDto codeGroupDto, Model model) {
		model.addAttribute("item",CodeGroupService.selectOne(codeGroupDto));
		return "xdm/v1/infra/codegroup/codeGroupXdmMfom";
	}
	
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmPdt")
	public String codeGroupXdmPdt(CodeGroupDto codeGroupDto) {
		CodeGroupService.update(codeGroupDto);
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmDele")
	public String codeGroupXdmDele(CodeGroupDto codeGroupDto) {
		CodeGroupService.delete(codeGroupDto);
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmUele")
	public String codeGroupXdmUele(CodeGroupDto codeGroupDto) {
		CodeGroupService.uelete(codeGroupDto);
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	
}	