package com.shinnosuke.infra.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.Session;
import com.shinnosuke.common.constants.Constants;
import com.shinnosuke.common.util.UtilDateTime;
import com.shinnosuke.infra.product.ProductDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	MemberService MemberService;
	
	@RequestMapping(value = "/xdm/v1/infra/member/MemberXdmList")
	public String MemberXdmList(Model model ,@ModelAttribute("vo")  MemberVo memberVo ,HttpSession httpSession) {
		
//		memberVo.setShStartDate(memberVo.getShStartDate()+ " 00:00:00");
//		memberVo.setShEndDate(memberVo.getShEndDate()+ " 23:59:59");
		/* 초기값 세팅이 없는 경우 사용 */
		memberVo.setShStartDate(memberVo.getShStartDate() == null || memberVo.getShStartDate() == "" ? null : UtilDateTime.add00TimeString(memberVo.getShStartDate()));
		memberVo.setShEndDate(memberVo.getShEndDate() == null || memberVo.getShEndDate() == "" ? null : UtilDateTime.add59TimeString(memberVo.getShEndDate()));
		
		memberVo.setParamsPaging(MemberService.selectOneCount(memberVo));
		
		List<MemberDto> members = MemberService.selectList(memberVo);
		
		model.addAttribute("list3", members);
		
		System.out.println("sessSeqXdm: " + httpSession.getAttribute("sessSeqXdm"));
		System.out.println("sessIdXdm: " + httpSession.getAttribute("sessIdXdm"));
		System.out.println("sessNameXdm: " + httpSession.getAttribute("sessNameXdm"));
		
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
	
	@RequestMapping(value = "/xdm/v1/infra/member/signinXdmForm")
	public String signinXdmForm() {
		return "/xdm/v1/infra/member/signinXdmForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/xdm/v1/infra/member/signinXdmProc")
	public Map<String, Object> signinXdmProc(MemberDto memberDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		System.out.println("@@@@@@@@@@@@@@@@@@@@");
		MemberDto rtMember = MemberService.selectOneId(memberDto);
		if (rtMember != null) {
//			dto.setIfmmPassword(UtilSecurity.encryptSha256(dto.getIfmmPassword()));
			MemberDto rtMember2 = MemberService.selectOneLogin(memberDto);

			if (rtMember2 != null) {
				
//				if(dto.getAutoLogin() == true) {
//					UtilCookie.createCookie(
//							Constants.COOKIE_SEQ_NAME_XDM, 
//							rtMember2.getIfmmSeq(), 
//							Constants.COOKIE_DOMAIN_XDM, 
//							Constants.COOKIE_PATH_XDM, 
//							Constants.COOKIE_MAXAGE_XDM);
//				} else {
//					// by pass
//				}
//	
				
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqXdm", rtMember2.getMemseq());
				httpSession.setAttribute("sessIdXdm", rtMember2.getMemId());
				httpSession.setAttribute("sessNameXdm", rtMember2.getMemName());
//
//				rtMember2.setMemSocialLoginCd(103);
//				rtMember2.setlgResultNy(1);
//				MemberService.insertLogLogin(rtMember2);

				returnMap.put("rt", "success");
			} else {
//				memberDto.setMemSocialLoginCd(103);
//				memberDto.setMemseq(rtMember.getMemseq());
//				memberDto.setlgResultNY(0);
//				MemberService.insertLogLogin(memberDto);

				returnMap.put("rt", "fail");
			}
		} else {
//			memberDto.setMemSocialLoginCd(103);
//			memberDto.setlgResultNY(0);
//			MemberService.insertLogLogin(memberDto);

			returnMap.put("rt", "fail");
		}
		System.out.println("sessSeqXdm: " + httpSession.getAttribute("sessSeqXdm"));
		System.out.println("sessIdXdm: " + httpSession.getAttribute("sessIdXdm"));
		System.out.println("sessNameXdm: " + httpSession.getAttribute("sessNameXdm"));
		return returnMap;
		
	}
	
	@RequestMapping(value = "/xdm/v1/infra/index/indexXdmView")
	public String indexXdmView() {
		return "/xdm/v1/infra/index/indexXdmView";
	}
	
	@ResponseBody
	@RequestMapping(value = "/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.invalidate();
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	@RequestMapping (value = "/xdm/v1/infra/member/MemberUsrInst")
	public String MemberUsrInst(MemberDto memberDto){//함수 선언
		MemberService.insert(memberDto); //함수 사용
		return "redirect:/usr/v1/infra/code/signinUsrForm";
	}
	
	@RequestMapping(value = "/usr/v1/infra/product/accountUsrMfom")
	public String accountUsrMfom(Model model , MemberDto memberDto,HttpSession httpSession) {
//		memberDto.setMemseq(httpSession.getAttribute(""));
		model.addAttribute("item",MemberService.selectOne(memberDto));
		return "/usr/v1/infra/product/accountUsrMfom";
	}
	
	@RequestMapping(value = "/usr/v1/infra/member/signupUsrForm")
	public String signupUsrForm() {
		return "/usr/v1/infra/member/signupUsrForm";
	}
	
	@RequestMapping(value = "/usr/v1/infra/member/signinUsrForm")
	public String signinUsrForm() {
		return "/usr/v1/infra/member/signinUsrForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/xdm/v1/infra/member/signinUsrProc")
	public Map<String, Object> signinUsrProc(MemberDto memberDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		MemberDto rtMember = MemberService.selectOneId(memberDto);
		if (rtMember != null) {
//			dto.setIfmmPassword(UtilSecurity.encryptSha256(dto.getIfmmPassword()));
			MemberDto rtMember2 = MemberService.selectOneLogin(memberDto);
			if (rtMember2 != null) {
				
//				if(dto.getAutoLogin() == true) {
//					UtilCookie.createCookie(
//							Constants.COOKIE_SEQ_NAME_XDM, 
//							rtMember2.getIfmmSeq(), 
//							Constants.COOKIE_DOMAIN_XDM, 
//							Constants.COOKIE_PATH_XDM, 
//							Constants.COOKIE_MAXAGE_XDM);
//				} else {
//					// by pass
//				}
//	
				
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqUsr", rtMember2.getMemseq());
				httpSession.setAttribute("sessIdUsr", rtMember2.getMemId());
				httpSession.setAttribute("sessNameUsr", rtMember2.getMemName());
//
//				rtMember2.setMemSocialLoginCd(103);
//				rtMember2.setlgResultNy(1);
//				MemberService.insertLogLogin(rtMember2);
				returnMap.put("rt", "success");
			} else {
//				memberDto.setMemSocialLoginCd(103);
//				memberDto.setMemseq(rtMember.getMemseq());
//				memberDto.setlgResultNY(0);
//				MemberService.insertLogLogin(memberDto);
				returnMap.put("rt", "fail");
			}
		} else {
//			memberDto.setMemSocialLoginCd(103);
//			memberDto.setlgResultNY(0);
//			MemberService.insertLogLogin(memberDto);
			returnMap.put("rt", "fail");
		}
		System.out.println("sessSeqUsr: " + httpSession.getAttribute("sessSeqUsr"));
		System.out.println("sessIdUsr: " + httpSession.getAttribute("sessIdUsr"));
		System.out.println("sessNameUsr: " + httpSession.getAttribute("sessNameUsr"));
		return returnMap;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/signoutUsrProc")
	public Map<String, Object> signoutUsrProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.invalidate();
		returnMap.put("rt", "success");
		return returnMap;
	}
	
}
