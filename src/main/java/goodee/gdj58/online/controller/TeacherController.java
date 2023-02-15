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
import goodee.gdj58.online.service.TeacherService;
import goodee.gdj58.online.vo.Teacher;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TeacherController {
	@Autowired TeacherService teacherService;
	@Autowired IdService idService; 
	// teacher
	// pw 수정폼
	@GetMapping("/teacher/modifyTeacherPw")
	public String modifyTeacherPw() {
		return "teacher/modifyTeacherPw";
	}
	
	// pw 수정액션
	@PostMapping("/teacher/modifyTeacherPw")
	public String modifyTeacherPw(HttpSession session
							, @RequestParam(value="oldPw") String oldPw
							, @RequestParam(value="newPw") String newPw) {
		// 로그인 후 호출 가능
		Teacher loginTeacher = (Teacher)session.getAttribute("loginTeacher");
		teacherService.updateTeacherPw(loginTeacher.getTeacherNo(), oldPw, newPw);
		
		return "redirect:/teacher/test/teacherTestList";
	}	
	// 로그아웃
	@GetMapping("/teacher/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login.jsp";
	}
	
	// 로그인
	@GetMapping("/loginTeacher")
	public String loginEmp() {
		return "teacher/loginTeacher";
	}
	// 로그인 액션
	@PostMapping("/loginTeacher")
	public String loginTeacher(HttpSession session, Teacher teacher) {
		Teacher resultTeacher = teacherService.login(teacher);
		session.setAttribute("loginTeacher", resultTeacher);
		return "redirect:/teacher/test/teacherTestList";
	}	
	
	// employee/teacher
	// 삭제 
	@GetMapping("/employee/teacher/deleteTeacher")
	public String deleteTeacher(@RequestParam("teacherNo") int teacherNo) {
		teacherService.deleteTeacher(teacherNo);
		return "redirect:/employee/teacher/teacherList";
	}
	
	// 강사추가
	@GetMapping("/employee/teacher/addTeacher")
	public String addTeacher() {
		return "employee/teacher/addTeacher"; // forword
	}
	@PostMapping("/employee/teacher/addTeacher")
	public String addTeacher(Model model, Teacher teacher) {	
		String idCheck = idService.getIdCheck(teacher.getTeacherId());
		if(idCheck != null) {
			model.addAttribute("errorMsg", "중복된ID");
			return "employee/teacher/addTeacher";
		}
		
		int row = teacherService.addTeacher(teacher);
		// row == 1이면 입력성공
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템에러로 등록실패");
			return "/employee/teacher/addTeacher";
		}
		return "redirect:/employee/teacher/teacherList"; // sendRedirect , CM -> C
	}
	
	// teacherList
	@GetMapping("/employee/teacher/teacherList")
	public String teacher(Model model 
								, @RequestParam(value="currentPage", defaultValue = "1") int currentPage
								, @RequestParam(value="rowPerPage", defaultValue = "10") int rowPerPage 
								, @RequestParam(value="searcWord", defaultValue = "") String searchWord) { 
								// int currentPage = request.getParameter("currentPage");
		log.debug(currentPage+" <-currentPage");
		log.debug(rowPerPage+" <-rowPerPage");
		log.debug(searchWord+" <-searchWord");
	
		List<Teacher> list = teacherService.getTeacherList(currentPage, rowPerPage, searchWord);
		int lastPage = teacherService.teacherCount(searchWord, currentPage, rowPerPage);
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
		return "employee/teacher/teacherList";	
	}	
}
