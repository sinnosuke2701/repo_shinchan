package com.shinnosuke.infra.tottenham;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface TottenHamDao {
	
	List<TottenHamDto> selectList();
	
}
