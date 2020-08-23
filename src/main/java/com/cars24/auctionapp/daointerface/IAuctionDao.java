package com.cars24.auctionapp.daointerface;

import java.util.List;

import com.cars24.auctionapp.auctionresponse.AuctionResponse;
import com.cars24.auctionapp.entity.AuctionItem;

public interface IAuctionDao {
	List<AuctionItem> fetchRunningAuctions();
	
	AuctionResponse placeAuctionBid(String itemCode, Integer bidAmount);
}
