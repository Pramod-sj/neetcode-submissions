class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var left = 0
        var right = (matrix.size * matrix[0].size) - 1
        val height = matrix[0].size
        while(left <= right) {
            val mid = left + (right - left) / 2
            val rowMid = mid / height
            val colMid = mid % height
            if(matrix[rowMid][colMid] == target){
                return true
            } else if (matrix[rowMid][colMid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }    
        return false
    }
}
