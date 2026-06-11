class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stackIndex = ArrayDeque<Int>()
        val result = IntArray(temperatures.size)
        for(i in temperatures.indices) {
            if(stackIndex.isEmpty() || temperatures[stackIndex.last()] >= temperatures[i]){
                stackIndex.addLast(i)
            } else {
                while(stackIndex.isNotEmpty() && temperatures[stackIndex.last()] < temperatures[i]){
                    val lastIndex = stackIndex.removeLast()
                    result[lastIndex] = i - lastIndex
                }
                stackIndex.addLast(i)
            }
        }
        return result
    }
}
