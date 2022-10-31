package com.icolak;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsInQueue {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(10,20,30,40,50));
        int k = 3;
        System.out.println(reverseFirstKElements(queue, k));

    }

    private static Queue<Integer> reverseFirstKElements(Queue<Integer> queue, int k) {
        int size = queue.size();

        // create a stack
        Stack<Integer> stack = new Stack<>();

        // push first K elements into stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // add elements back into the queue
        while(!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // poll and add (size of queue - k) times
        for (int i = 0; i < (size - k); i++) {
            queue.add(queue.poll());
        }
        return queue;
    }
}
/*
Given an integer K and a queue of integers,
write code to reverse the order of the first K elements of the queue.
-Input: Q = [10, 20, 30, 40, 50], K = 3
-Output: Q = [30, 20, 10, 40, 50]
*/
