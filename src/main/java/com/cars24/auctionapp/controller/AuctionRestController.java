package com.cars24.auctionapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cars24.auctionapp.auctionresponse.AuctionResponse;
import com.cars24.auctionapp.entity.AuctionItem;
import com.cars24.auctionapp.pagination.PaginatedAuctionObject;
import com.cars24.auctionapp.serviceinterface.IAuctionService;

@RestController
@RequestMapping("/rest")
public class AuctionRestController {
	
	@Autowired
	IAuctionService auctionService;
	
	
	@GetMapping("/auctions")
	List<AuctionItem> fetchRunningAuctions() {
		return auctionService.fetchRunningAuctions();
	}
	
	@GetMapping("/auctions/page")
	PaginatedAuctionObject fetchRunningAuctionsPaginated(@RequestParam Integer start, @RequestParam Integer limit) {
		return auctionService.fetchRunningAuctionsPaginated(start,limit);
	}
	
	@PutMapping("/auctions/{itemCode}/{bidAmount}")
	AuctionResponse placeAuctionBid(@PathVariable String itemCode,@PathVariable int bidAmount) {
		return auctionService.placeAuctionBid(itemCode, bidAmount);
	}
}
