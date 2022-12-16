class LinkedListImpl<T> : LinkedList<T>() {

    override var head: Node<T>? = null
    override var last: Node<T>? = null
    private var count = 0

    private fun initHead(element: T) {
        head = Node(data = element)
        last = head
    }

    override fun add(element: T): Boolean {
        return try {
            if (head == null) {
                initHead(element)
                count += 1
                return true
            }

            val newPoint = Node(data = element)
            last?.next = newPoint
            last = newPoint
            count += 1
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun addAt(index: Int, element: T): Boolean {
        var wasAdd = false

        if (head == null && index == 0) {
            initHead(element)
            count += 1
            return true
        }

        searchAt(index) { _, target, next ->
            val newPoint = Node(data = element)

            // happens when the target is the last
            if (next == null) {
                target.next = newPoint
                last = newPoint
                wasAdd = true
                return@searchAt
            }

            target.next = newPoint
            newPoint.next = next
            wasAdd = true

            return@searchAt
        }

        return wasAdd
    }

    override fun addAll(elements: List<T>): Boolean {
        var wasAdd = false
        elements.forEach {
            wasAdd = add(it)
        }
        return wasAdd
    }

    override fun getAll(): List<T> {
        return try {
            var point = head
            val list = mutableListOf<T>()
            while (point != null) {
                list.add(point.data)
                point = point.next
            }

            return list
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun getAt(index: Int): T? {
        var elements: Node<T>? = null
        searchAt(index) { _, target, _ -> elements = target }
        return elements?.data
    }

    override fun replace(oldElement: T, newElement: T): Boolean {
        var replaced = false

        search(oldElement) { _, target, _ ->
            target.data = newElement
            replaced = true
        }

        return replaced
    }

    override fun replaceAt(index: Int, element: T): Boolean {
        var replaced = false

        searchAt(index) { _, target, _ ->
            target.data = element
            replaced = true
        }

        return replaced
    }

    override fun replaceHead(newHead: T): Boolean {
        if (head == null) return false
        head!!.data = newHead
        return true
    }

    override fun replaceLast(newLast: T): Boolean {
        if (last == null) return false
        return replace(last!!.data, newLast)
    }

    override fun remove(element: T): Boolean {
        var removed = false

        search(element) { previous, _, next ->

            // happens when the target is the head
            // and there is a single element
            if (previous == null && next == null) {
                last = null
                head = null
                count -= 1
                removed = true
                return@search
            }

            // happens when the target is the head
            // and there is more than one element
            if (previous == null) {
                head = next
                count -= 1
                removed = true
                return@search
            }

            // happens when the target is the last
            // and there is more than one element
            if (next == null) {
                previous.next = null
                last = previous
                count -= 1
                removed = true
                return@search
            }

            // happens when the target is in middle
            // and there is more than one element
            previous.next = next
            count -= 1
            removed = true
        }

        return removed
    }

    override fun removeAt(index: Int): Boolean {
        var removed = false

        searchAt(index) { previous, _, next ->

            // happens when the target is the head
            // and there is a single element
            if (previous == null && next == null) {
                last = null
                head = null
                count -= 1
                removed = true
                return@searchAt
            }

            // happens when the target is the head
            // and there is more than one element
            if (previous == null) {
                head = next
                count -= 1
                removed = true
                return@searchAt
            }

            // happens when the target is the last
            // and there is more than one element
            if (next == null) {
                previous.next = null
                last = previous
                count -= 1
                removed = true
                return@searchAt
            }

            // happens when the target is in middle
            // and there is more than one element
            previous.next = next
            count -= 1
            removed = true
        }

        return removed
    }

    override fun removeAll(): Boolean {
        return try {
            getAll().forEach { remove(it) }
            true
        } catch (e: IllegalStateException) {
            false
        }
    }

    override fun removeHead(): Boolean {
        if (head == null) return false
        return remove(head!!.data);
    }

    override fun removeLast(): Boolean {
        if (last == null) return false
        return remove(last!!.data)
    }

    /**
     * used to search the elements by index.
     * @param index is the index of element to search
     * @param operation (previous, target, next) is called
     * when the element is the next element of the current node.
     * This lambda is called with the previous, target and next elements
     * */
    private fun searchAt(
        index: Int,
        operation: (Node<T>?, Node<T>, Node<T>?) -> Unit
    ): Boolean {
        return try {

            if (head == null) return false
            if (index < 0) return false

            var count = 0
            var previous = head
            var target = head?.next
            var next = head?.next?.next

            if (index == 0) {
                operation(null, head!!, head?.next)
                return true
            }

            while (target != null) {
                if (index == count.plus(1)) {
                    operation(previous, target, next)
                    return true
                } else {
                    count++
                    previous = previous?.next
                    target = target.next
                    next = next?.next
                }
            }
            false
        } catch (_: Exception) {
            false
        }
    }

    /**
     * used to search the elements referential equality.
     * @param element is the element to search
     * @param operation (previous, target, next) is called
     * when the element is the next element of the current node.
     * This lambda is called with the previous, target and next elements
     * */
    private fun search(
        element: T,
        operation: (Node<T>?, Node<T>, Node<T>?) -> Unit
    ): Boolean {
        return try {

            if (head == null) return false

            var previous = head
            var target = head?.next
            var next = head?.next?.next

            if (element === head?.data) {
                operation(null, head!!, head!!.next)
                return true
            }

            while (target != null) {
                if (element === target.data) {
                    operation(previous, target, next)
                    return true
                } else {
                    previous = previous?.next
                    next = next?.next
                    target = target.next
                }
            }
            false
        } catch (_: Exception) {
            false
        }
    }

    override fun isEmpty() = count == 0

    override fun isNotEmpty() = count > 0

    override fun size() = count

}
