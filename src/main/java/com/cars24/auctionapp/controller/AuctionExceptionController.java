package com.cars24.auctionapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cars24.auctionapp.auctionresponse.AuctionResponse;
import com.cars24.auctionapp.exceptionresponses.AuctionNotFoundException;
import com.cars24.auctionapp.exceptionresponses.BidRejectedException;

@ControllerAdvice
public class AuctionExceptionController {

	@ExceptionHandler
	@SuppressWarnings({ "unchecked", "rawtypes" })
	ResponseEntity<AuctionResponse> handleException(AuctionNotFoundException auctionNotFoundException){
		AuctionResponse AuctionResponse = new AuctionResponse(HttpStatus.NOT_FOUND.value(),auctionNotFoundException.getMessage());
		
		return new ResponseEntity(AuctionResponse,HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler
	ResponseEntity<AuctionResponse> handleException(BidRejectedException bidRejectedException){
		AuctionResponse AuctionResponse = new AuctionResponse(HttpStatus.NOT_ACCEPTABLE.value(),bidRejectedException.getMessage());
		
		return new ResponseEntity(AuctionResponse,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler
	@SuppressWarnings({ "unchecked", "rawtypes" })
	ResponseEntity<AuctionResponse> handleException(Exception exc){
		AuctionResponse AuctionResponse = new AuctionResponse(HttpStatus.BAD_REQUEST.value(),exc.getMessage());
		//AuctionResponse.setMessage("Bad Request.Please contact system administrator.");
		return new ResponseEntity(AuctionResponse,HttpStatus.BAD_REQUEST);
	}
	
	
}
