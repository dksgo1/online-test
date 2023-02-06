package goodee.gdj58.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.TestService;
import goodee.gdj58.online.vo.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {
	@Autowired TestService testService;
	
	// student/test
	@GetMapping("student/test/studentTestList")
	public String studentTestList(Model model 
								, @RequestParam(value="currentPage", defaultValue = "1") int currentPage
								, @RequestParam(value="rowPerPage", defaultValue = "10") int rowPerPage) { 
								// int currentPage = request.getParameter("currentPage");
	
		log.debug(currentPage+" <-currentPage");
		log.debug(rowPerPage+" <-rowPerPage");
	
		List<Test> list =testService.getStudentTestList(currentPage, rowPerPage);
		log.debug(list+" <-list");
		
		// request.setAttribute("list", list);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		return "student/test/studentTestList";	
	}
	// teacher/test
	@GetMapping("/teacher/test/addTest")
	public String addTest() {
		return "teacher/test/addTest";
	}
	@PostMapping("/teacher/test/addTest")
	public String addTest(Test test) {		
		testService.addTest(test);
	
		return "redirect:/teacher/test/teacherTestList"; // sendRedirect , CM -> C
	}	
	
	@GetMapping("teacher/test/teacherTestList")
	public String testList(Model model 
								, @RequestParam(value="currentPage", defaultValue = "1") int currentPage
								, @RequestParam(value="rowPerPage", defaultValue = "10") int rowPerPage) { 
								// int currentPage = request.getParameter("currentPage");
	
		log.debug(currentPage+" <-currentPage");
		log.debug(rowPerPage+" <-rowPerPage");
	
		List<Test> list =testService.getTestList(currentPage, rowPerPage);
		log.debug(list+" <-list");
		
		// request.setAttribute("list", list);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		return "teacher/test/teacherTestList";	
	}
}
