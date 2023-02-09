package goodee.gdj58.online.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.PaperMapper;
import goodee.gdj58.online.vo.Paper;

@Service
@Transactional
public class PaperService {
	@Autowired
	private PaperMapper paperMapper;
	
	public List<Paper>addPaper(int studentNo, int questionNo, String answer) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("studentNo", studentNo);
		paramMap.put("questionNo", questionNo);
		paramMap.put("answer", answer);
		
		return paperMapper.insertPaper(paramMap);
	}
}
