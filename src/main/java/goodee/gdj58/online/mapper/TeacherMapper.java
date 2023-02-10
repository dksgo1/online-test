package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Teacher;

@Mapper
public interface TeacherMapper {
	// teacher
	int updateTeacherPw(Map<String, Object> paramMap);
	Teacher login(Teacher teacher);
	// employee/teacher
	int teacherCount(String searchWord);
	int deleteTeacher(int teacherNo);
	int insertTeacher(Teacher teacher);
	List<Teacher> selectTeacherList(Map<String, Object> paramMap);
}
