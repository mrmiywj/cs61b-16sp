import java.util.Observable;
/** 
 *  @author Josh Hug
 */

public class MazeCycles extends MazeExplorer {
    /* Inherits public fields: 
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */


    public MazeCycles(Maze m) {
        super(m);
        maze = m;
    }

    private boolean isCyclicUntil(int v, int parent) {
        marked[v] = true;
        edgeTo[v] = parent;
        for (int w: maze.adj(v)) {
            if (!marked[w]){
                if (isCyclicUntil(w, v)) {
                    return true;
                }
            } else if (w != parent) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void solve() {
        for (int i = 0; i < maze.V(); i++) {
            if (!marked[i])
                if (isCyclicUntil(i, -1))
                    return;
        }
    }
} 

