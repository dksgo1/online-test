package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Question;

@Mapper
public interface QuestionMapper {
	// teacherQuestion
	int updateQuestion(Question question);
	int insertQuestion(Question question);
	List<Question> selectTeacherQuestionList(Map<String, Object> paramMap);
}
