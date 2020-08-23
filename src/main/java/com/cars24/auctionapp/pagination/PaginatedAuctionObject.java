package com.cars24.auctionapp.pagination;

import java.util.List;

import com.cars24.auctionapp.entity.AuctionItem;

public class PaginatedAuctionObject {
	
	private List<AuctionItem> auctionItems;
	
	private String linkForNextPage;
	
	private Integer limit;
	
	public PaginatedAuctionObject() {
		
	}
	
	public PaginatedAuctionObject(List<AuctionItem> items,Integer limit,Integer start) {
		this.auctionItems = items;
		this.limit = limit;
		this.linkForNextPage = "http://localhost:8080/auction/rest/auctions/page?" + "limit=" + limit.toString() + "&start=" + start.toString(); 
	}

	public List<AuctionItem> getAuctionItems() {
		return auctionItems;
	}

	public void setAuctionItems(List<AuctionItem> auctionItems) {
		this.auctionItems = auctionItems;
	}

	public String getLinkForNextPage() {
		return linkForNextPage;
	}

	public void setLinkForNextPage(String linkForNextPage) {
		this.linkForNextPage = linkForNextPage;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}


}
