

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val hashTable = mutableMapOf<Int, Int>()
        for (i in nums) {
            val count = hashTable[i]
            if (count != null) {
                hashTable[i] = count + 1
            } else {
                hashTable[i] = 1
            }
        }
        return hashTable.entries.sortedByDescending { it.value }.take(k).map { it.key }.toIntArray()
    }
}
