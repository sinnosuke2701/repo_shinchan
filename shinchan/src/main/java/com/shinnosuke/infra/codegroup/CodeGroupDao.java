package com.shinnosuke.infra.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupDao {
	
	public int selectOneCount(CodeGroupVo codeGroupVo);
	
	List<CodeGroupDto> selectList(CodeGroupVo codeGroupVo);
	
	public int insert(CodeGroupDto codeGroupDto);
	
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto);
		
	public int update(CodeGroupDto codeGroupDto);
	
	public int delete(CodeGroupDto codeGroupDto);
	
	public int uelete(CodeGroupDto codeGroupDto);	
	
//	public int reseq(CodeGroupDto codeGroupDto);
	
}
