package com.shinnosuke.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao MemberDao;
	List<MemberDto> selectList(){
		List<MemberDto> members = MemberDao.selectList();
			return members;
		}
	
	public int insert(MemberDto memberDto) {
		int result = MemberDao.insert(memberDto);
		return result;
	}
	
	public MemberDto selectOne(MemberDto memberDto) {
		return MemberDao.selectOne(memberDto);
	}
	
//	public MemberDto selectOne(MemberDto memberDto) {
//		MemberDto dto = MemberDao.selectOne(memberDto);
//		return dto;
//	}
	
//	public int update(MemberDto memberDto) {
//		int a = MemberDao.update(memberDto);
//		return a;
//	}
	
	public int update(MemberDto memberDto) {
		return MemberDao.update(memberDto);
	}
	
	
}
