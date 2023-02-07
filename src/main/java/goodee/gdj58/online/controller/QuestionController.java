package goodee.gdj58.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.QuestionService;
import goodee.gdj58.online.vo.Question;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QuestionController {
	@Autowired QuestionService questionService;	
	//teacherQuestion
	// 수정
	@GetMapping("/teacher/test/question/modifyQuestion")
	public String modifyQuestion(Model model
			           			, @RequestParam("questionNo") int questionNo
								, @RequestParam("testNo") int testNo) {
		log.debug("\u001B[31m"+questionNo+" <- questionNo");
		model.addAttribute("questionNo", questionNo);
		model.addAttribute("testNo", testNo);
		return "teacher/test/question/modifyQuestion";
	}	
	@PostMapping("/teacher/test/question/modifyQuestion")
	public String modifyQuestion(Question question, @RequestParam("testNo") int testNo) {
		questionService.modifyQuestion(question);
		log.debug("\u001B[31m"+testNo+" <- modifyTestNo");
		log.debug("\u001B[31m"+question+" <- modifyQuestion");
		return "redirect:/teacher/test/question/teacherQuestionList?testNo="+testNo;
	}
	
	// 추가
	@GetMapping("/teacher/test/question/addQuestion")
	public String addQuestion(Model model, @RequestParam("testNo") int testNo) {
		model.addAttribute("testNo", testNo);
		return "teacher/test/question/addQuestion";
	}
	@PostMapping("/teacher/test/question/addQuestion")
	public String addQuestion(Question question, @RequestParam("testNo") int testNo) {		
		questionService.addQuestion(question);
	
		return "redirect:/teacher/test/question/teacherQuestionList?testNo="+testNo; // sendRedirect , CM -> C
	}	
	
	
	// 리스트
	@GetMapping("/teacher/test/question/teacherQuestionList")
	public String testList(Model model 
								, @RequestParam("testNo") int testNo
								, @RequestParam(value="currentPage", defaultValue = "1") int currentPage
								, @RequestParam(value="rowPerPage", defaultValue = "10") int rowPerPage) { 
								// int currentPage = request.getParameter("currentPage");
		
		log.debug(currentPage+" <-currentPage");
		log.debug(rowPerPage+" <-rowPerPage");
	
		List<Question> list =questionService.getTeacherQuestionList(testNo, currentPage, rowPerPage);
		log.debug(list+" <-list");
		// request.setAttribute("list", list);
		model.addAttribute("testNo", testNo);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		return "teacher/test/question/teacherQuestionList";	
	}
}
