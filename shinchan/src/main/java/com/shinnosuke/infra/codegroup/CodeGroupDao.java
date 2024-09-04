package com.shinnosuke.infra.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupDao {
	
	List<CodeGroupDto> selectList();
	
	public int insert(CodeGroupDto codeGroupDto);
	
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto);
		
	public int update(CodeGroupDto codeGroupDto);
	
}
