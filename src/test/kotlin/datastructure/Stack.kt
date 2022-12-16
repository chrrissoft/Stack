import org.junit.Test
import stack.stack

class Stack {

    @Test
    fun `put stack`() {
        val seen = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val stack = stack(listOf(1, 2, 3, 4, 5, 6, 7, 8))
        assert(stack.get() == seen.reversed())
    }

    @Test
    fun `pop stack`() {
        val seen = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val stack = stack(listOf(1, 2, 3, 4, 5, 6, 7, 8))
        stack.pop()
        assert(stack.get() != seen.reversed())
    }

    @Test
    fun `pop method return false when the stack is empty`() {
        val seen = listOf<Int>()
        val stack = stack(seen)
        assert(!stack.pop())
    }

    @Test
    fun `clear stack`() {
        val stack = stack(listOf(1, 2, 3, 4, 5, 6, 7, 8))
        stack.clear()
        println(stack.get())
        assert(stack.isEmpty())
    }

    @Test
    fun `top method get the top and remove it`() {
        val seen = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val stack = stack(seen)
        val top = stack.top()
        assert(top == 8 && stack.getSize() == seen.size - 1)
    }

    @Test
    fun `top method throws an error when stack is empty`() {
        data class Demo(val some: Int)

        val stack = stack<Demo>(emptyList())
        try {
            stack.top()
            println("try stack")
        } catch (e: Exception) {
            println("catch stack")
            assert(true)
        }
    }


}
