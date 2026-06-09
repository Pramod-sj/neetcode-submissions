
class MinStack() {

    val stack = ArrayDeque<Int>()
    val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        if (minStack.isEmpty() || minStack.last() >= `val`) {
            minStack.addLast(`val`)
        }
    }

    fun pop() {
        if (stack.removeLast() == minStack.last()) {
            minStack.removeLast()
        }
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }
}
