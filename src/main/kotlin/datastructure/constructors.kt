package stack

fun <T> stack(elements: List<T> = emptyList()): Stack<T> = StackImpl(elements)

fun <T> stack(element: T? = null): Stack<T> = StackImpl(element)
