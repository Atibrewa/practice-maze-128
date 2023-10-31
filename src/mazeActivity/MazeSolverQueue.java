package mazeActivity;

/**
 * The Queue version of the maze solver algorithm.
 *
 *
 */

public class MazeSolverQueue extends MazeSolver {

    private MyQueue<Square> worklist;

    public MazeSolverQueue(Maze maze) {
        super(maze);
    }

    @Override
    public void makeEmpty() {
        worklist = new MyQueue<Square>();
    }

    @Override
    public boolean isEmpty() {
        return worklist.isEmpty();
    }

    @Override
    public void add(Square sq) {
        worklist.enqueue(sq);
    }

    @Override
    public Square next() {
        return worklist.dequeue();
    }

}