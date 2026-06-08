
class Solution {
    fun isValid(s: String): Boolean {
        val hashMap = mapOf(
            '}' to '{' ,
            ')' to '(' ,
            ']' to '['
        )
        val stack = ArrayDeque<Char>()
        for (i in 0 until s.length) {
            val curr = s[i]
            if (curr == '{' || curr == '(' || curr == '[') {
                stack.addLast(curr)
                continue
            } 

            if(stack.isEmpty()) return false
           
            if(hashMap[curr] != stack.removeLast()) return false
           
        }
        return stack.isEmpty()
    }
}
