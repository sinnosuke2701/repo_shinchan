package com.shinnosuke.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinnosuke.infra.codegroup.CodeGroupDto;

@Service
public class CodeService {
	
	@Autowired
	private CodeDao CodeDao;
		List<CodeDto> selectList(CodeVo codeVo){
			
		return CodeDao.selectList(codeVo);
		}
	
	public int insert(CodeDto codeDto) {
		
		return CodeDao.insert(codeDto);
	}
		
	public CodeDto selectOne(CodeDto codeDto){
		 CodeDto dto = CodeDao.selectOne(codeDto);
		return dto;
	}
	
	public int update(CodeDto codeDto) {
		 return CodeDao.update(codeDto);
	 }
	
//	public List<CodeDto> selectListCodeGroup(){
//		List<CodeDto> codeGroups = CodeDao.selectListCodeGroup();
//		return codeGroups;
//	}
	
	public List<CodeDto> selectListCodeGroup(){	
		return CodeDao.selectListCodeGroup();
	}
	
	public int uelete (CodeDto codeDto) {
		return CodeDao.uelete(codeDto);
	}
	
	public int delete(CodeDto codeDto) {
		return CodeDao.delete(codeDto);
	}
	
}
