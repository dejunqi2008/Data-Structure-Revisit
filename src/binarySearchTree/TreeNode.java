package binarySearchTree;

public class TreeNode<E extends Comparable<E>> {
    public E e;
    public TreeNode left, right;

    public TreeNode(E e) {
        this.e = e;
        left = null;
        right = null;
    }
}
