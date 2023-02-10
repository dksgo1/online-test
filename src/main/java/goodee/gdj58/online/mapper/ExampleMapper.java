package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Example;

@Mapper
public interface ExampleMapper {
	// teacherExample
	int deleteExample(int exampleNo);
	int updateExample(Example example);
	int insertExample(Example example);
	List<Example> selectTeacherExampleList(Map<String, Object> paramMap);
}
