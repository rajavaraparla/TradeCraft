package org.abhyan.tradecraft.service.impl;

import java.util.List;

import org.abhyan.tradecraft.dao.HistoricalDataDAO;
import org.abhyan.tradecraft.model.HistoricalData;
import org.abhyan.tradecraft.service.HistoricalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import javax.transaction.Transactional;

@Service
public class HistoricalDataServiceImpl implements HistoricalDataService{

	@Autowired
	private HistoricalDataDAO historicalDataDAO;
	
	@Override
	@Transactional
	public List<HistoricalData> getAllHistoricalData() {
		return historicalDataDAO.getAllHistoricalData();
		
	}
	
	@Override
	@Transactional
	public List<HistoricalData> getAllHistoricalDataForTicker(String ticker) {
		return historicalDataDAO.getAllHistoricalDataForTicker(ticker);
	}

	@Override
	@Transactional
	public HistoricalData getHistoricalDataForTickerAndDate(String ticker, String tradeDate) {
		return historicalDataDAO.getHistoricalDataForTickerAndDate(ticker, tradeDate);
	}
	

}
