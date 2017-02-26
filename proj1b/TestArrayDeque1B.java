/**
 * Created by ivan on 2/27/17.
 */
import org.junit.Test;
import static org.junit.Assert.*;
public class TestArrayDeque1B {
    @Test
    public void TestAddRemove() {
        StudentArrayDeque<Integer> s = new StudentArrayDeque<Integer>();
        s.addLast(10);
        s.addFirst(20);
        s.addLast(30);
        int getfirst = s.removeFirst();
        assertEquals(getfirst, 20);
        int getlast = s.removeLast();
        assertEquals(getlast, 30);
        getlast = s.removeLast();
        assertEquals(getlast, 10);
    }

    @Test
    public void TestSize() {
        StudentArrayDeque<Integer> s = new StudentArrayDeque<Integer>();
        s.addLast(10);
        s.addFirst(20);
        s.addLast(10);
        s.addFirst(20);
        s.addLast(10);
        s.addFirst(20);
        s.addLast(10);
        s.addFirst(20);
        s.addLast(10);
        s.addFirst(20);
        s.addLast(10);
        s.addFirst(20);
        s.addLast(10);
        s.addFirst(20);
        s.addLast(10);
        s.addFirst(20);
        int size = s.size();
        assertEquals(size, 16);
    }

    @Test
    public void TestGet() {
        StudentArrayDeque<Integer> s = new StudentArrayDeque<Integer>();
        s.addFirst(5);
        s.addLast(6);
        s.addFirst(4);
        s.addLast(7);
        s.addFirst(3);
        s.addLast(8);
        s.addFirst(2);
        s.addLast(9);
        s.addFirst(1);
        s.addLast(10);
        s.addFirst(0);
        int get = s.get(0);
        assertEquals(get, 0);
        get = s.get(5);
        assertEquals(get, 5);
        get = s.get(10);
        assertEquals(get, 10);
    }

    @Test
    public void TestRemove() {
        StudentArrayDeque<Integer> s = new StudentArrayDeque<Integer>();
        s.addFirst(5);
        s.addLast(6);
        s.addFirst(4);
        s.addLast(7);
        s.addFirst(3);
        s.addLast(8);
        s.addFirst(2);
        s.addLast(9);
        s.addFirst(1);
        s.addLast(10);
        s.addFirst(0);
        int size = s.size();
        assertEquals(size, 11);
        int get = s.removeFirst();
        assertEquals(get, 0);
        get = s.removeLast();
        assertEquals(get, 10);
        get = s.removeFirst();
        assertEquals(get, 1);
        get = s.removeLast();
        assertEquals(get,  9 );
        get = s.removeFirst();
        assertEquals(get, 2);
        get = s.removeLast();
        assertEquals(get, 8 );
        get = s.removeFirst();
        assertEquals(get, 3);
        get = s.removeLast();
        assertEquals(get, 7);
        get = s.removeLast();
        assertEquals(get,6);
        get=  s.removeFirst();
        assertEquals(get, 4);
        get = s.removeFirst();
        assertEquals(get, 5);
        boolean isEmpty = s.isEmpty();
        assertTrue(isEmpty);
    }
}
