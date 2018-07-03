package org.abhyan.tradecraft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.abhyan.tradecraft.constants.ConstParameters;
@Entity
@Table(name=ConstParameters.TABLE_HISTDATA)
public class HistoricalData {

	@EmbeddedId
	private HistoricalDataPK histPK;
	
	@Column(name=ConstParameters.COLUMN_OPEN)
	private Float open;
	
	@Column(name=ConstParameters.COLUMN_HIGH)
	private Float high;
	
	@Column(name=ConstParameters.COLUMN_LOW)
	private Float low;
	
	@Column(name=ConstParameters.COLUMN_CLOSE)
	private Float close;
	
	@Column(name=ConstParameters.COLUMN_VWAP)
	private Float vwap;
	
	@Column(name=ConstParameters.COLUMN_VOLUME)
	private Long volume;
	
	@Column(name=ConstParameters.COLUMN_DELIVERY_VOLUME)
	private Long deliveryVolume;
	
	@Column(name=ConstParameters.COLUMN_PERENTAGE_DELIVERABLE)
	private Float percentageDelivery;
	
	public HistoricalData()
	{
		
	}
	
	/**
	 * @param ticker
	 * @param tradeDate
	 * @param open
	 * @param high
	 * @param low
	 * @param close
	 * @param vwap
	 * @param volume
	 * @param deliveryVolume
	 * @param percentageDelivery
	 */
	public HistoricalData(String ticker, Date tradeDate, Float open, Float high, Float low, Float close, Float vwap,
			Long volume, Long deliveryVolume, Float percentageDelivery) {
		super();
		this.histPK=new HistoricalDataPK(ticker, tradeDate);
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.vwap = vwap;
		this.volume = volume;
		this.deliveryVolume = deliveryVolume;
		this.percentageDelivery = percentageDelivery;
	}

	/**
	 * @return the histPK
	 */
	public HistoricalDataPK getHistPK() {
		return histPK;
	}

	/**
	 * @param histPK the histPK to set
	 */
	public void setHistPK(HistoricalDataPK histPK) {
		this.histPK = histPK;
	}

	/**
	 * @return the open
	 */
	public Float getOpen() {
		return open;
	}
	/**
	 * @param open the open to set
	 */
	public void setOpen(Float open) {
		this.open = open;
	}
	/**
	 * @return the high
	 */
	public Float getHigh() {
		return high;
	}
	/**
	 * @param high the high to set
	 */
	public void setHigh(Float high) {
		this.high = high;
	}
	/**
	 * @return the low
	 */
	public Float getLow() {
		return low;
	}
	/**
	 * @param low the low to set
	 */
	public void setLow(Float low) {
		this.low = low;
	}
	/**
	 * @return the close
	 */
	public Float getClose() {
		return close;
	}
	/**
	 * @param close the close to set
	 */
	public void setClose(Float close) {
		this.close = close;
	}
	/**
	 * @return the vwap
	 */
	public Float getVwap() {
		return vwap;
	}
	/**
	 * @param vwap the vwap to set
	 */
	public void setVwap(Float vwap) {
		this.vwap = vwap;
	}
	/**
	 * @return the volume
	 */
	public Long getVolume() {
		return volume;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	/**
	 * @return the deliveryVolume
	 */
	public Long getDeliveryVolume() {
		return deliveryVolume;
	}
	/**
	 * @param deliveryVolume the deliveryVolume to set
	 */
	public void setDeliveryVolume(Long deliveryVolume) {
		this.deliveryVolume = deliveryVolume;
	}
	/**
	 * @return the percentageDelivery
	 */
	public Float getPercentageDelivery() {
		return percentageDelivery;
	}
	/**
	 * @param percentageDelivery the percentageDelivery to set
	 */
	public void setPercentageDelivery(Float percentageDelivery) {
		this.percentageDelivery = percentageDelivery;
	}
	
	
}
