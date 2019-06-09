package stack;
import linkedlist.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private  LinkedList<E> list;
    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("Top [");
        for (int i = 0; i < list.getSize(); i++) {
            res.append(list.get(i));
            if (i != list.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
