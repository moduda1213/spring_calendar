package kr.co.gdu.cash.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.gdu.cash.service.NoticeService;
import kr.co.gdu.cash.vo.Notice;

@Controller
public class NoticeController {
	@Autowired NoticeService noticeService;
	
	//공지 사항 더 보기
	@GetMapping("/admin/noticeList")
	public String noticeList(Model model,
					@RequestParam(value ="currentPage" ,defaultValue = "1") int currentPage) {
		int rowPerPage = 5;
		//total lastPage = (total / rowPerPage)+1
		int total = noticeService.totalList();
		System.out.println(total+"<-total");
		int lastPage = (total/rowPerPage);
		System.out.println(lastPage+"<-lastPage");
		
		if(total%rowPerPage != 0) {
			lastPage += 1;
		}
		//noticeService 호출
		List<Notice> noticeListByPage = noticeService.getNoticeListByPage(currentPage, rowPerPage);
		model.addAttribute("noticeListByPage",noticeListByPage);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("lastPage",lastPage);
		return "noticeList";
	}
	
	//공지 상세보기
	@GetMapping("/admin/noticeOne")
	public String noticeOne(Model model,
						@RequestParam(value="noticeId") int noticeId) {
		//noticeService 호출
		Notice noticeOne = noticeService.getNoticeOne(noticeId);
		model.addAttribute("noticeOne",noticeOne);
		return "noticeOne";
	}
	
	//공지 입력 폼
	@GetMapping("/admin/addNotice")
	public String addNotice() {
		return "addNotice";
	}
	
	//공지 입력 액션
	@PostMapping("/admin/addNotice")
	public String addNotice(Notice notice) {
		noticeService.addNotice(notice);
		
		return "redirect:/admin/noticeList";
	}
	
	//공지 삭제
	@GetMapping("/admin/removeNotice")
	public String removeNotice(@RequestParam(value="noticeId") int noticeId) {
		noticeService.deleteNotice(noticeId);
		return "redirect:/admin/noticeList";
	}
	//공지 수정 폼
	@GetMapping("/admin/updateNotice")
	public String updateNotice(Model model, @RequestParam(value="noticeId") int noticeId) {
		Notice updateNoticeForm = noticeService.getNoticeOne(noticeId);
		model.addAttribute("updateNoticeForm",updateNoticeForm);
		return "updateNotice";
	}
	//공지 수정
	@PostMapping("/admin/updateNotice")
	public String updateNotice(Notice notice) {
		noticeService.updateNotice(notice);
		
		return "redirect:/admin/noticeOne?noticeId="+notice.getNoticeId();
	}
}
