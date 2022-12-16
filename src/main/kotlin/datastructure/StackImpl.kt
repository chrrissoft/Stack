package stack

import LinkedList
import linkedList

class StackImpl<T>() : Stack<T> {

    private lateinit var linkedList: LinkedList<T>

    constructor(list: List<T>) : this() {
        linkedList = linkedList(list)
    }

    constructor(element: T?) : this() {
        linkedList = linkedList(element)
    }

    override fun top(): T {
        return if (linkedList.getTheLast() == null) throw IllegalAccessException()
        else {
            val element = linkedList.getTheLast()!!
            linkedList.removeLast()
            element
        }
    }

    override fun topOrUnderflow(unUnderflow: () -> Unit) : T? {
        return if(linkedList.getTheLast() == null) {
            unUnderflow()
            null
        }
        else top()
    }

    override fun pop(): Boolean {
        return if (linkedList.getTheLast() == null) false
        else linkedList.removeLast()
    }

    override fun popOrUnderflow(unUnderflow: () -> Unit): Boolean {
        return if(linkedList.getTheLast() == null) {
            unUnderflow()
            false
        }
        else pop()
    }

    override fun put(element: T): Boolean {
        return try {
            linkedList.add(element)
            true
        } catch (e: IllegalStateException) {
            false
        }
    }

    override fun put(elements: List<T>): Boolean {
        return try {
            linkedList.addAll(elements)
            true
        } catch (e: IllegalStateException) {
            false
        }
    }

    override fun get(): List<T> {
        return linkedList.getAll().reversed()
    }

    override fun clear() {
        linkedList.removeAll()
    }

    override fun isEmpty() = linkedList.isEmpty()

    override fun isNotEmpty() = linkedList.isNotEmpty()

    override fun getSize() = linkedList.size()

}
