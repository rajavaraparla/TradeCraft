package org.abhyan.tradecraft.controller;

import java.util.Map;

import org.abhyan.tradecraft.model.HistoricalData;
//import org.abhyan.tradecraft.model.IEOD_5Min;
import org.abhyan.tradecraft.service.HistoricalDataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoricalDataController {
	@Autowired
	private HistoricalDataService historicalDataService;
	
	
	private Logger logger = Logger.getLogger(HistoricalDataController.class);
	//DOMConfigurator.configure("log4j.xml");
	
	
	
	@RequestMapping("/")
	public String setupForm(Map<String, Object> map) {
		logger.info("--Entered Into setupForm");
		HistoricalData histData = new HistoricalData();
		map.put("histdata", histData);
		// map.put("allhistdata", historicalDataService.getAllHistoricalData());
		map.put("allhistdata", historicalDataService.getAllHistoricalDataForTicker("SUNPHARMA"));
		// getAllHistoricalDataForTicker
		
		return "view-Historical";
	}

	
	@RequestMapping(value="/api/v1/histdata",method=RequestMethod.GET)
	public HistoricalData getHistDataForTickerAndDate() {
		logger.info("--Entered Into getHistData");
		return historicalDataService.getHistoricalDataForTickerAndDate("SUNPHARMA","2018-06-20");
		
	}

		


}
