/**
 * 
 */
package org.abhyan.tradecraft.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.abhyan.tradecraft.constants.ConstParameters;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author nvarapar
 *
 */
@Embeddable
public class HistoricalDataPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = ConstParameters.COLUMN_TICKER)
	private String ticker;
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern= ConstParameters.DATE_FORMAT)
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConstParameters.DATE_FORMAT, timezone = "PST")
	@JsonSerialize(using = CustomDateSerializer.class)
	@Column(name = ConstParameters.COLUMN_TRADE_DATE)
	private Date tradeDate;

	/**
	 * 
	 */
	public HistoricalDataPK() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricalDataPK other = (HistoricalDataPK) obj;

		if (ticker == null) {
			if (other.ticker != null) {
				return false;
			}
		} else if (!ticker.equals(other.getTicker())) {
			return false;
		}

		if (tradeDate == null) {
			if (other.tradeDate != null) {
				return false;
			}
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(ConstParameters.DATE_FORMAT);
			String dateStr1 = sdf.format(tradeDate);
			String dateStr2 = sdf.format(other.tradeDate);
			if (!dateStr1.equals(dateStr2)) {
				return false;
			}
		}
		return true;

	}

	 @Override
	    public int hashCode() {
	        return Objects.hash(getTicker(), getTradeDate());
	    }
	 
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	/**
	 * @param ticker
	 * @param tradeDate
	 */
	public HistoricalDataPK(String ticker, Date tradeDate) {
		this.ticker = ticker;
		this.tradeDate = tradeDate;
	}

	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return ticker;
	}

	/**
	 * @param ticker
	 *            the ticker to set
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	/**
	 * @return the tradeDate
	 */
	
	public Date getTradeDate() {
		return tradeDate;
	}

	/**
	 * @param tradeDate
	 *            the tradeDate to set
	 */
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

}
