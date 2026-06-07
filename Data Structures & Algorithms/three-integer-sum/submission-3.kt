class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val list = mutableSetOf<List<Int>>()
        for(i in nums.indices){
            var j = i + 1
            var k = nums.size - 1
            while(j < k) { 
                val sum = nums[i] + nums[j] + nums[k]

                if(sum == 0){
                    list.add(listOf(nums[i],nums[j],nums[k]))                                        
                }

                if(sum > 0){
                    k--
                } else {
                    j++
                }
            }
        }
        return list.toList()
    }
}
