package com.icolak.phoneBookSinglyLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PhonebookLinkedList {
    public PhoneBookNode head;
    public PhoneBookNode tail;
    public int size;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void printPhoneBook() {
        PhoneBookNode current = head;
        int element = 1;
        while (current != null) {
            System.out.println(element + ". " + current.contact);
            current = current.next;
            element++;
        }
    }

    public void add(Contact contact) {
        PhoneBookNode newNode = new PhoneBookNode(contact);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public List<PhoneBookNode> findAll() {
        if (isEmpty())
            throw new NoSuchElementException("No record is available in phone book");
        List<PhoneBookNode> list = new ArrayList<>();
        PhoneBookNode current = head;

        while (current != null) {
            list.add(current);
            current = current.next;
        }
        return list;
    }

    public PhoneBookNode findByFirstName(String firstName) {
        if (isEmpty())
            throw new NoSuchElementException("No record is available in phone book");

        PhoneBookNode current = head;
        while (current != null) {
            if (current.contact.firstName.equals(firstName)) {
                return current;
            }
            current = current.next;
        }
        throw new NoSuchElementException("This first name " + firstName + " could not match with any records");
    }

    public List<PhoneBookNode> findAllByLastName(String lastName) {
        if (isEmpty())
            throw new NoSuchElementException("No record is available in phone book");

        List<PhoneBookNode> list = new ArrayList<>();
        PhoneBookNode current = head;
        while (current != null) {
            if (current.contact.lastName.equals(lastName)) {
                list.add(current);
            }
            current = current.next;
        }
        if (list.isEmpty())
            throw new NoSuchElementException("This last name " + lastName + " could not match with any records");

        return list;
    }

    public void deleteFirstNode() {
        if (head == null)
            return;
        else {
            if (head == tail) {
                head = null;
                tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }
    }

    public void deleteLastNode() {
        if (tail == null)
            return;
        else {
            if (head == tail) {
                head = null;
                tail = null;
                size = 0;
            } else {
                PhoneBookNode previousToTail = head;
                while (previousToTail.next != tail) {
                    previousToTail = previousToTail.next;
                }
                tail = previousToTail;
                tail.next = null;
                size--;
            }
        }
    }

    public void deleteByFirstName(String firstName) {

        // check if empty
        if(isEmpty()) System.out.println("List is empty!!!");

        // assign prev and current with the head
        PhoneBookNode current = head;
        PhoneBookNode prevToCurrent = head;

        while (current != null) {
            if (current.contact.firstName.equals(firstName)) { // there is a match

                // case 1: head
                if (current == head) {
                    head = current.next;
                    current.next = null;
                }

                // case 2: tail
                else if (current == tail) {
                    tail = prevToCurrent;
                    tail.next = null; // Ex -Tail will be eligible for Garbage Collection
                }

                // case 3: middle
                else {
                    prevToCurrent.next = current.next;
                    current.next = null; // Current will be eligible for Garbage Collection
                }
                // after deletion
                size --;
            }
            // move forward on the elements of the list
            prevToCurrent = current;
            current = current.next;
        }
    }


}


