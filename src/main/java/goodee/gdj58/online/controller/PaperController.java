package goodee.gdj58.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.PaperService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PaperController {
	@Autowired PaperService paperService;
	
	@PostMapping("/student/test/paper/addPaper")
	public String addPaper(@RequestParam("studentNo") int studentNo
							, @RequestParam(value="questionNo") int[] questionNo
							, @RequestParam(value="answer") int[] answer) {
		
		paperService.addPaper(studentNo, questionNo, answer);
		
		log.debug(studentNo+" <-studentNo");
		log.debug(questionNo+" <-questionNo");
		log.debug(answer+" <-answer");	
		
		return "redirect:/student/test/studentTestList";
	}
}