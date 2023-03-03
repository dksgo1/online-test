package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaperMapper {
	List<Map<String, Object>> selectPaperList(Map<String, Object> paramMap);
	int insertPaper(Map<String,Object> paramMap);
}	
