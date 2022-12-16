fun <T> linkedList(element: T? = null): LinkedList<T> {
    val instance = LinkedListImpl<T>()
    if (element != null) instance.add(element)
    return instance
}

fun <T> linkedList(list: List<T>): LinkedList<T> {
    val instance = LinkedListImpl<T>()
    instance.addAll(list)
    return instance
}
