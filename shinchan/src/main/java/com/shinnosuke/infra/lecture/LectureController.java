package com.shinnosuke.infra.lecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LectureController {

	@Autowired
	LectureService LectureService;
	
	@RequestMapping(value = "/xdm/v1/infra/lecture/LectureXdmList")
	public String LectureXdmList(Model model) {
		
		List<LectureDto>  lectures = LectureService.selectList();
		
		model.addAttribute("list2",lectures);
		
//		for(LectureDto lecturedto : lectures) {
//			System.out.println(lecturedto.getSeq() + " | " + lecturedto.getLec_Type() + " | " + lecturedto.getLec_Name() + " | " + 
//								lecturedto.getLec_Price() + " | " + lecturedto.getLec_Instructor() + " | " + lecturedto.getLec_StratCR() + " | " + 
//								lecturedto.getLec_EndCR() + " | " + lecturedto.getLec_StartLearn() + " | " + lecturedto.getLec_EndLearn() + " | " + 
//								lecturedto.getLec_Place() + " | " + lecturedto.getLec_Detail() + " | " + lecturedto.getLec_ReDate() + " | " + 
//								lecturedto.getLec_MoDate() + " | " + lecturedto.getLec_DelNY());
//		}
		
		return "/xdm/v1/infra/lecture/LectureXdmList";
	}
		
	@RequestMapping(value = "/xdm/v1/infra/lecture/LectureXdmForm")
	public String LectureXdmForm() {
		return "/xdm/v1/infra/lecture/LectureXdmForm";
	}
	
	@RequestMapping(value = "/xdm/v1/infra/lecture/LectureXdmInst")
	public String LectureXdmInst(LectureDto lectureDto) {
//		System.out.println(LectureDto.getLec_StartLearn());
		LectureService.insert(lectureDto);
		return "redirect:/xdm/v1/infra/lecture/LectureXdmList";
	}
	
//	@RequestMapping(value = "/xdm/v1/infra/lecture/LectureXdmMfom")
//	public String LectureXdmMfom(LectureDto lectureDto , Model model) {
//		LectureDto dto = LectureService.selcetOne(lectureDto);
//		model.addAttribute("item", dto);
//		return "/xdm/v1/infra/lecture/LectureXdmMfom";
//	}
	
	@RequestMapping(value = "/xdm/v1/infra/lecture/LectureXdmMfom")
	public String LectureXdmMfom(LectureDto lectureDto , Model model) {
		model.addAttribute("item", LectureService.selcetOne(lectureDto));
		return "/xdm/v1/infra/lecture/LectureXdmMfom";
	}
	
}
