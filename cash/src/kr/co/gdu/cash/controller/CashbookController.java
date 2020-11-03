package kr.co.gdu.cash.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import kr.co.gdu.cash.service.CashbookService;
import kr.co.gdu.cash.service.IndexService;
import kr.co.gdu.cash.vo.Notice;

@Controller
public class CashbookController {
	
	@Autowired private CashbookService cashbookService;
	
	@GetMapping(value="/cashbookByMonth")
	public String cashbookByMonth(Model model,
				@RequestParam(name = "currentYear", defaultValue = "-1") int currentYear,
				@RequestParam(name = "currentMonth", defaultValue = "-1") int currentMonth) { // == request.getParameter
		//1. 요청분석
		Calendar currentDay = Calendar.getInstance(); // 오늘 날짜 -> 20.11.02
		if(currentYear !=-1 && currentMonth != -1) {
			if(currentMonth == 0) {

				currentYear -=1;
				currentMonth = 12; 
			}
			if(currentMonth == 13) {
				currentYear +=1; 
				currentMonth = 1;
			}
			currentDay.set(Calendar.YEAR, currentYear);
			currentDay.set(Calendar.MONTH, currentMonth-1);
		}
		
		currentDay.set(Calendar.DATE, 1);// 매 월 1일
		
		currentYear = currentDay.get(Calendar.YEAR);
		currentMonth = currentDay.get(Calendar.MONTH)+1; // 월 => 11월 || 달을 구할 때 +1 을 해줘야 현재 달이 출력된다
		int lastDay = currentDay.getActualMaximum(Calendar.DATE); // 마지막 날짜
		int firstDay = currentDay.get(Calendar.DAY_OF_WEEK); //현재 달의 첫번째 요일 -> 1:일 , 2: 월 ...
		//int firstDayOfWeek = currentDay.getFirstDayOfWeek(); // getFirstDayOfWeek: 이번 달 첫번째 요일을 구하는 것이 아닌 각 나라마다 첫 요일은 다르기 때문에 
		//System.out.println(currentDay +"<-오늘날짜");
		//System.out.println(year +"<- 이번 년도");
		//System.out.println(month +"<- 이번 달");
		//System.out.println(lastDay + "<- 이번달의 마지막 날짜");
		//System.out.println(firstDay + "<- firstDayOfWeek");
		
		//------------------------------------------------------------
		int expense = cashbookService.getSumCashBookPriceByInOut("지출", currentYear, currentMonth);
		int income = cashbookService.getSumCashBookPriceByInOut("수입", currentYear, currentMonth);

		//------------------------------------------------------------

		//3. 뷰 모델 추가
		/*
		  1) 월 , 마지막 일(28,30,31일), 시작하는 달 1일의 요일
		 */
		model.addAttribute("currentYear",currentYear);
		model.addAttribute("currentMonth",currentMonth);
		model.addAttribute("lastDay",lastDay);
		model.addAttribute("firstDay",firstDay);
		model.addAttribute("expense",expense);
		model.addAttribute("income",income);
		
		return "cashbookByMonth";
	}
}
