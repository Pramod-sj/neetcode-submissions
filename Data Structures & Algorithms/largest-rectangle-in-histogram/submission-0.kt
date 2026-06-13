
class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val heights = heights.toMutableList().apply { add(0) }.toIntArray()
        val stack = ArrayDeque<Pair<Int, Int>>() // saving (value , index)
        var maxArea = 0
        for (i in heights.indices) {
            if (stack.isEmpty() || heights[i] >= stack.last().first) {
                stack.addLast(heights[i] to i)
            } else {
                var last: Pair<Int, Int>? = null
                while (stack.isNotEmpty() && stack.last().first > heights[i]) {
                    last = stack.removeLast()
                    val width = i - last.second
                    maxArea = maxOf(maxArea, last.first * width)
                    print(" ${last.first * width} :")
                }
                last?.second?.let {
                    stack.addLast(heights[i] to last.second)
                }
            }
        }
        return maxArea
    }
}