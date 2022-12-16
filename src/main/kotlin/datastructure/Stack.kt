package stack

interface Stack<T> {

    /**
     * returns the last element that was added of the stack,
     * and remove that element from the stack
     * @throws IllegalStateException if the stack is empty
     * */
    fun top(): T

    /**
     * returns the last element that was added of the stack,
     * and remove that element from the stack.
     * if the stack is empty then unUnderflow is called and returns null
     * */
    fun topOrUnderflow(unUnderflow: () -> Unit): T?

    /**
     * remove the last element that was added of
     * the stack if it is not empty
     * @return true if the element was removed
     * */
    fun pop(): Boolean

    /**
     * remove the last element that was added of
     * the stack if it is not empty and the unUnderflow is called
     * @return true if the element was removed
     * */
    fun popOrUnderflow(unUnderflow: () -> Unit): Boolean

    /**
     * add a new element to the stack
     * @return true if the element was added
     * */
    fun put(element: T): Boolean

    /**
     * add a new list elements to the stack
     * @return true if the elements was added
     * */
    fun put(elements: List<T>): Boolean

    /**
     * @return the complete stack as list it
     * begins from the element on top
     * */
    fun get(): List<T>

    /**
     * clean up the stack
     **/
    fun clear()

    /**
     * @return true if the stack is empty
     * */
    fun isEmpty(): Boolean

    /**
     * @return true if the stack is not empty
     * */
    fun isNotEmpty(): Boolean

    /**
     * @return the size of the stack
     **/
    fun getSize(): Int

}
