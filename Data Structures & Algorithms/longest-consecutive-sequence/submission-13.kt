


class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.size <= 1) return nums.size

        val hash = HashSet<Int>()
        for (i in nums) {
            hash.add(i)
        }

        val sequenceStart = HashSet<Int>()
        var curr = hash.first()
        var i = 0
        var processingSequence = false
        for (i in hash) {
            if(!hash.contains(i - 1)){
                sequenceStart.add(i)                
            }
        }

        print(sequenceStart.toString())

        var longestSeqCount = 0        

        for(start in sequenceStart) {
            var currCount = 0
            var currStart = start
            for(i in hash){
                if(hash.contains(currStart)){
                    currStart++
                    currCount++
                    continue
                } 
                break
            }
            longestSeqCount = maxOf(longestSeqCount,currCount)
        }
        return longestSeqCount
    }
}
