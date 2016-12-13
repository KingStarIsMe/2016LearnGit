package years.year2016.months11;

public class Solution {
	 /**
     * 计算你能获得的最大收益
     * 
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public int calculateMax(int[] prices) {
    	int buy1=Integer.MIN_VALUE;
    	int sell1=0;
    	int buy2=Integer.MIN_VALUE;
    	int sell2=0;
    	for(int price : prices){
    		buy1 = Math.max(buy1, -price);//price价格买入后损失
    		sell1 = Math.max(sell1, buy1+price);//卖出price价格后所获利
    		buy2 = Math.max(buy2, sell1-price);//price价格买入后损失
    		sell2 = Math.max(sell2, buy2+price);//price卖出后获利
    		
    	}
    	return sell2;
    }
}
