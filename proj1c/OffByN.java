/**
 * Created by ivan on 4/2/17.
 */
public class OffByN implements CharacterComparator {
    private int offset;
    public OffByN(int N) {
        offset = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x - y == offset || y - x == -offset;
    }
}
