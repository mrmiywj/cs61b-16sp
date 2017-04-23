import java.util.LinkedList;
import java.util.Observable;
/**
 *  @author Josh Hug
 */

public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    LinkedList<Integer> queue;
    int s;
    int t;
    private boolean targetFound = false;
    Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        queue = new LinkedList<Integer>();
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Conducts a breadth first search of the maze starting at vertex x. */
    private void bfs(int s) {
        /* Your code here. */
        marked[s] = true;
        queue.addLast(s);

        announce();

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            if (now == t) {
                return;
            }
            for (int w: maze.adj(now)) {
                if (!marked[w]) {
                    marked[w] = true;
                    queue.addLast(w);

                    distTo[w] = distTo[now] + 1;
                    announce();
                    edgeTo[w] = now;
                }
            }
        }

    }


    @Override
    public void solve() {
         bfs(s);
    }
}

