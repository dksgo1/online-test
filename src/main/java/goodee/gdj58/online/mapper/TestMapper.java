package goodee.gdj58.online.mapper;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Test;

@Mapper
public interface TestMapper {
	
	// testPaper
	// 내가 선택한 답 출력
	List<Map<String, Object>> selectAnswerList(Map<String, Object> paramMap);
	List<Question> selectQuestionList(Map<String, Object> paramMap);
	List<Map<String, Object>> selectTestPaperList(Map<String, Object> paramMap);
	
	// student/test
	List<Test> selectStudentTestList(Map<String, Object> paramMap);
	// teacher/test
	int deleteTest(int testNo);
	int updateTest(Test test);
	int insertTest(Test Test);
	List<Test> selectTestList(Map<String, Object> paramMap);	
}
