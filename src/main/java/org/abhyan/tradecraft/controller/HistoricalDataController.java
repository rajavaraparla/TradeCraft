package org.abhyan.tradecraft.controller;

import java.util.Map;

import org.abhyan.tradecraft.model.HistoricalData;
//import org.abhyan.tradecraft.model.IEOD_5Min;
import org.abhyan.tradecraft.service.HistoricalDataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
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

	
	@RequestMapping(value="/histdata",method=RequestMethod.GET)
	public ResponseEntity<HistoricalData> getHistDataForTickerAndDate() {
		logger.info("--Entered Into getHistData");
		
		HistoricalData histData = historicalDataService.getHistoricalDataForTickerAndDate("SUNPHARMA","2018-06-20");
		return new ResponseEntity<HistoricalData>(histData, HttpStatus.OK);
		//return histData;
		
	}

		


}
