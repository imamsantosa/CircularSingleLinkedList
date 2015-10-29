public class CircularSingleLinkedList {
    class Node {
        Object Element;
        Node Next;
        public Node(Object Element, Node Next) {
            this.Element = Element;
            this.Next = Next;
        }
    }
    
    private Node Tail = null;
    private int size = 0;

    /**
     * to get size atribute
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * to check CSll is Empty
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * to create new node in first
     *
     * @param newElement
     */
    public void addFirst(Object newElement) {
        if (isEmpty()) {
            Tail = new Node(newElement, null);
            Tail.Next = Tail;
        } else {
            Tail.Next = new Node(newElement, Tail.Next);
        }
        size++;
    }

    /**
     * to create new node in last
     * @param newElement
     */
    public void addLast(Object newElement) {
        addFirst(newElement);
        Tail = Tail.Next;
    }

    /**
     * to rotate CSLL
     */
    public void rotate() {
        if (!isEmpty()) {
            Tail = Tail.Next;
        }
    }

    /**
     * to remove node first
     * @return
     */
    public Object removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node remove;
        if (getSize() == 1) {
            remove = Tail;
            Tail = null;
        } else {
            remove = Tail.Next;
            Tail.Next = Tail.Next.Next;
        }
        size--;
        return remove;
    }

    /**
     * to remove node Last
     * @return
     */
    public Object removeLast() {
        if (isEmpty()) {
            return null;
        } else if (getSize() == 1) {
            return removeFirst();
        }

        Node pointer = Tail.Next;
        while (pointer.Next != Tail) {
            pointer = pointer.Next;
        }
        pointer.Next=Tail.Next;
        Tail = pointer;
        size--;
        return pointer;
    }

    /**
     * to remove node Element
     * @param Element
     * @return
     */
    public Object remove(Object Element) {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            if (Tail.Element == Element) {
                return removeFirst();
            } else {
                return null;
            }
        }
        
        Node pointer = Tail.Next;
        boolean find = false;
        int count = getSize();
        while (count != 0) {
            if (pointer.Next.Element == Element) {
                find = true;
                break;
            }
            pointer = pointer.Next;
            count--;
        }
        if (!find) {
            return null;
        }
        if (pointer.Next == Tail) {
            return removeLast();
        } else {
            pointer.Next = pointer.Next.Next;
        }
        size--;
        return pointer;
    }

    /**
     * to print CSLL
     * @param comm
     */
    public void print(String comm) {
        System.out.println(comm + " | " + getSize());
        int count = getSize();
        if (getSize() != 0) {
            Node temp = Tail.Next;
            while (count != 0) {
                System.out.print(temp.Element + "->");
                temp = temp.Next;
                count--;
            }
            System.out.println("");
        } else {
            System.out.println("null");
        }
    }
}
