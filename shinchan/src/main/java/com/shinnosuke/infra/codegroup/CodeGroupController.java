package com.shinnosuke.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupService CodeGroupService;

	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList(Model model) {

		List<CodeGroupDto> codegroups = CodeGroupService.selectList();

		model.addAttribute("list",codegroups);
		//모든객체를 html로 넘길때 model을 사용 / codegroups의 내용을 list 에 담아서 리턴으로 보냄 .
//		model.addAttribute("list",CodeGroupService.selectList()); //내용을 담을게 없으면 축약형.
		
		
		
//		System.out.println(codegroups.size());
//		
//		for (CodeGroupDto codegroupdto : codegroups) {
//			System.out.println(codegroupdto.getSeq() + " | " + codegroupdto.getCg_Name() + " | "
//					+ codegroupdto.getCg_UseNY() + " | " + codegroupdto.getCg_Order() + " | "
//					+ codegroupdto.getCg_Desc() + " | " + codegroupdto.getCg_ReDate() + " | "
//					+ codegroupdto.getCg_MoDate() + " | " + codegroupdto.getCg_DelNY());
//		}

		return "/xdm/v1/infra/codegroup/codeGroupXdmList";

	}

	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmForm")
	public String codeGroupXdmForm() {
		
		return "/xdm/v1/infra/codegroup/codeGroupXdmForm";
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
		return "/xdm/v1/infra/codegroup/codeGroupXdmMfom";
	}
	
	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmPdt")
	public String codeGroupXdmPdt(CodeGroupDto codeGroupDto) {
		CodeGroupService.update(codeGroupDto);
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
}
