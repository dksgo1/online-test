package goodee.gdj58.online.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.PaperMapper;

@Service
@Transactional
public class PaperService {
	@Autowired
	private PaperMapper paperMapper;
	
	public void addPaper(int studentNo, int[] questionNo, int[] answer) {		
		for(int i=0; i<questionNo.length; i++) {
			Map<String,Object> paper = new HashMap<String,Object>();
			paper.put("studentNo", studentNo);
			paper.put("questionNo", questionNo[i]);
			paper.put("answer", answer[i]);
			
			paperMapper.insertPaper(paper);
		}
	}
}
