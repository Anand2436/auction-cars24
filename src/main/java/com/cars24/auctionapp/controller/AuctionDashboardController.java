package com.cars24.auctionapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cars24.auctionapp.auctionresponse.AuctionResponse;
import com.cars24.auctionapp.entity.AuctionItem;
import com.cars24.auctionapp.serviceinterface.IAuctionService;

@Controller
public class AuctionDashboardController {
	
	@Autowired
	IAuctionService auctionService;
	
	
	@RequestMapping("/theAuctionDash")
	public String fetchRunningAuctions(Model model) {
		List<AuctionItem> auctionItems = auctionService.fetchRunningAuctions();
		model.addAttribute("auctionItems",auctionItems);
		return "auction-dashboard";
	}
	
	@PutMapping("/auctions/{itemCode}/{bidAmount}")
	AuctionResponse placeAuctionBid(@PathVariable String itemCode,@PathVariable int bidAmount) {
		return auctionService.placeAuctionBid(itemCode, bidAmount);
	}
}
