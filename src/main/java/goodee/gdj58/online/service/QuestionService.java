package goodee.gdj58.online.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.QuestionMapper;
import goodee.gdj58.online.vo.Question;

@Service
@Transactional
public class QuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	
	// studentQuestion
	public List<Map<String, Object>> getStudentExampleList(int testNo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("testNo", testNo);

		return questionMapper.selectStudentExampleList(paramMap);
	}

	public List<Question> getStudentQuestionList(int testNo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("testNo", testNo);
		
		return questionMapper.selectStudentQuestionList(paramMap);
	}
	// teacherQuestion
	public int deleteQuestion(int questionNo) {
		return questionMapper.deleteQuestion(questionNo);
	}
	
	public int modifyQuestion(Question question) {
		return questionMapper.updateQuestion(question);
	}
	
	public int addQuestion(Question question) {
		return questionMapper.insertQuestion(question);
	}
	
	public List<Question> getTeacherQuestionList(int testNo, int currentPage, int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("testNo", testNo);
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		return questionMapper.selectTeacherQuestionList(paramMap);
	}
}
