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

	public List<Map<String, Object>> getStudentQuestionList(int testNo, int currentPage, int rowPerPage){
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("questionNo", testNo);
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		
		return questionMapper.selectStudentQuestionList(paramMap);
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
