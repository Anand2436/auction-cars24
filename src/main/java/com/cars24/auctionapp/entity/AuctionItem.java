package com.cars24.auctionapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cars24.auctionapp.entity.AuctionItem;

@Entity
@Table(name="cars24_auction_item")
public class AuctionItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column(name="item_code",nullable=false,unique=true,length=10)
	private String itemCode;

	@Column(name="base_price",nullable=false)
	private Integer minPrice;
	
	/**
	 * At start maxPrice till now will be same as minPrice
	 */
	@Column(name="max_price_till_now",nullable=false)
	private Integer maxBidPriceTillNow;
	
	@Column(name="step_rate",nullable=false)
	private Integer stepRate;
	
	/**
	 * Can have two values :R-> Running
	 * C-> Closed
	 */
	@Column(name="auction_status")
	private String auctionStatus;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)  
	@JoinColumn(name="item_id")
	private List<AuctionBid> bids;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getMaxBidPriceTillNow() {
		return maxBidPriceTillNow;
	}

	public void setMaxBidPriceTillNow(Integer maxBidPriceTillNow) {
		this.maxBidPriceTillNow = maxBidPriceTillNow;
	}

	public Integer getStepRate() {
		return stepRate;
	}

	public void setStepRate(Integer stepRate) {
		this.stepRate = stepRate;
	}

	public String getAuctionStatus() {
		return auctionStatus;
	}

	public void setAuctionStatus(String auctionStatus) {
		this.auctionStatus = auctionStatus;
	}

	public List<AuctionBid> getBids() {
		return bids;
	}

	public void setBids(List<AuctionBid> bids) {
		this.bids = bids;
	}
	
	
	
}
