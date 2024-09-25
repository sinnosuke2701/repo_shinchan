package com.shinnosuke.infra.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {
	
	public int selectOneCount(CodeVo codeVo);
	
	List<CodeDto> selectList(CodeVo codeVo);
	
	public int insert(CodeDto codeDto);
	
	public CodeDto selectOne(CodeDto codeDto);
		
	public int update(CodeDto codeDto);
	
	public List<CodeDto> selectListCodeGroup();
	
	public int uelete (CodeDto codeDto);
	
	public int delete(CodeDto codeDto);
	
    public List<CodeDto> selectListCachedCodeArrayList();
	
}
