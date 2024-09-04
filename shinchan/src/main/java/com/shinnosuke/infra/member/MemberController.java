package com.shinnosuke.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	MemberService MemberService;
	
	@RequestMapping(value = "/xdm/v1/infra/member/MemberXdmList")
	public String MemberXdmList(Model model) {
		
		
		
		List<MemberDto> members = MemberService.selectList();
		
		model.addAttribute("list3", members);
		
//		for(MemberDto memberdto : members) {
//			System.out.println(memberdto.getSeq() + " | " + memberdto.getMem_Authority() + " | " + memberdto.getMem_Name() + " | " + 
//								memberdto.getMem_Id() + " | " + memberdto.getMem_Password() + " | " + memberdto.getMem_Gender() + " | " + 
//								memberdto.getMem_Birth() + " | " + memberdto.getMem_Email() + " | " + memberdto.getMem_Phone() + " | " + 
//								memberdto.getMem_Desc() + " | " + memberdto.getMem_ReDate() + " | " + memberdto.getMem_MoDate() + " | " + 
//								memberdto.getMem_DelNY());
//		}
	
			return "/xdm/v1/infra/member/MemberXdmList";
	}
	@RequestMapping(value = "/xdm/v1/infra/member/MemberXdmForm")
	public String MemberXdmFrom(){
		
		return "/xdm/v1/infra/member/MemberXdmForm";
	}
	
	@RequestMapping (value = "/xdm/v1/infra/member/MemberXdmInst")
	public String MemberXdmInst(MemberDto memberDto){//함수 선언
		
		MemberService.insert(memberDto); //함수 사용
		
		return "redirect:/xdm/v1/infra/member/MemberXdmList";
	}
	
//	@RequestMapping(value = "/xdm/v1/infra/member/MemberXdmMfom")
//	public String MemberXdmMfom(MemberDto memberDto,Model model) {
//		MemberDto dto = MemberService.selectOne(memberDto);
//		model.addAttribute("item",dto);
//		return "/xdm/v1/infra/member/MemberXdmMfom";
//	}
	
	@RequestMapping(value = "/xdm/v1/infra/member/MemberXdmMfom")
	public String MemberXdmMfom(MemberDto memberDto,Model model) {
		model.addAttribute("item",MemberService.selectOne(memberDto));
		return "/xdm/v1/infra/member/MemberXdmMfom";
	}
	
	@RequestMapping(value = "/xdm/v1/infra/member/MemberXdmPdt")
	public String MemberXdmPdt(MemberDto memberDto) {
		MemberService.update(memberDto);
		return "redirect:/xdm/v1/infra/member/MemberXdmList";
	}
	
}
