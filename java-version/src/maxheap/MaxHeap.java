package maxheap;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public String toString() {
        return data.toString();
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    public E popMax() {
        data.swap(0, data.getSize() - 1);
        E res = data.removeLast();
        siftDwon(0);
        return res;
    }

    public E peek() {
        if (data.getSize() == 0) {
            return null;
        }
        return data.get(0);
    }

    public int getSize() {
        return data.getSize();
    }

    public E replace(E e) {
        E res = peek();
        data.set(0, e);
        siftDwon(0);
        return res;
    }


    /******************* Private Methods *****************************/

    // return parent of element at index
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("root element has not parent");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }


    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            int p = parent(k);
            if (p < 0 || data.get(p).compareTo(data.get(k)) > 0) break;
            data.swap(k, p);
            k = p;
        }
    }

    private void siftDwon(int k) {
        while (leftChild(k) < data.getSize()) {
            int l = leftChild(k);
            if (l + 1 < data.getSize() && data.get(l + 1).compareTo(data.get(l)) > 0) {
                l += 1; // l = rightChild(k)
            }
            if (data.get(l).compareTo(data.get(k)) <= 0) break;
            data.swap(l, k);
            k = l;
        }
    }

}
