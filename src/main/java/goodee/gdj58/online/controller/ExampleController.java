package goodee.gdj58.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.ExampleService;
import goodee.gdj58.online.vo.Example;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExampleController {
	@Autowired ExampleService exampleService;
	
	@GetMapping("teacher/test/question/example/teacherExampleList")
	public String teacherExampleList(@RequestParam("questionNo") int questionNo) {
		log.debug(questionNo+" <- questionNo");
		
		List<Example> list = exampleService.getTeacherExampleList(questionNo);
		log.debug(list+" <-list");
		
		return "teacher/test/question/example/teacherExampleList";
	}
}
