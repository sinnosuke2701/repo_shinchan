package com.shinnosuke.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
	
	@Autowired
	private CodeDao CodeDao;
		List<CodeDto> selectList(){
			List<CodeDto> codes = CodeDao.selectList();
					return codes;
		}
	
}
