package mazeActivity;

import java.util.*;
import java.io.*;

/**
 * A class to represent a maze.
 *
 * @author Joey Gonzales-Dones (3/05/2013)
 *
 */

public class Maze {

    private static final int space = 0;
    private static final int wall = 1;
    private static final int start = 2;
    private static final int exit = 3;

    public Square[][] mazeArray;

    public Maze() {

    }

    public Maze(String fname) {
        this.loadMaze(fname);
    }

    public Maze(Square[][] mazeArray) {
        this.mazeArray = mazeArray;
    }

    public Square[][] getMazeArray() {
        return this.mazeArray;
    }

    public boolean loadMaze(String fname) {
        try {
            File inputFile = new File(fname);
            Scanner input = new Scanner(inputFile);
            int R = input.nextInt(); // gets the number of rows
            int C = input.nextInt(); // gets the number of columns

            this.mazeArray = new Square[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    int n = input.nextInt();
                    this.mazeArray[i][j] = new Square(i,j,n);
                }
            }

        } catch ( FileNotFoundException e ) {
            System.out.println("The file \"" + fname + "\" does not exist.");
            return false;
        }
        return true;
    }

    public ArrayList<Square> getNeighbors(Square sq) {
        int row = sq.getRow();
        int col = sq.getCol();
        ArrayList<Square> neighbors = new ArrayList<Square>();
        if (row-1 >= 0) {
            neighbors.add(mazeArray[row-1][col]); // North
        }
        if (col+1 < mazeArray[0].length) {
            neighbors.add(mazeArray[row][col+1]); // East
        }
        if (row+1 < mazeArray.length) {
            neighbors.add(mazeArray[row+1][col]); // South
        }
        if (col-1 >= 0) {
            neighbors.add(mazeArray[row][col-1]); // West
        }
        return neighbors;
    }

    public int getWidth() { // number of columns
        return mazeArray[0].length;
    }

    public int getHeight() { // number of rows
        return mazeArray.length;
    }

    public Square getStart() {
        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray[0].length; j++) {
                if (mazeArray[i][j].getContents() == start) {
                    return mazeArray[i][j];
                }
            }
        }
        return null;
    }

    public Square getExit() {
        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray[0].length; j++) {
                if (mazeArray[i][j].getContents() == exit) {
                    return mazeArray[i][j];
                }
            }
        }
        return null;
    }

    public String toString() { // Used for top window in GUI
        String s = "";
        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray[0].length; j++) {
                s = s + (mazeArray[i][j]) + " ";
            }
            s = s + '\n';
        }
        return s;
    }

    public void reset() {
        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray[0].length; j++) {
                mazeArray[i][j].setPrevious(null);
                mazeArray[i][j].setExplored(false);
                mazeArray[i][j].setOnFinalPath(false);
            }
        }
    }

    public static void main(String[] args) {
        Maze m = new Maze("maze-2");
        System.out.println(m);
        System.out.println();
    }

}
