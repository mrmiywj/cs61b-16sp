/**
 * Created by ivan on 4/2/17.
 */
public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        return x - y == 1 || y - x == 1;
    }
}
