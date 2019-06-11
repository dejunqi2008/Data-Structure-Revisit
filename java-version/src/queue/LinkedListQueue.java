package queue;


import linkedlist.Node;

public class LinkedListQueue<E> implements Queue<E> {
    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            head = new Node(e);
            tail = head;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size += 1;
    }

    @Override
    public E dequeue() {
        if (size == 0) {
            throw new IllegalArgumentException("Queue is empty");
        }
        Node target = head;
        head = head.next;
        target.next = null;
        if (head == null) {
            tail = null;
        }
        size -= 1;
        return (E)target.e;
    }

    @Override
    public E getFront() {
        if (size == 0) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return (E)head.e;
    }

    public E getLast() {
        if (size == 0) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return (E)tail.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head.next;
        while (cur != null) {
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

}
