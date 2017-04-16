package lab8;

import java.util.*;

/**
 * Created by ivan on 4/16/17.
 */
public class BSTMap<K extends Comparable<K>,V>  implements Map61B<K,V> {

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int size;

        public Node(K key_, V val_, int size_) {
            key = key_;
            val = val_;
            size = size_;
        }
    }

    Node root;

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node n, K key, V val) {
        if (n == null) return new Node(key, val, 1);
        int cmp = key.compareTo(n.key);
        if (cmp < 0) n.left = put(n.left, key, val);
        else if (cmp > 0) n.right = put(n.right, key, val);
        else if (cmp == 0) n.val = val;
        n.size = 1 + size(n.left) + size(n.right);
        return n;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        clear(root);
        root = null;
    }

    private void clear(Node n) {
        if (n == null) return;
        else {
            clear(n.left);
            clear(n.right);
            n.left = null;
            n.right = null;
            return;
        }
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node n, K key) {
        if (n == null) return null;
        int cmp = key.compareTo(n.key);
        if (cmp == 0) return n.val;
        else if (cmp < 0) return get(n.left, key);
        else return get(n.right, key);
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node n) {
        if (n == null) return 0;
        return 1 + size(n.left) + size(n.right);
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
