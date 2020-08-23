<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.math.BigDecimal,java.util.*,com.cars24.auctionapp.entity.*"%>
<html>
<h2> Running Auctions : </h2>
<script type = "text/JavaScript">
function AutoRefresh( t ) {
    setTimeout("location.reload(true);", t);
 }

</script>
<body onload = "JavaScript:AutoRefresh(5000);">
	                <table class="table table-bordered table-hover" id="auctionTable">

                                <tr bgcolor='cyan'>

                                                <th>Item Code</th>

                                                <th>Base Price</th>

                                                <th>Max Price Till Now</th>

                                                <th>Step Rate</th>
                                </tr>
								
                                <%
                                List<AuctionItem> auctionItems = null;

                                
                                auctionItems = (List<AuctionItem>) request.getAttribute("auctionItems");

                                                for (Iterator<AuctionItem> it = auctionItems.iterator(); it.hasNext();) {

                                                                                AuctionItem auctionItem = (AuctionItem) it.next();

                                %>
								<tr>
                                                <td bgcolor="Silver"><font color="blue"><%= auctionItem.getItemCode() %></font> </td>

                                                <td bgcolor="Yellow"><font color="green"><%= auctionItem.getMinPrice() %> </font></td>

                                                <td bgcolor="Silver"><font color="blue"><%= auctionItem.getMaxBidPriceTillNow() %></font>

                                                </td>

                                                <td bgcolor="Yellow"><font color="green"> <%= auctionItem.getStepRate() %></font>

                                                </td>
							</tr>
                                <%

                                                }

                                %>

              				
                </table>
	
</body>
</html>


