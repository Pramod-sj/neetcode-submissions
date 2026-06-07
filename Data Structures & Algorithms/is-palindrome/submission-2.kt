class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left <= right) {
            if(!isValidChar(s[left])) {
                left++
                continue
            }
            if(!isValidChar(s[right])) {
                right--
                continue
            }
            print(" ${s[left].lowercase()} != ${s[right].lowercase()} ")
            if (s[left].lowercase() != s[right].lowercase()) {
                return false
            }
            left++
            right--
        }
        return true
    }

    private fun isValidChar(char: Char): Boolean {
        val digit = char.code
        if (digit == 36) return true
        if (digit>=48 && digit<=57) return true
        if (digit>=65 && digit<=90) return true
        if (digit>=97 && digit<=122) return true
        return false
    }
}