package hashtable;

import java.util.TreeMap;

public class HashTable<K, V> {

    private TreeMap<K, V>[] hashtable;
    private int M; // prime number
    private int size;

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(97);
    }

    private int hash(K key) {
        // key.hashCode() 返回一个有符号的整数, 需要把正负符号去掉. 利用按位与
        // 0x7ffffffff = 0111 1111 1111 .... (64位)
        return key.hashCode() & 0x7fffffff % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        int idx = hash(key);
        TreeMap<K, V> treeMap = hashtable[idx];
        if (!treeMap.containsKey(key)) {
            size++;
        }
        treeMap.put(key, value);
    }

    public V remove(K key) {
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        if (treeMap.containsKey(key)) {
            size--;
            return treeMap.remove(key);
        }
        return null;
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

    public void set(K key, V value) {
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        if (!treeMap.containsKey(key)) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        treeMap.put(key, value);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }


}
