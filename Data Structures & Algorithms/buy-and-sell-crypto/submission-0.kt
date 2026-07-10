class Solution {
    fun maxProfit(prices: IntArray): Int {
        var i = 0
        var j = i + 1
        var maxProfit = 0
        while(j < prices.size) {
            if(prices[i] < prices[j]){
                val profit = prices[j] - prices[i]
                maxProfit = max(maxProfit,profit) 
                j++
            } else {
                i = j
                j = i + 1
            }
        }
        return maxProfit
    }
}
