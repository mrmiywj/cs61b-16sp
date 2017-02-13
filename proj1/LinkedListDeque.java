/**
 * Created by ivan on 2/9/17.
 */
public class LinkedListDeque<Item> {

    class Node {
        private Item val;
        private Node next, prev;
        public Node(Item i, Node n, Node p) {
            val = i;
            next = n;
            prev = p;
        }
        public Item getRecursive(int index, Node sentinel) {
            if (index < 0) {
                return null;
            }
            if (this == sentinel) {
                return null;
            }
            if (index == 0) {
                return this.val;
            } else {
                return this.next.getRecursive(index - 1, sentinel);
            }
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        Node node = sentinel.next;
        node.next.prev = sentinel;
        sentinel.next = node.next;
        size -= 1;
        return node.val;
    }

    public void addFirst(Item item) {
        Node res = new Node(item, sentinel.next,sentinel);
        sentinel.next.prev = res;
        sentinel.next = res;
        size += 1;
    }

    public void addLast(Item item) {
        Node res = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.next = res;
        sentinel.prev = res;
        size += 1;
    }

    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        Node node = sentinel.prev;
        node.prev.next = sentinel;
        sentinel.prev = node.prev;
        size -= 1;
        return node.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        String res = "";
        Node node = sentinel.next;
        while (node != sentinel) {
            res += node.val.toString();
            node = node.next;
        }
        System.out.println(res.substring(0,res.length()-1));
    }

    public Item get(int index) {
        Node node = sentinel.next;
        if (index < 0) {
            return null;
        }
        while (index > 0 && node != sentinel) {
            node = node.next;
            index -= 1;
        }
        if (node == sentinel) {
            return null;
        }
        if (index == 0) {
            return node.val;
        } else {
            return null;
        }
    }

    public Item getRecursive(int index) {
        return sentinel.next.getRecursive(index, sentinel);
    }
}
