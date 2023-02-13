package goodee.gdj58.online.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.PaperService;
import goodee.gdj58.online.vo.Paper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PaperController {
	@Autowired PaperService paperService;
	
	@PostMapping("/student/test/paper/addPaper")
	public String addPaper(@RequestParam("studentNo") int studentNo, Paper paper) {
		
		paperService.addPaper(studentNo, paper);
		
		log.debug(studentNo+" <-studentNo");
		log.debug(paper.getQuestionNo()+" <-questionNo");
		log.debug(paper.getAnswer()+" <-answer");	
		
		return "redirect:/student/test/studentTestList";
	}
}