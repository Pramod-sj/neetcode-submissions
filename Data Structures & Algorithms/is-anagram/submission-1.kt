class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        var sHashSet = mutableMapOf<Char,Int>()
        for(i in 0 until s.length){
            val currChar = s[i]
            val existCharCount = sHashSet[currChar]
            if(existCharCount != null){
                sHashSet[currChar] = existCharCount + 1
            } else {
                sHashSet[currChar] = 1
            }
        }

        for(i in 0 until t.length){
            val currChar = t[i]
            val existCharCount = sHashSet[currChar]
            if(existCharCount != null){
                val new = existCharCount - 1
                if(new == 0){
                    sHashSet.remove(currChar)
                } else {
                    sHashSet[currChar] = new
                }
            }
        }

        return sHashSet.isEmpty()
    }
}
