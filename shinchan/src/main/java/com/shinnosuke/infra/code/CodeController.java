package com.shinnosuke.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinnosuke.infra.codegroup.CodeGroupDto;

@Controller
public class CodeController {

	@Autowired
	CodeService CodeService;

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmList")
	public String codeXdmList(Model model , CodeVo codeVo) {

		List<CodeDto> codes = CodeService.selectList(codeVo);

		model.addAttribute("list1", codes);

//		for(CodeDto codedto : codes)
//			System.out.println(codedto.getSeq() + " | " + codedto.getCd_Name() + " | " + 
//					codedto.getCd_UseNy() + " | " + codedto.getCd_Order() + " | " + 
//					codedto.getCd_Desc() + " | " + codedto.getCd_ReDate() + " | " + 
//					codedto.getCd_MoDate() + " | " + codedto.getCd_DelNY() + " | " + codedto.getCodeGroup_seq());

		return "/xdm/v1/infra/code/codeXdmList";
	}

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmForm")
	public String codeXdmForm(Model model) {
		List<CodeDto> codeGroups = CodeService.selectListCodeGroup();
		model.addAttribute("listCodeGroup", codeGroups);
		return "/xdm/v1/infra/code/codeXdmForm";
	}

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {

		CodeService.insert(codeDto);

		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmMfom")
	public String codeXdmMfom(CodeDto codeDto, Model model) {
		model.addAttribute("item", CodeService.selectOne(codeDto));
		List<CodeDto> codeGroups = CodeService.selectListCodeGroup();
		model.addAttribute("listCodeGroup", codeGroups);
		return "/xdm/v1/infra/code/codeXdmMfom";
	}

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmPdt")
	public String codeXdmPdt(CodeDto codeDto) {
		CodeService.update(codeDto);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}
		
	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmDele")
	public String codeXdmMfom(CodeDto codeDto) {
		CodeService.delete(codeDto);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmUele")
	public String codeXdmUele(CodeDto codeDto) {
		CodeService.uelete(codeDto);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}
	
}
