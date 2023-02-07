package goodee.gdj58.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.ExampleService;
import goodee.gdj58.online.vo.Example;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExampleController {
	@Autowired ExampleService exampleService;
	
	// 수정
	@GetMapping("/teacher/test/question/example/modifyExample")
	public String modifyExample(Model model
			           			, @RequestParam("questionNo") int questionNo
			           			, @RequestParam("exampleNo") int exampleNo) {
		log.debug("\u001B[31m"+questionNo+" <- questionNo");
		model.addAttribute("questionNo", questionNo);
		model.addAttribute("exampleNo", exampleNo);
		return "teacher/test/question/example/modifyExample";
	}	
	@PostMapping("/teacher/test/question/example/modifyExample")
	public String modifyExample(Example example, @RequestParam("questionNo") int questionNo) {
		exampleService.modifyExample(example);
		log.debug("\u001B[31m"+example+" <- modifyExample");
		return "redirect:/teacher/test/question/example/teacherExampleList?questionNo="+questionNo;
	}	
	
	// 추가
	@GetMapping("/teacher/test/question/example/addExample")
	public String addExample(Model model, @RequestParam("questionNo") int questionNo) {
		model.addAttribute("questionNo", questionNo);
		return "teacher/test/question/example/addExample";
	}
	@PostMapping("/teacher/test/question/example/addExample")
	public String addExample(Example example, @RequestParam("questionNo") int questionNo) {
		exampleService.addExample(example);
		
		return "redirect:/teacher/test/question/example/teacherExampleList?questionNo="+questionNo;
	}
	
	// exampleList
	@GetMapping("/teacher/test/question/example/teacherExampleList")
	public String teacherExampleList(Model model 
								, @RequestParam("questionNo") int questionNo
								, @RequestParam(value="currentPage", defaultValue = "1") int currentPage
								, @RequestParam(value="rowPerPage", defaultValue = "10") int rowPerPage) { 
								// int currentPage = request.getParameter("currentPage");
		
		log.debug(currentPage+" <-currentPage");
		log.debug(rowPerPage+" <-rowPerPage");
	
		List<Example> list = exampleService.getTeacherExampleList(questionNo, currentPage, rowPerPage);
		log.debug(list+" <- examplelist");
		// request.setAttribute("list", list);
		model.addAttribute("questionNo", questionNo);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		return "teacher/test/question/example/teacherExampleList";	
	}	
}
