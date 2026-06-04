class Solution {

    fun encode(strs: List<String>): String {
        if(strs.size == 0) return ""
        
        return strs.map{it.replace("","NO_SPACE")}.joinToString("||"){ it }
    }

    fun decode(str: String): List<String> {
        if(str.isBlank()) return listOf<String>()
        return str.split("||").map{it.replace("NO_SPACE","")}
    }
}
