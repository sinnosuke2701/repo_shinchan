package com.shinnosuke.infra.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {
	
	List<CodeDto> selectList();
	
	public int insert(CodeDto codeDto);
	
	public CodeDto selectOne(CodeDto codeDto);
		
	public int update(CodeDto codeDto);
	
	public List<CodeDto> selectListCodeGroup();
	
}
