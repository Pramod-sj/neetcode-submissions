class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        for(m in matrix) {
            if(target >= m[0] && target <= m[m.size-1]) { 
                return binarySearch(m,target)
            }
        }
        return false
    }

    fun binarySearch(array: IntArray, target: Int) : Boolean {
        var left = 0
        var right = array.size - 1
        while(left <= right) {
            val mid = left + (right - left) / 2
            if(array[mid] == target){
                return true
            } else if (array[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return false
    }
}
