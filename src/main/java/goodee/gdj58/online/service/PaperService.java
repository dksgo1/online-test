package goodee.gdj58.online.service;

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
	
	public int addPaper(int studentNo, Paper paper) {
		return paperMapper.insertPaper(paper);
	}
}
