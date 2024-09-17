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
	public String MemberXdmList(Model model , MemberVo memberVo) {
		
		memberVo.setShStartDate(memberVo.getShStartDate()+ " 00:00:00");
		memberVo.setShEndDate(memberVo.getShEndDate()+ " 23:59:59");
		
		List<MemberDto> members = MemberService.selectList(memberVo);
		
		model.addAttribute("list3", members);
	
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
	
	@RequestMapping(value = "/xdm/v1/infra/member/MemberXdmDele")
	public String MemberXdmDele(MemberDto memberDto) {
		MemberService.delete(memberDto);
		return "redirect:/xdm/v1/infra/member/MemberXdmList";
	}
	
	@RequestMapping (value = "/xdm/v1/infra/member/MemberXdmUele")
	public String MemberXdmUele(MemberDto memberDto) {
		MemberService.uelete(memberDto);
		return "redirect:/xdm/v1/infra/member/MemberXdmList";
	}
	
}
