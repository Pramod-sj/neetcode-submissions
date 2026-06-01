class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val hashTable = mutableMapOf<List<Int>,List<String>>()
        for(string in strs){
            val aToZ = MutableList(26){ -1 }           
            for(i in 0 until string.length){
                val pos = abs(97 - (string[i].toInt()))
                
                val count = aToZ[pos]
                if(count != -1){
                    aToZ[pos] = count + 1                
                } else {
                    aToZ[pos] = 1
                }
            }
            var list = hashTable[aToZ]?.toMutableList()
            if(list!=null){
                list.add(string)
                hashTable[aToZ] = list
            }else{
                hashTable[aToZ] = listOf(string)
            }
        }
        return hashTable.values.toList()
    }
}
