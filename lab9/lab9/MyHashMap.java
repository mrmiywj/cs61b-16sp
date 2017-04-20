package lab9;

import java.util.*;

/**
 * Created by ivan on 4/20/17.
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    private class Entry{
        K key;
        V val;

        public Entry(K k, V v) {
            key = k;
            val = v;
        }
    }

    private int n; // number of K-V pairs
    private int m; // number of slots
    private double factor; // loadFactor = n/m;
    private HashSet<K> keys;

    private ArrayList<LinkedList<Entry>> table;

    private void inittable() {
        for (int i = 0; i < m; i++) {
            table.add(new LinkedList<Entry>());
        }
    }

    public MyHashMap(){
        table = new ArrayList<LinkedList<Entry>>(4);
        keys = new HashSet<K>();
        m = 4;
        n = 0;
        factor = 2;
        inittable();
    }
    public MyHashMap(int initialSize){
        table = new ArrayList<LinkedList<Entry>>(initialSize);
        keys = new HashSet<K>();
        m = initialSize;
        n = 0;
        factor = 2;
        inittable();
    }
    public MyHashMap(int initialSize, double loadFactor){
        table = new ArrayList<LinkedList<Entry>>(initialSize);
        keys = new HashSet<K>();
        m = initialSize;
        n = 0;
        factor = loadFactor;
        inittable();
    }

    @Override
    public void clear() {
        table.clear();
        keys.clear();
        n = 0;
    }

    @Override
    public boolean containsKey(K key) {
        return keys.contains(key);
    }

    @Override
    public V get(K key) {
        if (!keys.contains(key)) return null;
        int pos = key.hashCode() % m;
        for (Entry e: table.get(pos)) {
            if (e.key.equals(key)) return e.val;
        }
        return null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void put(K key, V value) {
        if ((n + 1) / m > factor) resize();
        keys.add(key);
        int pos = (key.hashCode() % m  + m) % m;
        LinkedList<Entry> l = table.get(pos);
        if (l == null) {
            l = new LinkedList<Entry>();
            l.add(new Entry(key, value));
        } else {
            l.add(new Entry(key, value));
        }
        n += 1;
    }

    private void resize() {
        int size = (int) (n / factor) * 2 + 1;
        ArrayList<LinkedList<Entry>> tmp = new ArrayList<LinkedList<Entry>>(size);
        m = size;
        for (int i = 0; i < size; i ++ ) {
            tmp.add(new LinkedList<Entry>());
        }
        for (LinkedList<Entry> l: table) {
            for (Entry e: l) {
                int pos = e.key.hashCode() % m;
                LinkedList<Entry> li = tmp.get(pos);
                if (li == null) {
                    li = new LinkedList<Entry>();
                }
                li.add(new Entry(e.key, e.val));
            }
        }
        table = tmp;
    }

    @Override
    public Set<K> keySet() {
        return keys;
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
    public Iterator<K> iterator() {
        return keys.iterator();
    }
}
