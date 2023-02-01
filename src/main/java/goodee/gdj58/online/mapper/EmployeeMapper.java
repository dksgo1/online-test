package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Employee;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Teacher;

@Mapper
public interface EmployeeMapper {
	// student
	int deleteStudent(int studentNo);
	int insertStudent(Student student);
	List<Student> selectStudentList(Map<String, Object> paramMap);
	// teacher
	int deleteTeacher(int teacherNo);
	int insertTeacher(Teacher teacher);
	List<Teacher> selectTeacherList(Map<String, Object> paramMap);
	// emp
	int updateEmployeePw(Map<String, Object> paramMap);
	Employee login(Employee employee);
	int deleteEmployee(int empNo);
	int insertEmployee(Employee employee);
	List<Employee> selectEmployeeList(Map<String, Object> paramMap);
}

