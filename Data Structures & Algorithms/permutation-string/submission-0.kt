

class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {

        val s1HashMap = mutableMapOf<Char, Int>()
        for (s in s1) {
            val freqCount = s1HashMap[s]
            if (freqCount != null) {
                s1HashMap[s] = freqCount + 1
            } else {
                s1HashMap[s] = 1
            }
        }

        val s2HashMap = mutableMapOf<Char, Int>()
        var left = 0
        var right = 0
        while (right < s2.length) {
            val slotSize = (right - left) + 1
            if (slotSize <= s1.length) {
                val freqCount = s2HashMap[s2[right]]
                if (freqCount == null) {
                    s2HashMap[s2[right]] = 1
                } else {
                    s2HashMap[s2[right]] = freqCount + 1
                }
                right++
            } else {
                val leftFreqCount = s2HashMap[s2[left]] ?: 0
                if (leftFreqCount == 1) {
                    s2HashMap.remove(s2[left])
                } else {
                    s2HashMap[s2[left]] = leftFreqCount - 1

                }

                val freqCount = s2HashMap[s2[right]]
                if (freqCount == null) {
                    s2HashMap[s2[right]] = 1
                } else {
                    s2HashMap[s2[right]] = freqCount + 1
                }
                left++
                right++
            }
            if (s1HashMap == s2HashMap) return true
        }
        return false
    }
}
