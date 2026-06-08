class Solution {
    fun maxArea(heights: IntArray): Int {
        var maxVolume = 0
        var left = 0
        var right = heights.size - 1
        while(left < right) {
            val totalVolume = (right - left) * minOf(heights[left],heights[right])
            maxVolume = maxOf(maxVolume,totalVolume)
            if(heights[left] < heights[right]){
                left++
            }else{
                right--
            }
        }
        return maxVolume
    }
}
