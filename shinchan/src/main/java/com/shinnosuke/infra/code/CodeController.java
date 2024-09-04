package com.shinnosuke.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

	@Autowired
	CodeService CodeService;
	
	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmList")
		public String codeXdmList(Model model) {
		
		List<CodeDto> codes = CodeService.selectList();
	
		model.addAttribute("list1",codes);
		
		
//		for(CodeDto codedto : codes)
//			System.out.println(codedto.getSeq() + " | " + codedto.getCd_Name() + " | " + 
//					codedto.getCd_UseNy() + " | " + codedto.getCd_Order() + " | " + 
//					codedto.getCd_Desc() + " | " + codedto.getCd_ReDate() + " | " + 
//					codedto.getCd_MoDate() + " | " + codedto.getCd_DelNY() + " | " + codedto.getCodeGroup_seq());
			
		return "/xdm/v1/infra/code/codeXdmList";
	}
	
}
