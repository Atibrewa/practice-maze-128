package mazeActivity;

import java.util.NoSuchElementException;

/**
 * An interface that describes a stack abstract data type
 *
 */


public interface StackADT<T> {
    /**
     * Add an item onto the stack
     * @param item the data item to add (of type T)
     */
    void push(T item);

    /**
     * Remove the top item from the stack
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    T pop() throws NoSuchElementException;

    /**
     * Display the top item from the stack without removing it
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    T top() throws NoSuchElementException;

    /**
     * Find how many items are in the stack
     * @return the number of items in the stack
     */
    int size();

    /**
     * Determine if the stack is empty
     * @return true if the size is 0, false otherwise
     */
    boolean isEmpty();

    /**
     * Clear out the data structure
     */
   // void clear();

}
