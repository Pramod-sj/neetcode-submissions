
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val visited = mutableMapOf<Char, Int>()
        var maxSize = 0
        var l = 0
        var r = l
        while (r < s.length) {
            val index = visited[s[r]]
            if(index != null && index >= l) {            
                l = index + 1               
            } 
            visited[s[r]] = r
            maxSize = max(maxSize, r - l + 1)
            r++
        }
        return maxSize
    }
}
