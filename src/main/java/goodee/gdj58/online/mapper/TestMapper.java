package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Test;

@Mapper
public interface TestMapper {
	// student/test
	List<Test> selectStudentTestList(Map<String, Object> paramMap);
	// teacher/test
	int updateTest(Test test);
	int insertTest(Test Test);
	List<Test> selectTestList(Map<String, Object> paramMap);	
}
