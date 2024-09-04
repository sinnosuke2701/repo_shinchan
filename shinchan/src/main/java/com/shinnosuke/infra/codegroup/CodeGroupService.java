package com.shinnosuke.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CodeGroupService {
	
	
	@Autowired
//	private CodeGroupDao CodeGroupDao;
//		List<CodeGroupDto> selectList(){
//			List<CodeGroupDto> codegroups =  CodeGroupDao.selectList();
//			return codegroups;
//		}
	
		private CodeGroupDao CodeGroupDao;
		List<CodeGroupDto> selectList(){
			
			return CodeGroupDao.selectList();
		}
		
		
		//단축형..
		public int insert(CodeGroupDto codeGroupDto) {
			return CodeGroupDao.insert(codeGroupDto);
		}

		
		
//		public int insert(CodeGroupDto codeGroupDto) {
//			int result = CodeGroupDao.insert(codeGroupDto);
//			return result;
//		}
		
		
		 public CodeGroupDto selectOne(CodeGroupDto codeGroupDto){
			 CodeGroupDto dto = CodeGroupDao.selectOne(codeGroupDto);
			return dto;
		}
		
//		public CodeGroupDto selectOne(CodeGroupDto codeGroupDto) {
//			return codeGroupDao.selectOne(codGroupDto);
//		}
		 
//		 public int update(CodeGroupDto codeGroupDto) {
//			 int a = CodeGroupDao.update(codeGroupDto);
//			 return a;
//		 }
		 
		 public int update(CodeGroupDto codeGroupDto) {
			 return CodeGroupDao.update(codeGroupDto);
		 }
		 
}
