package trie;

import java.util.HashMap;

public class Trie {

    private class Node {
        public boolean isWord;
        public HashMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }


    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size += 1;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public boolean search(String word) {
        Node cur = root;
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int i) {
        int len = word.length();
        if (i == len) {
            return node.isWord;
        }

        char c = word.charAt(i);
        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, i + 1);
        } else { // c == '.'
            for (char nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar), word, i + 1)) {
                    return true;
                }
            }
            return false;
        }

    }





}
