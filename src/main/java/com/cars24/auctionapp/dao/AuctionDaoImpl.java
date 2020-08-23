package com.cars24.auctionapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.cars24.auctionapp.auctionresponse.AuctionResponse;
import com.cars24.auctionapp.daointerface.IAuctionDao;
import com.cars24.auctionapp.entity.AuctionBid;
import com.cars24.auctionapp.entity.AuctionItem;
import com.cars24.auctionapp.exceptionresponses.AuctionNotFoundException;

@Repository
public class AuctionDaoImpl implements IAuctionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<AuctionItem> fetchRunningAuctions() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<AuctionItem> theQuery = 
				currentSession.createQuery("from AuctionItem where auctionStatus = :status order by id",
						AuctionItem.class);
		theQuery.setParameter("status", "R");
		List<AuctionItem> auctionItems = theQuery.getResultList();
		return auctionItems;
	}
	
	private AuctionItem findAuctionWithItemCode(String itemCode) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<AuctionItem> theQuery = 
				currentSession.createQuery("from AuctionItem where itemCode = :code",
						AuctionItem.class);
		theQuery.setParameter("code", itemCode);
		List<AuctionItem> auctionItems = theQuery.getResultList();
		if(auctionItems.size()==0) {
			throw new AuctionNotFoundException("Sorry, No auction found");
		}
		return auctionItems.get(0);
	}

	public AuctionResponse placeAuctionBid(String itemCode, Integer bidAmount) {
		
		AuctionItem auctionItem = findAuctionWithItemCode(itemCode);
		String isBidAcceptedReason = validateBidAmountForAuctionItem(auctionItem,bidAmount);
		AuctionBid auctionBid = new AuctionBid();
		if("Accepted".equals(isBidAcceptedReason)) {
			
			auctionBid.setAcceptanceStatus("Accepted");
			auctionBid.setAmount(bidAmount);
			auctionBid.setStatusRemark("Accepted as the bid amount was correct");
			auctionItem.setMaxBidPriceTillNow(bidAmount);
			// need to set itemid or not
			
		} else {
			auctionBid.setAcceptanceStatus("Rejected");
			auctionBid.setAmount(bidAmount);
			auctionBid.setStatusRemark(isBidAcceptedReason);
		}
		//currentSession.save(auctionBid);
		// need to save auctionbid or not
		List<AuctionBid> auctionBids = auctionItem.getBids();
		auctionBids.add(auctionBid);
		auctionItem.setBids(auctionBids);
		if(!"Accepted".equals(isBidAcceptedReason)) {
			return new AuctionResponse(HttpStatus.NOT_ACCEPTABLE.value(),"Sorry, Bid is rejected");
		}
		return new AuctionResponse(HttpStatus.CREATED.value(),"Bid Accepted");
	}
	
	private String validateBidAmountForAuctionItem(AuctionItem auctionItem,Integer bidAmount) {
		if("C".equals(auctionItem.getAuctionStatus())) {
			return "Rejected as auction was closed";
		}
		Integer minAmount = auctionItem.getMinPrice();
		Integer lastPrice = auctionItem.getMaxBidPriceTillNow();
		Integer step = auctionItem.getStepRate();
		
		if(bidAmount>minAmount && bidAmount>=lastPrice+step) {
			return "Accepted";
		}
		return "Rejected as bid amount was incorrect";
	}

}
