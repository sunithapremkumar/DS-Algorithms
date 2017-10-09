package interviewcake;
/**
 * Suppose we could access yesterday's stock prices as an array, where:

The indices are the time in minutes past trade opening time, which was 9:30am local time.
The values are the price in dollars of Apple stock at that time.
So if the stock cost $500 at 10:30am, stockPricesYesterday[60] = 500.

Write an efficient function that takes stockPricesYesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.
 * @author suni
 *
 */
public class StockPrice {
	
	public int findProfit(int[] stockPrices) throws Exception{
		if(stockPrices == null)
			 return -1;
		if(stockPrices.length <  2)
			throw new Exception("Not enough stock price to find profit");
		int profit =stockPrices[1] - stockPrices[0];
		
		int buyPrice =  stockPrices[0];
		
		for(int i=1; i<stockPrices.length; i++){
			
			if(stockPrices[i] > buyPrice)
				profit = Math.max(profit, stockPrices[i] - buyPrice);
			else
				buyPrice = stockPrices[i];
			
		}
		
		return profit;
	}

}
