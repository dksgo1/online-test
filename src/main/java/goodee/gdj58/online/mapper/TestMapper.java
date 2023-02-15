package goodee.gdj58.online.mapper;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Test;

@Mapper
public interface TestMapper {
	
	// testPaper
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
