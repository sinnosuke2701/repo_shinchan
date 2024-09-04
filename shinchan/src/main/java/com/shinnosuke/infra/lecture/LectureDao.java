package com.shinnosuke.infra.lecture;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface LectureDao {
	
	List<LectureDto> selectList();
	
	public int insert(LectureDto LectureDto);
	
	public LectureDto selectOne(LectureDto lectureDto);
	
}
