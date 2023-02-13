package goodee.gdj58.online.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.TeacherMapper;
import goodee.gdj58.online.vo.Teacher;

@Service
@Transactional
public class TeacherService {
	@Autowired
	private TeacherMapper teacherMapper;

	// teacher
	public int updateTeacherPw(int teacherNo, String oldPw, String newPw) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("teacherNo", teacherNo);
		paramMap.put("oldPw", oldPw);
		paramMap.put("newPw", newPw);
		return teacherMapper.updateTeacherPw(paramMap);
	}	
	
	public Teacher login(Teacher teacher) {
		return teacherMapper.login(teacher);
	}
		
	// employee/teacher
	public String getTeacherId(String teacherId) {
		// 사용가능한 ID면 "YES" 아니면 "NO"반환
		String resultStr = "NO";
		if(teacherMapper.selectTeacherId(teacherId) == null) {
			resultStr = "YES";
		}
		return resultStr;
	}
	
	
	public int teacherCount(String searchWord, int currentPage, int rowPerPage) {
		int count = teacherMapper.teacherCount(searchWord);
		int lastPage = (int)Math.ceil((double)count / (double)rowPerPage);
		
		return lastPage;
	}
	
	public int deleteTeacher(int teacherNo) {
		return teacherMapper.deleteTeacher(teacherNo);
	}
	
	
	public int addTeacher(Teacher teacher) {
		return teacherMapper.insertTeacher(teacher);
	}
	
	public List<Teacher> getTeacherList(int currentPage, int rowPerPage, String searchWord) {
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("searchWord", searchWord);
		
		return teacherMapper.selectTeacherList(paramMap);
	}
}
