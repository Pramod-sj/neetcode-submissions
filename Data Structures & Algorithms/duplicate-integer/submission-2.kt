class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val hashSet = mutableSetOf<Int>()
        for(num in nums){
            if(hashSet.contains(num)) return true
            hashSet.add(num)
        }
        return false
    }
}
