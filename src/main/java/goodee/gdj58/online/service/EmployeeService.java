package goodee.gdj58.online.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.EmployeeMapper;
import goodee.gdj58.online.vo.Employee;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Teacher;

@Service
@Transactional
public class EmployeeService {
	// DI new EmployeeMapper()
	@Autowired
	private EmployeeMapper employeeMapper;

	// student
	public int deleteStudent(int studentNo) {
		return employeeMapper.deleteStudent(studentNo);
	}
	
	public int addStudent(Student student) {
		return employeeMapper.insertStudent(student);
	}
	
	public List<Student> getStudentList(int currentPage, int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		return employeeMapper.selectStudentList(paramMap);
	}	
	
	// teacher
	public int deleteTeacher(int teacherNo) {
		return employeeMapper.deleteTeacher(teacherNo);
	}
	
	
	public int addTeacher(Teacher teacher) {
		return employeeMapper.insertTeacher(teacher);
	}
	
	public List<Teacher> getTeacherList(int currentPage, int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		return employeeMapper.selectTeacherList(paramMap);
	}
	
	
	// emp
	public int updateEmployeePw(int empNo, String oldPw, String newPw) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("empNo", empNo);
		paramMap.put("oldPw", oldPw);
		paramMap.put("newPw", newPw);
		return employeeMapper.updateEmployeePw(paramMap);
	}
	
	public Employee login(Employee emp) {
		return employeeMapper.login(emp);
	}
	
	public int deleteEmployee(int empNo) {
		return employeeMapper.deleteEmployee(empNo);
	}
	
	public int addEmployee(Employee employee) {
		return employeeMapper.insertEmployee(employee);
	}
	
	public List<Employee> getEmployeeList(int currentPage, int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		return employeeMapper.selectEmployeeList(paramMap);
	}
}
