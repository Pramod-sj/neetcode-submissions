class Solution {
    fun trap(height: IntArray): Int {
        val prefixArr = IntArray(height.size)
        var prefixCurrMax = prefixArr[0]
        for(i in 0 until height.size){
            prefixCurrMax = max(prefixCurrMax, height[i])
            prefixArr[i] = prefixCurrMax
        }
        val suffixArr = IntArray(height.size)
        var suffixCurrMax = suffixArr[height.size - 1]
        for(i in height.size - 1 downTo 0){
            suffixCurrMax = max(suffixCurrMax, height[i])
            suffixArr[i] = suffixCurrMax
        }

        var totalRainWater = 0

        for(i in height.indices){
            val currIndexTrapped = min(prefixArr[i],suffixArr[i]) - height[i]
            totalRainWater += currIndexTrapped
        }

        return totalRainWater
    }
}
