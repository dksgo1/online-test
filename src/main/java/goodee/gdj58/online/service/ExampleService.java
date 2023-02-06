package goodee.gdj58.online.service;

import java.util.List;

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
	
	public List<Example> getTeacherExampleList(int questionNo) {
		return exampleMapper.selectTeacherExampleList(questionNo);
	}
}
