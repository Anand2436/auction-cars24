package com.cars24.auctionapp.exceptionresponses;

public class AuctionNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuctionNotFoundException() {
	}

	public AuctionNotFoundException(String message) {
		super(message);
	}

	public AuctionNotFoundException(Throwable cause) {
		super(cause);
	}

	public AuctionNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuctionNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
