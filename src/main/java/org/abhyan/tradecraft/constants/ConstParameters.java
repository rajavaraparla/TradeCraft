package org.abhyan.tradecraft.constants;


public final class ConstParameters {
	
	// Connection Parameters
	public static final String DB_NAME="dbname";
	public static final String DB_HOST="dbhost";
	public static final String DB_PORT="dbport";
	public static final String DB_USER="dbuser";
	public static final String DB_PASSWORD="dbpassword";
	
	// Column Names
	public static final String COLUMN_TICKER="ticker";
	public static final String COLUMN_TRADE_DATE="TradeDate";
	public static final String COLUMN_OPEN="Open";
	public static final String COLUMN_HIGH="High";
	public static final String COLUMN_LOW="Low";
	public static final String COLUMN_CLOSE="Close";
	public static final String COLUMN_VOLUME="Volume";
	public static final String COLUMN_VWAP="VWAP";
	public static final String COLUMN_DELIVERY_VOLUME="Deliverable_Volume";
	public static final String COLUMN_PERENTAGE_DELIVERABLE="Percentage_Deliverables";
	
	// Intra Column Names
	public static final String COLUMN_TRADE_TIME="TradeTime";
	
	// Table Names
	
	public static final String TABLE_HISTDATA = "hist_data";
	public static final String TABLE_IEOD_5MIN = "intra_data_5min";
	public static final String TABLE_IEOD_15MIN = "intra_data_15min";
	public static final String TABLE_IEOD_30MIN = "intra_data_30min";
	public static final String TABLE_IEOD_HOUR = "intra_data_hour";
	
	// THESE NEEDS TO BE CHANGED IF ANY OF THE CLASS NAMES UNDER mydreamproject.model is changed
	public static final String MODEL_HISTDATA = "HistoricalData";
	public static final String MODEL_IEOD_5MIN = "IEOD_5Min";
	public static final String MODEL_IEOD_15MIN = "IEOD_15Min";
	public static final String MODEL_IEOD_30MIN = "IEOD_30Min";
	public static final String MODEL_IEOD_HOUR = "IEOD_hour";
	
	public static final String MODEL_COLUMN_TRADEDATE = "tradeDate";
	public static final String MODEL_COLUMN_TICKER = "ticker";

	
	
	// Other Constants
	public static final String DATE_FORMAT="yyyy-MM-dd";
	public static final String DATETIME_FORMAT="yyyy-MM-dd hh:mm:ss";
	
	
	
	
}
