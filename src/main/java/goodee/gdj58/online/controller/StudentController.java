package goodee.gdj58.online.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.service.StudentService;
import goodee.gdj58.online.vo.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentController {
	@Autowired StudentService studentService;
	@Autowired IdService idService; 	
	// student
	
	// pw 수정폼
	@GetMapping("/student/modifyStudentPw")
	public String modifyStudentPw() {
		return "student/modifyStudentPw";
	}
	
	// pw 수정액션
	@PostMapping("/student/modifyStudentPw")
	public String modifyStudentPw(HttpSession session
							, @RequestParam(value="oldPw") String oldPw
							, @RequestParam(value="newPw") String newPw) {
		// 로그인 후 호출 가능
		Student loginStudent = (Student)session.getAttribute("loginStudent");
		studentService.updateStudentPw(loginStudent.getStudentNo(), oldPw, newPw);
		
		return "redirect:/student/test/studentTestList";
	}	
	
	// 로그인
	@GetMapping("/loginStudent")
	public String loginStudent() {
		return "student/loginStudent";
	}
	// 로그인 액션
	@PostMapping("/loginStudent")
	public String loginStudent(HttpSession session, Student student) {
		Student resultStudent = studentService.login(student);
		session.setAttribute("loginStudent", resultStudent);
		return "redirect:/student/test/studentTestList";
	}
	
	// logout
	@GetMapping("/student/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/loginStudent";
	}
	
	// employee/student
	// 삭제 
	@GetMapping("/employee/student/deleteStudent")
	public String deleteStudent(@RequestParam("studentNo") int studentNo) {
		studentService.deleteStudent(studentNo);
		return "redirect:/employee/student/studentList";
	}
	
	// 학생추가
	@GetMapping("/employee/student/addStudent")
	public String addStudent() {
		return "employee/student/addStudent"; // forword
	}
	@PostMapping("/employee/student/addStudent")
	public String addStudent(Model model, Student student) {
		String idCheck = idService.getIdCheck(student.getStudentId());
		if(idCheck != null) {
			model.addAttribute("errorMsg", "중복된ID");
			return "employee/student/addStudent";
		}
		
		int row = studentService.addStudent(student);
		// row == 1이면 입력성공
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템에러로 등록실패");
			return "employee/student/addStudent";
		}
		return "redirect:/employee/student/studentList"; // sendRedirect , CM -> C
	}
	
	
	// studentList
	@GetMapping("/employee/student/studentList")
	public String student(Model model 
								, @RequestParam(value="currentPage", defaultValue = "1") int currentPage
								, @RequestParam(value="rowPerPage", defaultValue = "10") int rowPerPage 
								, @RequestParam(value="searcWord", defaultValue = "") String searchWord) { 

		log.debug(currentPage+" <-currentPage");
		log.debug(rowPerPage+" <-rowPerPage");
		log.debug(searchWord+" <-searchWord");		
	
		List<Student> list = studentService.getStudentList(currentPage, rowPerPage, searchWord);
		int lastPage = studentService.studentCount(searchWord, currentPage, rowPerPage);
		int startPage = 0;
		int endPage = 0;
	
		if(currentPage != 1) {
			startPage = currentPage+1;
		} else {
			startPage = 1;
		}
		
		if(currentPage == 1) {
			endPage = currentPage+9;
		} else {
			endPage = currentPage+10;
		}
		if(endPage > lastPage) {
			endPage = lastPage;
		}		
		// request.setAttribute("list", list);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("startPage", startPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("endPage", endPage);
		
		return "employee/student/studentList";	
	}	
	
}
