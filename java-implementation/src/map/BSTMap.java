package map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = addHelper(root, key, value);
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException("Key Error: does not exist");
        }
        root = removeHelper(root, key);
        return node.value;
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(root, key);
        return node != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    @Override
    public void set(K key, V val) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException("Key Error, does not exist");
        }
        node.value = val;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /****************** Private Members *********************/
    private Node addHelper(Node node, K key, V value) {
        if (node == null) {
            size += 1;
            return new Node(key, value);
        }
        int comp = key.compareTo(node.key);
        if (comp < 0) {
            node.left = addHelper(node.left, key, value);
        } else if (comp > 0) {
            node.right = addHelper(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        int comp = key.compareTo(node.key);

        if (comp < 0) {
            return getNode(node.left, key);
        } else if (comp > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    private Node removeHelper(Node node, K key) {

        if (node == null) {
            return null;
        }
        size -= 1;

        int comp = key.compareTo(node.key);
        if (comp < 0) {
            node.left = removeHelper(node.left, key);
        } else if (comp > 0) {
            node.right = removeHelper(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            // node.left != null && node.right != null
            Node minNode = findMinimumNode(node.right);
            node.key = minNode.key;
            node.value = minNode.value;
            node.right = removeHelper(node.right, minNode.key);
        }

        return node;
    }

    private Node findMinimumNode(Node node) {
        if (node.left == null) {
            return node;
        }
        return findMinimumNode(node.left);
    }
}
