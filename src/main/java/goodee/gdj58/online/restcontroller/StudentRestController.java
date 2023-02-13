package goodee.gdj58.online.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import goodee.gdj58.online.service.StudentService;

@RestController
public class StudentRestController {
	
	@Autowired StudentService studentService;
	
	@GetMapping("/employee/student/studentIdck")
	public String studentIdck(@RequestParam(value = "studentId") String studentId) {
		return studentService.getStudentId(studentId);
	}
}
