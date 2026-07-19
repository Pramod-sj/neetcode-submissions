
class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val hashMap = mutableMapOf<Char, Int>()
        var maxFreq: Map.Entry<Char, Int>? = null
        var maxLength = 0
        var left = 0
        var right = 0
        while (right < s.length) {
            hashMap[s[right]] = (hashMap[s[right]] ?: 0) + 1
            maxFreq = hashMap.maxBy { it.value }
            val subStringLength = (right - left + 1)
            if (subStringLength - maxFreq.value <= k) {
                maxLength = maxOf(maxLength, subStringLength)
                right++
            } else {
                val leftFreq = hashMap[s[left]] ?: 0
                hashMap[s[left]] = (leftFreq - 1).coerceAtLeast(0)
                hashMap[s[right]] = (hashMap[s[right]] ?: 0) - 1
                left++
            }
        }
        return maxLength
    }
}
