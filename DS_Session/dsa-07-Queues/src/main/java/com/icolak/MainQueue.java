package com.icolak;

public class MainQueue {

    public static void main(String[] args) {

        MyQueue<Integer> q = new MyQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        System.out.println("dequeue: " + q.dequeue());
        q.enqueue(3);
        q.enqueue(4);
        System.out.println("isEmpty: " + q.isEmpty());
        System.out.println("queue: ");
        q.printQueue();
        q.enqueue(5);
        System.out.println("dequeue: " + q.dequeue());
        q.enqueue(6);
        System.out.println("peek: " + q.peek());
        System.out.println("queue: ");
        q.printQueue();
    }
}
