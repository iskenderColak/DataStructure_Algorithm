package com.icolak.deleteNNodesAfterMNodesLinkedList;

public class DeleteNNodesAfterMNodes {

    public static void main(String[] args) {
        Node head= new Node(1);
        Node current= head;

        for (int i = 2; i < 14; i++) {
            current.next=new Node(i);
            current=current.next;
        }

        printNodes(head);
        deleteNAfterM(head,1,4);
        printNodes(head);
    }

    public static class Node {
        int id;
        Node next;

        public Node(int id) {
            this.id = id;
        }
    }

    static void printNodes(Node head){
        Node current=head;
        while(current!=null){
            if (current.next==null) System.out.println(current.id+"=> null");
            else {
                System.out.print(current.id+"=> ");
            }
            current=current.next;
        }
    }

    public static Node deleteNAfterM(Node head, int m, int n){

        Node current = head;
        while(current != null) {
            for (int i = 1; i < m && current != null; i++) {
                current = current.next;
            }

            if (current == null) return head;

            Node t = current.next;
            for (int i = 0; i < n && t != null; i++) {
                t = t.next;
            }
            current.next = t;
            current = t;
        }

        return head;
    }
}
