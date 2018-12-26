package binarySearchTree;


import stack.LinkedListStack;
import stack.Stack;

import java.util.ArrayList;

public class BST<E extends Comparable<E>> {


    private TreeNode root;
    private int size;



    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = addHelper(root, e);
    }

    public boolean contains(E e) {
        return containsHelper(root, e);
    }


    public ArrayList<E> preOrder() {
        ArrayList<E> list = new ArrayList<>();
        preOrderHelper(root, list);
        return list;
    }

    public ArrayList<E> inOrder() {
        ArrayList<E> list = new ArrayList<>();
        inOrderHelper(root, list);
        return list;
    }


    private void inOrderHelper(TreeNode node, ArrayList<E> list) {
        if (node == null) {
            return;
        }
        inOrderHelper(node.left, list);
        list.add((E)node.e);
        inOrderHelper(node.right, list);
    }


    private void preOrderHelper(TreeNode node, ArrayList<E> list) {
        if (node == null) {
            return;
        }
        list.add((E)node.e);
        preOrderHelper(node.left, list);
        preOrderHelper(node.right, list);
    }


    private boolean containsHelper(TreeNode node, E e) {
        if (node == null) {
            return false;
        }
        int comp = e.compareTo((E)node.e);
        if (comp == 0) {
            return true;
        } else if (comp < 0) { // e smaller than node
            return containsHelper(node.left, e);
        } else {
            return containsHelper(node.right, e);
        }
    }

    /**
     * Insert element into the BST
     * @param node
     * @param e
     * @return node
     */
    private TreeNode addHelper(TreeNode node, E e) {
        if (node == null) {
            size += 1;
            return new TreeNode(e);
        }

        if (e.compareTo((E)node.e) < 0) {
            node.left = addHelper(node.left, e);
        } else if (e.compareTo((E)node.e) > 0) {
            node.right = addHelper(node.right, e);
        }

        return node;
    }

}
