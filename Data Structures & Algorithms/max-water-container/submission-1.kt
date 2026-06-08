class Solution {
    fun maxArea(heights: IntArray): Int {
        var maxVolume = 0
        var left = 0
        var right = heights.size - 1
        while(left < right) {
            val leftHeight = heights[left]
            val rightHeight = heights[right]
            val totalVolume = (right - left) * minOf(leftHeight,rightHeight)
            maxVolume = maxOf(maxVolume,totalVolume)
            if(leftHeight < rightHeight){
                left++
            }else{
                right--
            }
        }
        return maxVolume
    }
}
