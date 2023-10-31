package mazeActivity;

import java.util.*;


/**
 * The abstract class containing the maze solver algorithm.
 *
 *
 *
 */


public abstract class MazeSolver {

    protected Maze maze;

    protected static final int space = 0;
    protected static final int wall = 1;
    protected static final int start = 2;
    protected static final int exit = 3;
    protected int stepCount = 0;
    protected Square finalSquare;

    public MazeSolver(Maze maze) {
        this.maze = maze;
        makeEmpty();
        this.add(maze.getStart());
    }

    public abstract void makeEmpty(); // creates an empty worklist (either a MyStack or MyQueue)

    public abstract boolean isEmpty(); // returns true if the worklist is empty

    public abstract void add(Square sq); // adds the given Square to the worklist

    public abstract Square next(); // returns the "next" item from the worklist

    // A non-abstract method that the application program can use to see if this algorithm has solved this maze.
    // That is, has it determined the path
    // to the exit or if there is no path.
    /**
     *
     * @return returns a boolean depending on whether or not the maze has been solved.
     */
    public boolean isSolved() {
        return (maze.getExit().isExplored());
    }

    /**
     * Runs one iteration of the algorithm
     * @return returns the current square being examined.
     */
    public Square step() {
        if (this.isEmpty()){
           return null; 
        }

        Square currentSq = this.next();

        if (currentSq.getContents() == 3){
            currentSq.setExplored(true);
            finalSquare = currentSq;
            return currentSq;
        }

        ArrayList<Square> currentSqNeighbors = maze.getNeighbors(currentSq);

        for (Square s : currentSqNeighbors){
            if (s.getContents() != 1 && !s.isExplored() && s.toString() != "o"){
                s.setPrevious(currentSq);
                this.add(s);
            }
        }
        
        currentSq.setExplored(true);

        return currentSq;
    }

    /**
     *
     * @return returns either a string of the solution path as a list of coordinates [i,j] from the start to the exit or a message indicating no such path exists
     */
    public String getPath() {
        Deque<Square> finalPath = new ArrayDeque<Square>();
        while (finalSquare.getPrevious() != null){
            finalPath.push(finalSquare);
            finalSquare = finalSquare.getPrevious();
        }

        return finalPath.toString(); //GOT CLOSE! Little more work to do to get the coordinates instead
    }
}





