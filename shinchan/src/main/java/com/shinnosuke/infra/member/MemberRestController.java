package com.shinnosuke.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/member")
public class MemberRestController {
	
	@Autowired
	MemberService memberService;
	
//	@RequestMapping(value = "", method = RequestMethod.GET) //옛날 방식이래 이거 ㅇㅇ...
	@GetMapping("")
	public List<MemberDto> selectList(MemberVo vo) throws Exception {
		List<MemberDto> list = memberService.selectList(vo);
		System.out.println(list+"@@@@@@@@@@@@@");
		return list;
	}
	
	
	@GetMapping("/{memseq}")
	public MemberDto selectOne(MemberDto memberDto) throws Exception {
		MemberDto item = memberService.selectOne(memberDto);
		return item;
	}
	
}
