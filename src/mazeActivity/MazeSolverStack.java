package mazeActivity;

/**
 * The Stack version of the maze solver algorithm.
 *
 *
 */

public class MazeSolverStack extends MazeSolver {

    private MyStack<Square> worklist;

    public MazeSolverStack(Maze maze) {
        super(maze);
    }

    @Override
    public void makeEmpty() {
        worklist = new MyStack<Square>();
    }

    @Override
    public boolean isEmpty() {
        return worklist.isEmpty();
    }

    @Override
    public void add(Square sq) {
        worklist.push(sq);
    }

    @Override
    public Square next() {
        return worklist.pop();
    }

}
