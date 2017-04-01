/**
 * Created by ivan on 3/29/17.
 */
public interface Deque<Item> {
    void addFirst(Item a);
    void addLast(Item a);
    boolean isEmpty();
    int size();
    void printDeque();
    Item removeFirst();
    Item removeLast();
    Item get(int index);
}

