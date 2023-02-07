package goodee.gdj58.online.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.ExampleMapper;
import goodee.gdj58.online.vo.Example;

@Service
@Transactional
public class ExampleService {
	@Autowired
	private ExampleMapper exampleMapper;

	public int modifyExample(Example example) {
		return exampleMapper.updateExample(example);
	}
	
	public int addExample(Example example) {
		return exampleMapper.insertExample(example);
	}
	
	public List<Example> getTeacherExampleList(int questionNo, int currentPage, int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("questionNo", questionNo);
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		return exampleMapper.selectTeacherExampleList(paramMap);
	}

}
