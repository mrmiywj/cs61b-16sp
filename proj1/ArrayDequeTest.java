/**
 * Created by ivan on 2/21/17.
 */
public class ArrayDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);

    }

    public static void getTest() {
        System.out.println("Runing get/getRecursive test.");
        ArrayDeque<Integer> s = new ArrayDeque<Integer>();
        s.addFirst(10);
        s.addFirst(20);
        s.addFirst(30);
        boolean passed = (s.get(0) == 30);
        passed = (s.get(3) == null) && passed;
        printTestStatus(passed);
    }

    public static void resizeTest() {
        System.out.println("Running resizing test");
        ArrayDeque<Integer> s = new ArrayDeque<Integer>();
        s.addFirst(5);
        s.addLast(6);
        s.addLast(7);
        s.addFirst(4);
        s.addFirst(3);
        s.addFirst(2 );
        s.addFirst(1);
        s.addFirst(0);
        s.addLast(8);
        s.addLast(9);
        s.addLast(10);
        boolean passed = (s.get(0) == 0);
        passed = (s.get(5) == 5) && passed;
        passed = (s.get(10) == 10) && passed;
        passed = (s.removeFirst() == 0) && passed;
        passed = (s.removeLast() == 10) && passed;
        passed = (s.get(10) == null) && passed;
        printTestStatus(passed);
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        getTest();
        resizeTest();
    }
}