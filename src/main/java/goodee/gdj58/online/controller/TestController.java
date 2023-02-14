package goodee.gdj58.online.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.TestService;
import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {
	@Autowired TestService testService;
	
	// testPaperList
	@GetMapping("/student/test/paper/testPaperList")
	public String testPaperList(Model model
							, @RequestParam("testNo") int testNo) {
		
		List<Question> list = testService.getQuestionList(testNo);
		
		List<Map<String, Object>> list2 = testService.getSelectTestPaperListList(testNo);
		log.debug(list2+" <- testPaperList");
		
		
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		model.addAttribute("testNo", testNo);
		
		
		return "student/test/paper/testPaperList";
	}
	
	
	// student/test
	@GetMapping("/student/test/studentTestList")
	public String studentTestList(Model model 
								, @RequestParam(value="currentPage", defaultValue = "1") int currentPage
								, @RequestParam(value="rowPerPage", defaultValue = "10") int rowPerPage
								, HttpSession session) { 
							
		
		Student loginStudent = (Student)session.getAttribute("loginStudent");
		
		// int currentPage = request.getParameter("currentPage");
		log.debug(currentPage+" <-currentPage");
		log.debug(rowPerPage+" <-rowPerPage");
	
		List<Test> list =testService.getStudentTestList(currentPage, rowPerPage);
		log.debug(list+" <-list");
		
		// request.setAttribute("list", list);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("loginStudent", loginStudent);
		return "student/test/studentTestList";	
	}
	// teacher/test
	@GetMapping("/teacher/test/deleteTest")
	public String deleteTest(@RequestParam("testNo") int testNo) {
		testService.deleteTest(testNo);
		return "redirect:/teacher/test/teacherTestList";
	}
	
	@GetMapping("/teacher/test/modifyTest")
	public String modifyTest(Model model, @RequestParam(value="testNo") int testNo) {
		model.addAttribute("testNo", testNo);
		return "teacher/test/modifyTest";
	}
	
	@PostMapping("/teacher/test/modifyTest")
	public String modifyTest(Test test) {
		testService.modifyTest(test);
		log.debug("\u001B[31m"+test+" <- modifyTest");
		return "redirect:/teacher/test/teacherTestList";
	}
	
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
		log.debug(list+" <- teacherTestlist");
		
		// request.setAttribute("list", list);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		return "teacher/test/teacherTestList";	
	}
}
