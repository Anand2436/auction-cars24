# Auction Application

1. I have developed this project using Spring MVC with Java as I was familiar with the concepts and given the crunch time-lines, I felt It will be the best way to move forward.

2. Code flow and about Code : 
	
	# The entity structure is :
	a.) AuctionItem -> itemCode, basePrice,maxPriceTillNow, bids, status
	b.) AuctionBid -> bidAmount, bidStatus 
	
	# Some assumptions/ declarations:
	-- maxPriceTillNow will be initialized with basePrice
	-- ItemCode is kept unique for each item
	-- ExceptionHandling code is written for Bid rejected and Auction not found
	-- A separate dash-board controller is made for real time broadcasting, where results are updated every 5 seconds which is configurable
	-- Code for pagination of running auction is managed by writing A separate rest call which has query parameters limit and start, and in response it provides the link to next page records
	
3. Setup instructions :
	
	-- Just import as maven project and run the project on server.
	
4. About project flow and functionality :

	-- Running auction Dash-board link is present on index page. 
	
	-- rest calls :
		
		a.) place a bid : post
		http://localhost:8080/auction/rest/auctions/car4/4060
		
		b.) get running auction : get
		http://localhost:8080/auction/rest/auctions
		
		c.) get paginated running auctions : get
		http://localhost:8080/auction/rest/auctions/page?start=0&limit=2