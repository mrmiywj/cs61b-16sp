/**
 * Created by ivan on 4/2/17.
 */
public class Palindrome {
    public static Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> ret = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); ++i) {
            ret.addLast(word.charAt(i));
        }
        return ret;
    }

    public static boolean isPalindrome(String word){
        Deque<Character> q = wordToDeque(word);
        for (int i =0; i < q.size() / 2; ++i) {
            if (!q.get(i).equals(q.get(q.get(q.size() - i - 1)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> q = wordToDeque(word);
        for (int i =0; i < q.size() / 2; ++i) {
            if (!cc.equalChars(q.get(i), q.get(q.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
