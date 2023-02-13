package goodee.gdj58.online.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Paper;

@Mapper
public interface PaperMapper {
	int insertPaper(Map<String,Object> paramMap);
}
