
package org.abhyan.tradecraft.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import org.abhyan.tradecraft.constants.ConstParameters;
import org.abhyan.tradecraft.model.HistoricalData;
import org.abhyan.tradecraft.dao.HistoricalDataDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HistoricalDataDAOImpl implements HistoricalDataDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<HistoricalData> getAllHistoricalData() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		//String fromTable = String.format("from %s", ConstParameters.TABLE_HISTDATA);
		String fromTable = String.format("from %s", "HistoricalData");
		
		Query<HistoricalData> theQuery = currentSession.createQuery(fromTable, HistoricalData.class);
		List <HistoricalData> allHistData = theQuery.getResultList();
		
		return allHistData;
	}
	
	@Override
	public List<HistoricalData> getAllHistoricalDataForTicker(String ticker) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		//String fromTable = String.format("from %s where %s=:ticker", "HistoricalData",ConstParameters.COLUMN_TICKER);
		String fromTable = String.format("from %s where %s=:ticker", ConstParameters.MODEL_HISTDATA,ConstParameters.COLUMN_TICKER);
		Query<HistoricalData> theQuery = currentSession.createQuery(fromTable, HistoricalData.class);
		theQuery.setParameter(ConstParameters.COLUMN_TICKER, ticker);
		List <HistoricalData> allHistData = theQuery.getResultList();
		return allHistData;
	}

	@Override
	public HistoricalData getHistoricalDataForTickerAndDate(String ticker, String tradeDate) {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		//String fromTable = String.format("from %s", ConstParameters.TABLE_IEOD_5MIN);
		//System.out.println("tardeDate :"+tradeDate);
		String fromTable = String.format("from %s where %s=:ticker and %s=:tradedate", ConstParameters.MODEL_HISTDATA,ConstParameters.MODEL_COLUMN_TICKER,ConstParameters.MODEL_COLUMN_TRADEDATE);
		Query<HistoricalData> theQuery = currentSession.createQuery(fromTable,HistoricalData.class);
		theQuery.setParameter(ConstParameters.COLUMN_TICKER, ticker);
		//String tradeDateStr = tradeDate.toString();
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		//String strDate = dateFormat.format(tradeDate); 
		//System.out.println("Date String "+ strDate);

		theQuery.setParameter("tradedate", tradeDate);
		HistoricalData histData = theQuery.getSingleResult();
		System.out.println(histData);
		// TODO Auto-generated method stub
		return histData;

	}
	
	

}
