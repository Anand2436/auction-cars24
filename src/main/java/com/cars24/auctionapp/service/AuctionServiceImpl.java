package com.cars24.auctionapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars24.auctionapp.auctionresponse.AuctionResponse;
import com.cars24.auctionapp.daointerface.IAuctionDao;
import com.cars24.auctionapp.entity.AuctionItem;
import com.cars24.auctionapp.pagination.PaginatedAuctionObject;
import com.cars24.auctionapp.serviceinterface.IAuctionService;

@Service
public class AuctionServiceImpl implements IAuctionService {

	@Autowired
	IAuctionDao auctionDaoImpl;
	
	@Transactional
	public List<AuctionItem> fetchRunningAuctions() {
		return auctionDaoImpl.fetchRunningAuctions();
	}

	@Transactional
	public AuctionResponse placeAuctionBid(String itemCode, Integer bidAmount) {
		return auctionDaoImpl.placeAuctionBid(itemCode, bidAmount);
	}

	@Transactional
	public PaginatedAuctionObject fetchRunningAuctionsPaginated(Integer start, Integer limit) {
		List<AuctionItem> auctionItems = fetchRunningAuctions();
		int counter = 0;
		while(start >=0 && counter<start) {
			counter++;
		}
		int size = auctionItems.size(),limitCounter = 0;
		List<AuctionItem> itemsOnRequestedPage = new ArrayList<AuctionItem>();
		if(limit>=0) {
			while(counter<size && limitCounter<limit) {
				AuctionItem item = auctionItems.get(counter++);
				itemsOnRequestedPage.add(item);
				limitCounter++;
			}
		}
		
		if(start>=0 && limit>=0)
		return new PaginatedAuctionObject(itemsOnRequestedPage,limit,start+limit);
		else {
			return new PaginatedAuctionObject(itemsOnRequestedPage,5,0);
		}  
	}
	
	

}
