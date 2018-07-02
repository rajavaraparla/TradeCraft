/**
 * 
 */
package org.abhyan.tradecraft.dao;

import java.util.List;

import org.abhyan.tradecraft.model.HistoricalData;

/**
 * @author nvarapar
 *
 */
public interface HistoricalDataDAO {
	
	public List<HistoricalData> getAllHistoricalData();
	public List<HistoricalData> getAllHistoricalDataForTicker(String ticker);
	public HistoricalData getHistoricalDataForTickerAndDate(String ticker,String tradeDate);

}
