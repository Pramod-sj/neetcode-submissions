
class Solution {

    val stack = ArrayDeque<String>()

    fun evalRPN(tokens: Array<String>): Int {
        for (token in tokens) {
            if (token == "+") {
                stack.addLast((stack.removeLast().toInt() + stack.removeLast().toInt()).toString())
            } else if (token == "-") {
                val last = stack.removeLast().toInt()
                val secondLast = stack.removeLast().toInt()
                stack.addLast((secondLast - last).toString())
            } else if (token == "*") {
                stack.addLast((stack.removeLast().toInt() * stack.removeLast().toInt()).toString())
            } else if (token == "/") {
                val last = stack.removeLast().toInt()
                val secondLast = stack.removeLast().toInt()
                stack.addLast((secondLast / last).toString())
            } else {
                stack.addLast(token)
            }
        }
        return stack.last().toInt()
    }
}
