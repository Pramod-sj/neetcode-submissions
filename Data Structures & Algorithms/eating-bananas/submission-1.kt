class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var minPile = 1
        var maxPile = piles.max()
        var minEatingSpeed = maxPile
        while (minPile <= maxPile) {
            val mid = minPile + (maxPile - minPile) / 2
            val sum = piles.sumOf { ceil(it.toDouble() / mid.toDouble()).roundToInt() }
            if (sum > h) {
                minPile = mid + 1
            } else {
                minEatingSpeed = min(minEatingSpeed, mid)
                maxPile = mid - 1
            }
        }
        return minEatingSpeed
    }
}

