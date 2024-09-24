package com.shinnosuke.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinnosuke.common.util.UtilDateTime;

@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupService CodeGroupService;

	@RequestMapping(value = "/xdm/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList(Model model , @ModelAttribute("vo") CodeGroupVo codeGroupVo) {
		
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