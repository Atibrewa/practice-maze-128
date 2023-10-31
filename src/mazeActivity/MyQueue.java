package mazeActivity;

import java.util.*;

/**
 * An implementation of the Queue data structure.
 *
 *
 */

public class MyQueue<T> implements QueueADT<T> {

    class Node {
        T data;
        Node next;

        public Node() {
        }

        public Node(T item) {
            this.data = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    private Node head;
    private Node tail;
    private int size = 0;

    public MyQueue() {
        head = new Node();
        tail = head;
    }

    public void enqueue(T item) { // The Queue's add method
        Node q = new Node(item);
        tail.setNext(q);
        tail = q;
        this.size++;
    }

    @Override
    public T dequeue() throws NoSuchElementException { // The Queue's remove method
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            T item = (head.next).data;
            if (head.next == tail) {
                tail = head;
            }
            head.next = (head.next).next;
            this.size--;
            return item;
        }
    }

    @Override
    public T front() throws NoSuchElementException { // The Queue's get method
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return (head.next).data;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (head == tail);
    }

    public String toString() {
        String s = "";
        if (isEmpty()) {
            s = "[]";
        } else {
            Node n = head;
            while (n != tail) {
                n = n.next;
                s = s + "[" + n.data + "] ";
            }
        }
        return s;
    }

    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<Integer>();
        System.out.println(mq);
        System.out.println("mq.size == " + mq.size() );
        mq.enqueue(30);
        System.out.println(mq);
        System.out.println("mq.size == " + mq.size() );
        mq.enqueue(65);
        System.out.println(mq);
        System.out.println("mq.size == " + mq.size() );
        mq.enqueue(101);
        System.out.println(mq);
        System.out.println("mq.size == " + mq.size() );
        int x = mq.dequeue();
        System.out.println("The value dequeued was " + x);
        System.out.println(mq);
        System.out.println("mq.size == " + mq.size() );
        System.out.println("mq.front == " + mq.front() );
        mq.dequeue();
        System.out.println(mq);
        mq.dequeue();
        System.out.println(mq);
        try {
            System.out.println("mq.front == " + mq.front() );
        } catch (NoSuchElementException e) {
            System.out.println(e);
            System.out.println("The program successfully continued after the exception without crashing.");
        }
        try {
            mq.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println(e);
            System.out.println("The program successfully continued after the exception without crashing again.");
        }
    }

}











