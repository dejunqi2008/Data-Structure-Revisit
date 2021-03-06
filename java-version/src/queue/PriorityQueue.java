package queue;

import maxheap.MaxHeap;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{

    private MaxHeap<E> heap;

    public PriorityQueue() {
        heap = new MaxHeap<>();
    }

    @Override
    public void enqueue(E e) {
        heap.add(e);
    }

    @Override
    public E dequeue() {
        return heap.popMax();
    }

    @Override
    public E getFront() {
        return heap.peek();
    }

    @Override
    public int getSize() {
        return heap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
