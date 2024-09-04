	package com.shinnosuke.infra.lecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureService {

	@Autowired
	private LectureDao LectureDao;
	
		List<LectureDto> selectList(){
			List<LectureDto> lectures = LectureDao.selectList();
			
			return lectures;
		}
	
		public int insert(LectureDto LectureDto) {
			int result = LectureDao.insert(LectureDto);
			return result;
		}
		
		public LectureDto selcetOne(LectureDto lectureDto) {
			LectureDto dto = LectureDao.selectOne(lectureDto);
			return dto;
		}
		
		
}
