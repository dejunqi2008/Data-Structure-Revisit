package map;

public interface Map<K, V> {
    void add(K key, V val);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V val);
    int getSize();
    boolean isEmpty();
}
