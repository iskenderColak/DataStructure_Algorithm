package com.icolak.deleteNNodesAfterMNodesLinkedList;

public class LinkedList {

    static class Node {
        int data;
        Node next;
    }

    static Node add(Node head, int newData) {
        Node newNode = new Node();
        newNode.data = newData;
        newNode.next = head;
        head = newNode;
        return head;
    }

    static void printNodes(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }

    static Node afterMDeleteN(Node head, int m, int n) {
        Node current = head;

        while (current!=null) {
            // leave m nodes
            for (int i = 1; i < m && current != null; i++){
                current = current.next;
            }

            // If there is no element left
            if (current == null) {
                return head;
            }
            // Start from next node and delete n nodes
            Node t = current.next;
            for (int i = 1; i <= n && t != null; i++) {
                t = t.next;
            }

            // Link the previous list with remaining nodes
            current.next = t;

            // Set current pointer for next iteration
            current = t;
        }
        return head;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        while(head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head1 = null;
        Node head2 = null;

        // Creating linked list and adding elements
        for (int i = 13; i > 0; i--) {
            head1 = add(head1,i);
        }

        for (int i = 11; i > 0; i--) {
            head2 = add(head2,i);
        }

        System.out.println("***********Head1***********");
        printNodes(head1);
        System.out.println("\nAfter deletion: ");
        printNodes(afterMDeleteN(head1,2,3));

        System.out.println("\n***********Head2***********");
        printNodes(head2);
        System.out.println("\nAfter deletion: ");
        printNodes(afterMDeleteN(head2,1,3));

    }
}
