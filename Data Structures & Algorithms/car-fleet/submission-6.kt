

class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {

        val zip = position.zip(speed).sortedByDescending { it.first }
        val newPosition = zip.map { it.first }
        val newSpeed = zip.map { it.second }

        val stack = ArrayDeque<Double>()
        var fleetCount = 0

        for (i in newPosition.indices) {
            val time = (target - newPosition[i]) / newSpeed[i].toDouble()
            if(stack.isNotEmpty() &&  time <= stack.last() ){
                continue
            } 
            stack.addLast(time)            
        }
        return stack.size
    }
}
