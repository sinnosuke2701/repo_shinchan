package com.shinnosuke.infra.member;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	
	List<MemberDto> selectList();
	
	public int insert(MemberDto memberDto);
	
	public MemberDto selectOne(MemberDto memberDto);
	
	public int update(MemberDto memberDto);
	
}
