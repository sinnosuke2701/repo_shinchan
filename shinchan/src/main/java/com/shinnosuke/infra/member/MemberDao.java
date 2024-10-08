package com.shinnosuke.infra.member;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	
	public int selectOneCount(MemberVo memberVo);
	
	List<MemberDto> selectList(MemberVo memberVo);
	
	public int insert(MemberDto memberDto);
	
	public MemberDto selectOne(MemberDto memberDto);
	
	public int update(MemberDto memberDto);
	
	public int delete(MemberDto memberDto);

	public int uelete(MemberDto memberDto);
	
	public MemberDto selectOneId(MemberDto memberDto);
	
	public MemberDto selectOneLogin(MemberDto memberDto);
	
	public int insertLogLogin(MemberDto memberDto);
}
