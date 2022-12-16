abstract class LinkedList<T> {

    /**
     * These property is used to determine the head of the list
     * and the last element of the list. These are protected for
     * prevent that other object can it manipulate
     */
    protected abstract var head: Node<T>?
    protected abstract var last: Node<T>?

    /**
     * used to simply get the head of list
     * @return Node<T>
     */
    fun getTheHead(): T? = head?.data

    /**
     * used to simply get the last element of list
     * @return Node<T>
     */
    fun getTheLast(): T? = last?.data

    /**
     * remove the given element, use referential equality
     * @param element is the element to remove
     * @return Boolean indicating if element is removed
     */
    abstract fun remove(element: T): Boolean

    /**
     * remove all elements of list
     * @return Boolean indicating if element is removed
     */
    abstract fun removeAll(): Boolean

    /**
     * remove the head element of list, if list is empty return false
     * if list has 1 element remove that element
     * @return Boolean indicating if head element is removed
     */
    abstract fun removeHead(): Boolean

    /**
     * remove the last element of list, if list is empty return false
     * if list has 1 element remove that element
     * @return Boolean indicating if last element is removed
     */
    abstract fun removeLast(): Boolean

    /**
     * remove the element at the given index
     * @param index is the index of element to remove
     * @return Boolean indicating if element is removed
     */
    abstract fun removeAt(index: Int): Boolean

    /**
     * add the element at last position of the list
     * @param element is the element to add
     * @return Boolean indicating if element is adding
     */
    abstract fun add(element: T): Boolean

    /**
     * add the element at given index of the list
     * @param element is the element to adding
     * @return Boolean indicating if element is adding
     */
    abstract fun addAt(index: Int, element: T): Boolean

    /**
     * add an element list to the list
     * @param elements is the elements to adding
     * @return Boolean indicating if elements is adding
     */
    abstract fun addAll(elements: List<T>): Boolean

    /**
     * replace an element with a new given element, use referential equality
     * @param oldElement is the element to replace
     * @param newElement is the element to insert
     * @return Boolean indicating if element is replaced
     */
    abstract fun replace(oldElement: T, newElement: T): Boolean

    /**
     * replace the head with a new given head, use head property
     * if list has 1 element remove that element
     * @param newHead is the element to insert
     * @return Boolean indicating if head is replaced
     */
    abstract fun replaceHead(newHead: T): Boolean

    /**
     * replace the last with a new given last, use last property
     * if list has 1 element remove that element
     * @param newLast is the element to insert
     * @return Boolean indicating if last is replaced
     */
    abstract fun replaceLast(newLast: T): Boolean

    /**
     * replace the element at the given index with a new given element
     * @param index is the index of the element to replace
     * @param element is the element to insert
     * @return Boolean indicating if head is replaced
     */
    abstract fun replaceAt(index: Int, element: T): Boolean

    /**
     * get the element at the given index
     * @param index is the index to get the element
     * @return T? element or null if index is out of range
     */
    abstract fun getAt(index: Int): T?

    /**
     * get all elements of the list
     * @return List<T> list of elements
     */
    abstract fun getAll(): List<T>

    /**
     * used to know if the list is empty
     * @return true if the list is empty else false
     */
    abstract fun isEmpty(): Boolean

    /**
     * used to know if the list is not empty
     * @return false if the list is not empty else true
     */
    abstract fun isNotEmpty(): Boolean

    /**
     * used to get the size of the list
     */
    abstract fun size(): Int
}
