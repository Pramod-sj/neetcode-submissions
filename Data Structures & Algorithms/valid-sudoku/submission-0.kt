
class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val hashMap = HashMap<Char, Boolean>().apply {
            put('1', false)
            put('2', false)
            put('3', false)
            put('4', false)
            put('5', false)
            put('6', false)
            put('7', false)
            put('8', false)
            put('9', false)
        }


        // check if rows are all unique
        for (i in 0 until board.size) {
            val hashTable = HashMap<Char, Boolean>(hashMap)
            for (j in 0 until board[i].size) {
                val currChar = board[i][j]
                if(currChar == '.') continue
                if (hashTable[currChar] == true) {
                    return false
                }
                hashTable[currChar] = true
            }
        }

        // check if columns are all unique
        for (i in 0 until board.size) {
            val hashTable = HashMap<Char, Boolean>(hashMap)
            for (j in 0 until board[i].size) {
                val currChar = board[j][i]
                if(currChar == '.') continue
                if (hashTable[currChar] == true) {
                    return false
                }
                hashTable[currChar] = true
            }
        }

        val box = HashMap<Int, Map<Char, Boolean>>().apply {
            put(0, hashMap)
            put(1, hashMap)
            put(2, hashMap)
            put(3, hashMap)
            put(4, hashMap)
            put(5, hashMap)
            put(6, hashMap)
            put(7, hashMap)
            put(8, hashMap)
            put(9, hashMap)
        }

        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                val squareIndex = ((i / 3) * 3) + (j / 3)
                val currChar = board[i][j]
                if(currChar == '.') continue
                val map = box[squareIndex]?.toMutableMap()
                if (map?.get(currChar) == true) {
                    return false
                }
                map?.put(currChar, true)
                box[squareIndex] = map.orEmpty()
            }
        }

        return true
    }
}
