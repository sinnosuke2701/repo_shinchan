package com.shinnosuke.infra.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CodeService {
	
	@Autowired
	private CodeDao CodeDao;
	
	public int selectOneCount(CodeVo codeVo) {
		return CodeDao.selectOneCount(codeVo);
	}
	
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
	
	@PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) CodeDao.selectListCachedCodeArrayList();
//		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		CodeDto.cachedCodeArrayList.clear(); 
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
	}
	
	public static void clear() throws Exception {
		CodeDto.cachedCodeArrayList.clear();
	}
	
	
	public static List<CodeDto> selectListCachedCode(String ifcgSeq) throws Exception {
		List<CodeDto> rt = new ArrayList<CodeDto>();
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCodeGroup_seq().equals(ifcgSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}

	
	public static String selectOneCachedCode(int code) throws Exception {
		String rt = "";
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCdseq().equals(Integer.toString(code))) {
				rt = codeRow.getCd_Name();
			} else {
				// by pass
			}
		}
		return rt;
	}
	
	
}
