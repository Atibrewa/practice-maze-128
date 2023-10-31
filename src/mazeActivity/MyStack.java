package mazeActivity;

import java.util.*;

/**
 * An array based implementation of the Stack data structure.
 *
 *
 */

public class MyStack<T> implements StackADT<T> {

    private ArrayList<T> data;

    public MyStack() {
        data = new ArrayList<T>();
    }

    public void push(T item) { // The Stack's add method
        data.add(item);
    }

    public T pop() throws NoSuchElementException { // The Stack's remove method
        if (data.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return data.remove(data.size()-1);
        }
    }

    public T top() throws NoSuchElementException { // The Stack's get method
        if (data.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return data.get(data.size()-1);
        }
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public String toString() {
        String s = "";
        if (isEmpty()) {
            s = "[]";
        } else {
            for (int i = data.size()-1; i >= 0; i--) {
                if (i == 0) { // If statement prevents a newline character from being added at the end
                    s = s + "[" + data.get(i) + "]";
                } else {
                    s = s + "[" + data.get(i) + "]" + "\n";
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        MyStack<Integer> ms = new MyStack<Integer>();
        System.out.println(ms);
        System.out.println("ms.size == " + ms.size() );
        ms.push(30);
        System.out.println(ms);
        System.out.println("ms.size == " + ms.size() );
        ms.push(65);
        System.out.println(ms);
        System.out.println("ms.size == " + ms.size() );
        ms.push(101);
        System.out.println(ms);
        System.out.println("ms.size == " + ms.size() );

        int x = ms.pop();
        System.out.println("The value popped was " + x);
        System.out.println(ms);
        System.out.println("ms.size == " + ms.size() );
        System.out.println("ms.top == " + ms.top() );
        ms.pop();
        System.out.println(ms);
        ms.pop();
        System.out.println(ms);
        try {
            System.out.println("ms.top == " + ms.top() );
        } catch (NoSuchElementException e) {
            System.out.println(e);
            System.out.println("The program successfully continued after the exception without crashing.");
        }
        try {
            ms.pop();
        } catch (NoSuchElementException e) {
            System.out.println(e);
            System.out.println("The program successfully continued after the exception without crashing again.");
        }
    }
}
