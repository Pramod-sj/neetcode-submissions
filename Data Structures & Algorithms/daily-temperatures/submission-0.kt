class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val stackIndex = ArrayDeque<Int>()
        val result = IntArray(temperatures.size)
        for(i in temperatures.indices) {
            if(stack.isEmpty() || stack.last() >= temperatures[i]){
                stack.addLast(temperatures[i])
                stackIndex.addLast(i)
            } else {
                while(stack.isNotEmpty() && stack.last() < temperatures[i]){
                    stack.removeLast()
                    val lastIndex = stackIndex.removeLast()
                    result[lastIndex] = i - lastIndex
                }
                stack.addLast(temperatures[i])
                stackIndex.addLast(i)
            }
        }
        return result
    }
}
