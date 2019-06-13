package trie;

import java.util.HashMap;

public class MapSum {
    private class Node {
        public int value;
        public HashMap<Character, Node> next;
        public Node(int value) {
            this.value = value;
            next = new HashMap<>();
        }

        public Node() {this(0);}

    }

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node(0));
            }
            cur = cur.next.get(c);
        }

        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        return sumHelper(cur);
    }

    private int sumHelper(Node node) {
        if (node.next.size() == 0) {
            return node.value;
        }
        int cnt = node.value;
        for (char c : node.next.keySet()) {
            cnt += sumHelper(node.next.get(c));
        }
        return cnt;
    }

}
