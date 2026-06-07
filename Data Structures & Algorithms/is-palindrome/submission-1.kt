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
        if (digit in 48..57) return true
        if (digit in 65..90) return true
        if (digit in 97..122) return true
        return false
    }
}