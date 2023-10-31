/**
 * A class to represent a single square in a maze.
 *
 *
 */
package mazeActivity;

import java.awt.Point;

public class Square {

    private int contents;
    private Point coordinates;
    private Square previous;

    private boolean explored;
    private boolean onFinalPath;

    public static final int SPACE = 0;
    public static final int WALL = 1;
    public static final int START = 2;
    public static final int EXIT = 3;

    private boolean wasInFrontier;
    private boolean displayInFrontier;

    // Makes a Square with contents n with the specified coordinates
    public Square(int i, int j, int n) throws IllegalStateException {
        if (n >= 0 && n <= 3) {
            this.contents = n;
            this.coordinates = new Point(i,j);
            this.previous = null;
            this.wasInFrontier = false;
            this.displayInFrontier = false;
        } else {
            throw new IllegalStateException();
        }
    }

    // Returns the contents of the square
    public int getContents() {
        return this.contents;
    }

    // Sets the contents of the square
    public void setContents(int n) throws IllegalStateException {
        if (n >= 0 && n <= 3) {
            this.contents = n;
            //this.previous = null;
        } else {
            throw new IllegalStateException();
        }
    }

    public Point getCoordinates() {
        return this.coordinates;
    }

    public int getRow() {
        return coordinates.x;
    }

    public int getCol() {
        return coordinates.y;
    }

    public void setCoordinates(int i, int j) {
        this.coordinates = new Point(i,j);
    }

    public Square getPrevious() {
        return this.previous;
    }

    public void setPrevious(Square sq) {
        this.previous = sq;
    }

    /**
     * @return the explored
     */
    public boolean isExplored() {
        return explored;
    }

    /**
     * @param explored the explored to set
     */
    public void setExplored(boolean explored) {
        this.explored = explored;
    }

    /**
     * @return the onFinalPath
     */
    public boolean isOnFinalPath() {
        return onFinalPath;
    }

    /**
     * @param onFinalPath the onFinalPath to set
     */
    public void setOnFinalPath(boolean onFinalPath) {
        this.onFinalPath = onFinalPath;
    }


    public boolean wasInFrontier() {
        return wasInFrontier;
    }

    public void setInFrontier(boolean inFrontier) {
        this.wasInFrontier = inFrontier;
    }

    public void setDisplayInFrontier(boolean inFrontier) {
        this.displayInFrontier = inFrontier;
    }

    public boolean getDisplayInFrontier() {
        return this.displayInFrontier;
    }

    public String showCoordinates() {
        return "[" + this.coordinates.x + "," + this.coordinates.y + "]";
    }

    public String toString() {
        String s = "";
        if (this.contents == SPACE) {
            s = "_";
        }
        if (this.contents == WALL) {
            s = "#";
        }
        if (this.contents == START) {
            s = "S";
        }
        if (this.contents == EXIT) {
            s = "E";
        }
        if (this.previous != null) {
            s = "o";
        }
        if (this.explored) {
            s = ".";
        }
        if (this.onFinalPath) {
            s = "x";
        }
        return s;
    }

}
