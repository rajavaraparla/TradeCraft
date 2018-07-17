package org.abhyan.tradecraft.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.abhyan.tradecraft.constants.ConstParameters;
import org.abhyan.tradecraft.model.HistoricalData;
import org.abhyan.tradecraft.model.HistoricalDataPK;
//import org.abhyan.tradecraft.model.IEOD_5Min;
import org.abhyan.tradecraft.service.HistoricalDataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/histdata")
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

	
	@RequestMapping(value="/getohlcfortickeranddate",method=RequestMethod.POST)
	public ResponseEntity<HistoricalData> getHistDataForTickerAndDate(@RequestBody HistoricalDataPK histdataPK) {
		logger.info("--Entered Into getHistDataForTickerAndDate");
		
		String ticker = histdataPK.getTicker();
		Date date = histdataPK.getTradeDate();
		System.out.println("TRADE DATE : -"+date);
		HistoricalData histData = historicalDataService.getHistoricalDataForTickerAndDate(ticker,date);
		return new ResponseEntity<HistoricalData>(histData, HttpStatus.OK);
		//return histData;
		
	}

	@RequestMapping(value="/getohlcfromtickeranddate",method=RequestMethod.POST)
	public ResponseEntity<List<HistoricalData>> getHistDataFromTickerAndDate(@RequestBody HistoricalDataPK histdataPK) {
		logger.info("--Entered Into getHistDataFromTickerAndDate");
		
		String ticker = histdataPK.getTicker();
		Date date = histdataPK.getTradeDate();
		System.out.println("TRADE DATE : -"+date);
		
		List<HistoricalData> histData = historicalDataService.getHistoricalDataForTickerFromDate(ticker,date);
//		for (HistoricalData historicalData : histData) {
//			System.out.println(historicalData.getHistPK().getTradeDate());
//			DateFormat dateFormat = new SimpleDateFormat(ConstParameters.DATE_FORMAT);
//			System.out.println(dateFormat.format(historicalData.getHistPK().getTradeDate()));
//			System.out.println(historicalData.getOpen());
//		}

		return new ResponseEntity<List<HistoricalData>>(histData, HttpStatus.OK);
		//return histData;
		
	}

	@RequestMapping(value="/{ticker}",method=RequestMethod.GET)
	public ResponseEntity<List<HistoricalData>> getHistDataForTicker(@PathVariable("ticker") String ticker) {
		logger.info("--Entered Into getHistData");
		
		List<HistoricalData> histData = historicalDataService.getAllHistoricalDataForTicker(ticker);
		return new ResponseEntity<List<HistoricalData>>(histData, HttpStatus.OK);
		//return histData;
		
	}
		


}
