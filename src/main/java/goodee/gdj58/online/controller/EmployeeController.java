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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EmployeeController {
	@Autowired EmployeeService employeeService;
	@Autowired IdService idService; 
	// emp
	// pw 수정폼
	@GetMapping("/employee/modifyEmpPw")
	public String modifyEmpPw() {
		return "employee/modifyEmpPw";
	}
	
	// pw 수정액션
	@PostMapping("/employee/modifyEmpPw")
	public String modifyEmpPw(HttpSession session
							, @RequestParam(value="oldPw") String oldPw
							, @RequestParam(value="newPw") String newPw) {
		// 로그인 후 호출 가능
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		employeeService.updateEmployeePw(loginEmp.getEmpNo(), oldPw, newPw);
		
		return "redirect:/employee/empList";
	}	
	
	// 로그인
	@GetMapping("/loginEmp")
	public String loginEmp() {
		return "employee/loginEmp";
	}
	// 로그인 액션
	@PostMapping("/loginEmp")
	public String loginEmp(HttpSession session, Employee emp) {
		Employee resultEmp = employeeService.login(emp);
		session.setAttribute("loginEmp", resultEmp);
		return "redirect:/employee/empList";
	}
	
	// logout
	@GetMapping("/employee/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login.jsp";
	}
	
	// 삭제 
	@GetMapping("/employee/deleteEmp")
	public String deleteEmp(@RequestParam("empNo") int empNo) {
		employeeService.deleteEmployee(empNo);
		return "redirect:/employee/empList";
	}
	
	// 입력
	@GetMapping("/employee/addEmp")
	public String addEmp() {
		return "employee/addEmp"; // forword
	}
	@PostMapping("/employee/addEmp")
	public String addEmp(Model model, Employee employee) {
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
							    , @RequestParam(value="searchWord", defaultValue = "") String searchWord) { 
								// int currentPage = request.getParameter("currentPage");
	
		log.debug(currentPage+" <-currentPage");
		log.debug(rowPerPage+" <-rowPerPage");
		log.debug(searchWord+" <-searchWord");
		List<Employee> list = employeeService.getEmployeeList(currentPage, rowPerPage, searchWord);
		int lastPage = employeeService.empCount(searchWord, currentPage, rowPerPage);
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
		return "employee/empList";	
	}
}
