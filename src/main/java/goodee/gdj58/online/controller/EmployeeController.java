package goodee.gdj58.online.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.EmployeeService;
import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.vo.Employee;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Teacher;

@Controller
public class EmployeeController {
	@Autowired EmployeeService employeeService;
	@Autowired IdService idService; 
	
	//student
	// 삭제 
	@GetMapping("/student/deleteStudent")
	public String deleteStudent(@RequestParam("studentNo") int studentNo, HttpSession session) {
		// 로그인 X라면 "redirect:/employee/loginEmp";
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) {
			return "redirect:/employee/loginEmp";
		}
		employeeService.deleteStudent(studentNo);
		return "redirect:/student/studentList";
	}
	
	// 학생추가
	@GetMapping("/student/addStudent")
	public String addStudent(HttpSession session) {
		// 로그인 X라면 "redirect:/employee/loginEmp";
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) {
			return "redirect:/employee/loginEmp";
		}
		return "student/addStudent"; // forword
	}
	@PostMapping("/student/addStudent")
	public String addStudent(HttpSession session, Model model, Student student) {
		// 로그인 X라면 "redirect:/employee/loginEmp";
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) {
			return "redirect:/employee/loginEmp";
		}
		
		String idCheck = idService.getIdCheck(student.getStudentId());
		if(idCheck != null) {
			model.addAttribute("errorMsg", "중복된ID");
			return "student/addStudent";
		}
		
		int row = employeeService.addStudent(student);
		// row == 1이면 입력성공
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템에러로 등록실패");
			return "/student/addStudent";
		}
		return "redirect:/student/studentList"; // sendRedirect , CM -> C
	}
	
	
	// studentList
	@GetMapping("/student/studentList")
	public String student(Model model 
								, @RequestParam(value="currentPage", defaultValue = "1") int currentPage
								, @RequestParam(value="rowPerPage", defaultValue = "10") int rowPerPage 
								, HttpSession session) { 
		
								// int currentPage = request.getParameter("currentPage");
		// 로그인 후 호출 가능
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { // 로그인 실패
			return "redirect:/employee/loginEmp";
		}
		List<Student> list = employeeService.getStudentList(currentPage, rowPerPage);
		// request.setAttribute("list", list);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		return "student/studentList";	
	}	
	// teacher
	// 삭제 
	@GetMapping("/teacher/deleteTeacher")
	public String deleteTeacher(@RequestParam("teacherNo") int teacherNo, HttpSession session) {
		// 로그인 X라면 "redirect:/employee/loginEmp";
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) {
			return "redirect:/employee/loginEmp";
		}
		employeeService.deleteTeacher(teacherNo);
		return "redirect:/teacher/teacherList";
	}
	
	// 강사추가
	@GetMapping("/teacher/addTeacher")
	public String addTeacher(HttpSession session) {
		// 로그인 X라면 "redirect:/employee/loginEmp";
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) {
			return "redirect:/employee/loginEmp";
		}
		return "teacher/addTeacher"; // forword
	}
	@PostMapping("/teacher/addTeacher")
	public String addTeacher(HttpSession session, Model model, Teacher teacher) {
		// 로그인 X라면 "redirect:/employee/loginEmp";
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) {
			return "redirect:/employee/loginEmp";
		}
		
		String idCheck = idService.getIdCheck(teacher.getTeacherId());
		if(idCheck != null) {
			model.addAttribute("errorMsg", "중복된ID");
			return "teacher/addTeacher";
		}
		
		int row = employeeService.addTeacher(teacher);
		// row == 1이면 입력성공
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템에러로 등록실패");
			return "/teacher/addTeacher";
		}
		return "redirect:/teacher/teacherList"; // sendRedirect , CM -> C
	}
	
	// teacherList
	@GetMapping("/teacher/teacherList")
	public String teacher(Model model 
								, @RequestParam(value="currentPage", defaultValue = "1") int currentPage
								, @RequestParam(value="rowPerPage", defaultValue = "10") int rowPerPage 
								, HttpSession session) { 
		
								// int currentPage = request.getParameter("currentPage");
		// 로그인 후 호출 가능
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { // 로그인 실패
			return "redirect:/employee/loginEmp";
		}
		List<Teacher> list = employeeService.getTeacherList(currentPage, rowPerPage);
		// request.setAttribute("list", list);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		return "teacher/teacherList";	
	}
	
	// emp
	// pw 수정폼
	@GetMapping("/employee/modifyEmpPw")
	public String modifyEmpPw(HttpSession session) {
		// 로그인 후 호출 가능
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { // 로그인 실패
			return "redirect:/employee/loginEmp";
		}
		return "employee/modifyEmpPw";
	}
	
	// pw 수정액션
	@PostMapping("/employee/modifyEmpPw")
	public String modifyEmpPw(HttpSession session
							, @RequestParam(value="oldPw") String oldPw
							, @RequestParam(value="newPw") String newPw) {
		// 로그인 후 호출 가능
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { // 로그인 실패
			return "redirect:/employee/loginEmp";
		}
	
		employeeService.updateEmployeePw(loginEmp.getEmpNo(), oldPw, newPw);
		
		return "redirect:/employee/empList";
	}
	
	
	// 로그인
	@GetMapping("/employee/loginEmp")
	public String loginEmp(HttpSession session) {
		// 이미 로그인 상태면 "redirect:/employee/empList";
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp != null) {
			return "redirect:/employee/empList";
		}
		return "employee/loginEmp";
	}
	@PostMapping("/employee/loginEmp")
	public String loginEmp(HttpSession session, Employee emp) {
		Employee resultEmp = employeeService.login(emp);
		if(resultEmp == null) { // 로그인 실패
			return "redirect:/employee/loginEmp";
		}
		session.setAttribute("loginEmp", resultEmp);
		return "redirect:/employee/empList";
	}
	
	@GetMapping("/employee/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/employee/loginEmp";
	}
	
	// 삭제 
	@GetMapping("/employee/deleteEmp")
	public String deleteEmp(@RequestParam("empNo") int empNo, HttpSession session) {
		// 이미 로그인 상태면 "redirect:/employee/empList";
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp != null) {
			return "redirect:/employee/empList";
		}
		employeeService.deleteEmployee(empNo);
		return "redirect:/employee/empList";
	}
	
	// 입력
	@GetMapping("/employee/addEmp")
	public String addEmp(HttpSession session) {
		// 로그인 안한 상태라면 "redirect:/employee/loginEmp";
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) {
			return "redirect:/employee/loginEmp";
		}
		return "employee/addEmp"; // forword
	}
	@PostMapping("/employee/addEmp")
	public String addEmp(HttpSession session, Model model, Employee employee) {
		// 로그인 안한 상태라면 "redirect:/employee/loginEmp";
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) {
			return "redirect:/employee/loginEmp";
		}
		
		String idCheck = idService.getIdCheck(employee.getEmpId());
		if(idCheck != null) {
			model.addAttribute("errorMsg", "중복된ID");
			return "employee/addEmp";
		}
		
		int row = employeeService.addEmployee(employee);
		// row == 1이면 입력성공
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템에러로 등록실패");
			return "employee/addEmp";
		}
		return "redirect:/employee/empList"; // sendRedirect , CM -> C
	}
	
	@GetMapping("/employee/empList")
	public String empList(Model model 
								, @RequestParam(value="currentPage", defaultValue = "1") int currentPage
								, @RequestParam(value="rowPerPage", defaultValue = "10") int rowPerPage 
								, HttpSession session) { 
		
								// int currentPage = request.getParameter("currentPage");
		// 로그인 후 호출 가능
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { // 로그인 실패
			return "redirect:/employee/loginEmp";
		}
		List<Employee> list = employeeService.getEmployeeList(currentPage, rowPerPage);
		// request.setAttribute("list", list);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		return "employee/empList";	
	}
}
