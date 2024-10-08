package com.shinnosuke.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao MemberDao;
	
	public int selectOneCount(MemberVo memberVo) {
		return MemberDao.selectOneCount(memberVo);
	}
	
	List<MemberDto> selectList(MemberVo memberVo){
		List<MemberDto> members = MemberDao.selectList(memberVo);
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
	
	public int delete(MemberDto memberDto) {
		return MemberDao.delete(memberDto);
	}
	
	public int uelete(MemberDto memberDto) {
		return MemberDao.uelete(memberDto);
	}
	
	public MemberDto selectOneId(MemberDto memberDto) {
		return MemberDao.selectOneId(memberDto);
	}
	
	public MemberDto selectOneLogin(MemberDto memberDto) {
		return MemberDao.selectOneLogin(memberDto);
	}
	
	public int insertLogLogin(MemberDto memberDto) {
		return MemberDao.insertLogLogin(memberDto);
		
	}
	
}
