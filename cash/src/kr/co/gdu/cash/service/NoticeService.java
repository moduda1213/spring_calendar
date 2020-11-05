package kr.co.gdu.cash.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.gdu.cash.mapper.CashbookMapper;
import kr.co.gdu.cash.mapper.NoticeMapper;
import kr.co.gdu.cash.vo.Notice;

@Service 
@Transactional
public class NoticeService {
	@Autowired private NoticeMapper noticeMapper;
	@Autowired private CashbookMapper cashbookMapper;
	
	public int totalList() {
		return noticeMapper.totalList();
	}
	
	public int updateNotice(Notice notice) {
		return noticeMapper.updateNotice(notice);
	}
	
	public int deleteNotice(int noticeId) {
		return noticeMapper.deleteNotice(noticeId);
	}
	//notice 추가
	public int addNotice(Notice notice) {
		return noticeMapper.addNoticeList(notice);
	}
	
	//notice 상세보기
	public Notice getNoticeOne(int noticeId) {
		return noticeMapper.selectNoticeOne(noticeId);
	}
	
	//notice 더보기
	public List<Notice> getNoticeListByPage(int currentPage, int rowPerPage){
		// int currentPage, int rowPerPage -> beginRow
		// noticeMapper 호출
		int beginRow = (currentPage-1)*rowPerPage; // 시작 행
		//System.out.println(beginRow+"<- beginRow");
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("beginRow",beginRow);
		map.put("rowPerPage", rowPerPage);
		return noticeMapper.selectNoticeListByPage(map);
	}
	
	// issue : noticeList....중복
	public Map<String, Object> getNoticeAndInOutList() { 
		List<Notice> noticeList = noticeMapper.selectLatestNoiceList();
		List<Map<String, Object>> inOutList = cashbookMapper.selectCashInOutList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("noticeList", noticeList);
		map.put("inOutList", inOutList);
		return map;
	}
	
	public List<Notice> getNoticeList() {
		return noticeMapper.selectLatestNoiceList();
	}
}
