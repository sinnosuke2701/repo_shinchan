package com.shinnosuke.infra.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {
	
	List<CodeDto> selectList();
	
}
