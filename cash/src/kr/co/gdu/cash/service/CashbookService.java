package kr.co.gdu.cash.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.gdu.cash.mapper.CashbookMapper;

@Service
@Transactional
public class CashbookService {
	@Autowired private CashbookMapper cashbookMapper;
	
	public int getSumCashBookPriceByInOut(String cashbookKind, int currentYear, int currentMonth) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("cashbookKind", cashbookKind);
		map.put("currentYear", currentYear);
		map.put("currentMonth", currentMonth);
		int sum = cashbookMapper.sumCashBookPriceByInOut(map);
		return sum;
	}
}