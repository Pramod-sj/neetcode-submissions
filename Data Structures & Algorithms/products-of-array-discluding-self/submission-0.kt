class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {

        val prefixProducts = IntArray(nums.size){ 1 }
        for(i in nums.indices){
            prefixProducts[i] = (prefixProducts.getOrNull(i-1)?:1) * nums[i]
        }        

        val suffixProducts = IntArray(nums.size){ 1 }
        for(i in (nums.size - 1) downTo 0){
            suffixProducts[i] = (suffixProducts.getOrNull(i+1)?:1) * nums[i] 
        }        

        for(i in nums.indices){
            nums[i] = (prefixProducts.getOrNull(i-1)?:1) * (suffixProducts.getOrNull(i+1)?:1)
        }

        return nums
    }
}
