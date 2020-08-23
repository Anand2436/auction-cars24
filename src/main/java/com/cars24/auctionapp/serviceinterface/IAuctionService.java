package com.cars24.auctionapp.serviceinterface;

import java.util.List;

import com.cars24.auctionapp.auctionresponse.AuctionResponse;
import com.cars24.auctionapp.pagination.PaginatedAuctionObject;
import com.cars24.auctionapp.entity.AuctionItem;

public interface IAuctionService {
	List<AuctionItem> fetchRunningAuctions();
	
	AuctionResponse placeAuctionBid(String itemCode, Integer bidAmount);

	PaginatedAuctionObject fetchRunningAuctionsPaginated(Integer start, Integer limit);
	
}
