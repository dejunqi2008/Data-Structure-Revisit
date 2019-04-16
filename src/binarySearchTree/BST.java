package binarySearchTree;

import stack.LinkedListStack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BST<E extends Comparable<E>> {

    private class TreeNode {
        public E e;
        public TreeNode left, right;

        public TreeNode(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }


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

    public void remove(E e) {
        removeHelper(root, e);
    }

    public E removeMin() {
        E res = minimum();
        root = removeMinHelper(root);
        return res;
    }

    public E removeMax() {
        E res = maximum();
        root = removeMaxHelper(root);
        return res;
    }

    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("Tree is empty");
        }
        return minHelper(root).e;
    }

    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("Tree is empty");
        }
        return maxHelper(root).e;
    }

    public ArrayList<E> preOrder() {
        ArrayList<E> list = new ArrayList<>();
        // preOrderHelper(root, list);
        preOrderHelperIterative(root, list);
        return list;
    }

    public ArrayList<E> inOrder() {
        ArrayList<E> list = new ArrayList<>();
        inOrderHelper(root, list);
        return list;
    }

    public ArrayList<E> postOrder() {
        ArrayList<E> list = new ArrayList<>();
        postOrderHelper(root, list);
        return list;
    }

    /***************** private methods *******************************************/

    private TreeNode removeHelper(TreeNode node, E e) {
        if (node == null) {
            return null;
        }
        int cmp = e.compareTo((E)node.e);
        if (cmp < 0) {
            node.left = removeHelper(node.left, e);

        } else if (cmp > 0) {
            node.right = removeHelper(node.right, e);

        } else { // we found the node that we want to remove
            if (node.left == null) {
                TreeNode right = node.right;
                node.right = null;
                size -= 1;
                return right;
            }
            if (node.right == null) {
                TreeNode left = node.left;
                node.left = null;
                size -= 1;
                return left;
            }
            TreeNode minNode = minHelper(node.right);
            node.e = minNode.e;
            node.right = removeHelper(node.right, (E)minNode.e);
        }
        return node;

    }

    private TreeNode removeMinHelper(TreeNode node) {
        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            size -= 1;
            return rightNode;
        }
        node.left = removeMinHelper(node.left);
        return node;
    }

    private TreeNode removeMaxHelper(TreeNode node) {
        if (node.right == null) {
            TreeNode left = node.left;
            node.left = null;
            size -= 1;
            return left;
        }
        node.right = removeMaxHelper(node.right);
        return node;
    }

    private TreeNode minHelper(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return minHelper(node.left);
    }

    private TreeNode maxHelper(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return maxHelper(node.right);
    }

    private void postOrderHelper(TreeNode node, ArrayList<E> list) {
        if (node == null) {
            return;
        }
        postOrderHelper(node.left, list);
        postOrderHelper(node.right, list);
        list.add((E)node.e);
    }

    private void inOrderHelper(TreeNode node, ArrayList<E> list) {
        if (node == null) {
            return;
        }
        inOrderHelper(node.left, list);
        list.add((E)node.e);
        inOrderHelper(node.right, list);
    }

    private void levelOrderHelper(TreeNode node, ArrayList<E> list) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add((E)cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


    private void preOrderHelper(TreeNode node, ArrayList<E> list) {
        if (node == null) {
            return;
        }
        list.add((E)node.e);
        preOrderHelper(node.left, list);
        preOrderHelper(node.right, list);
    }

    private void preOrderHelperIterative(TreeNode node, ArrayList<E> list) {
        LinkedListStack<TreeNode> stack = new LinkedListStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add((E)cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
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
