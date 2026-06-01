class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashTable = mutableMapOf<Int,Int>()
        for(i in 0 until nums.size){
            val pos = hashTable[nums[i]]
            if(pos!=null) {
                return intArrayOf(pos,i)
            }
            val complimentory = target - nums[i]
            hashTable[complimentory] = i
        }
        return intArrayOf()
    }
}
