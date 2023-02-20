package goodee.gdj58.online.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.TestMapper;
import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Test;

@Service
@Transactional
public class TestService {
	@Autowired
	private TestMapper testMapper;

	// 학생이 선택한 답만 출력
	public List<Map<String, Object>> getSelectAnswerList(int testNo, int studentNo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("testNo", testNo);
		paramMap.put("studentNo", studentNo);
		
		return testMapper.selectAnswerList(paramMap);
	}	
	
	// 학생 점수 구하기
	public int totalScore(List<Map<String, Object>> resultList) {
	    int score = 0;
	    for (Map<String, Object> result : resultList) {
	        // exampleOx 값이 "정답"이고, exampleIdx 값과 answer 값이 같으면 20점 추가
	        if (result.get("exampleOx").equals("정답") && result.get("exampleIdx").equals(result.get("answer"))) {
	            score += 20;
	        }
	    }
	    return score;
	}
	
	public List<Question> getQuestionList(int testNo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("testNo", testNo);
		
		return testMapper.selectQuestionList(paramMap);
	}
	
	public List<Map<String, Object>> getSelectTestPaperListList(int studentNo, int testNo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("studentNo", studentNo);
		paramMap.put("testNo", testNo);
		
		return testMapper.selectTestPaperList(paramMap);
	}	

	
	// student/test
	public List<Test> getStudentTestList(int currentPage, int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		return testMapper.selectStudentTestList(paramMap);
	}
	
	// teacher/test
	public int deleteTest(int testNo) {
		return testMapper.deleteTest(testNo);
	}
	
	public int modifyTest(Test test) {
		return testMapper.updateTest(test);
	}

	public int addTest(Test test) {
		return testMapper.insertTest(test);
	}	

	public List<Test> getTestList(int currentPage, int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		return testMapper.selectTestList(paramMap);
	}

}
