package set;

import binarySearchTree.BST;

import java.util.ArrayList;

public class TreeSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public TreeSet() {
        bst = new BST<>();
    }

    public TreeSet(E[] elements) {
        for (int i = 0; i < elements.length; i++) {
            bst.add(elements[i]);
        }
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        ArrayList<E> list = bst.inOrder();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            if (i < len - 1) {
                sb.append(list.get(i).toString() + ", ");
            } else {
                sb.append(list.get(i).toString() + " ]");
            }
        }
        return sb.toString();
    }
}
