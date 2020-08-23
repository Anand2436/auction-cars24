package com.cars24.auctionapp.exceptionresponses;

public class BidRejectedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BidRejectedException() {
	}

	public BidRejectedException(String message) {
		super(message);
	}

	public BidRejectedException(Throwable cause) {
		super(cause);
	}

	public BidRejectedException(String message, Throwable cause) {
		super(message, cause);
	}

	public BidRejectedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
