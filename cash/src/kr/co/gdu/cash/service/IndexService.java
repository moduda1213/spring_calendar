package kr.co.gdu.cash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.co.gdu.cash.vo.Notice;
import java.util.List;
import kr.co.gdu.cash.mapper.NoticeMapper;
@Service
@Transactional
public class IndexService {
	@Autowired
	private NoticeMapper noticeMapper;
	public List<Notice> getLatestNoticeList(){
		return noticeMapper.selectLatestNoticeList();
	}
}
