/**
 * Created by ivan on 2/15/17.
 */
public class ArrayDeque<Item> {

    private Item[] array;

    private int head;
    private int tail;

    private int size;

    private static int INITIAL_SIZE = 8;

    private int getIndex(int index) {
        if (index >=0 && index <= array.length) {
            return index;
        } else {
            if (index > array.length ) {
                return index - array.length;
            } else {
                return array.length + index;
            }
        }
    }

    public ArrayDeque() {
        array = (Item[]) new Object[INITIAL_SIZE];
        size = 0;
    }

    public Item removeFirst() {
        int p = head;
        Item item = array[head];
        if (item == null) {
            return null;
        }
        array[p] = null;
        size -= 1;
        head = (p + 1) & (array.length - 1);
        if (size <= array.length / 2 && array.length > 8) {
            halfCapacity();
        }
        return item;
    }

    private boolean isFull() {
        return (size == array.length);
    }

    private void doubleCapacity() {
        assert head == tail;
        int p = head;
        int n = array.length;
        int r = array.length - head;
        int newCapacity = array.length << 1;
        Object[] a = new Object[newCapacity];
        System.arraycopy(array, p, a, 0, r);
        System.arraycopy(array, 0, a, r, p);
        array = (Item[]) a;
        head = 0;
        tail = n;
    }

    private void halfCapacity() {
        assert size <= array.length / 2;
        int newCapacity = array.length >> 1;
        int n = size;
        Object[] a = new Object[newCapacity];
        if (head < tail) {
            System.arraycopy(array, head, a, 0, tail - head);
        } else {
            System.arraycopy(array, head, a, 0, array.length - head);
            System.arraycopy(array, 0, a, array.length - head, tail);
        }
        array = (Item[]) a;
        head = 0;
        tail = size;
    }

    public void addFirst(Item item) {
        array[head = (head - 1) & (array.length - 1)] = item;
        size += 1;
        if (head == tail) {
            doubleCapacity();
        }
    }

    public void addLast(Item item) {
        array[tail] = item;
        size += 1;
        if ((tail = (tail + 1) & (array.length - 1)) == head) {
            doubleCapacity();
        }
    }

    public Item removeLast() {
        int t = (tail - 1) & (array.length - 1);
        Item item = array[t];
        if (item == null) {
            return null;
        }
        array[t] = null;
        size -= 1;
        tail = t;
        if (size <= array.length /2 && array.length > 4) {
            halfCapacity();
        }
        return item;
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        String res = "";
        int p = head;
        while (p != tail) {
            res += array[p].toString() + " ";
            p = (p + 1) & (array.length - 1);
        }
        System.out.println(res.substring(0, res.length() - 1));
    }

    public Item get(int index) {
        return array[(head + index) & (array.length - 1)];
    }

}
