package com.icolak.phoneBookSinglyLinkedList;

import java.sql.SQLOutput;

public class PhoneBookApp {

    public static void main(String[] args) {

        PhonebookLinkedList myPhoneBook = new PhonebookLinkedList();
        myPhoneBook.add(new Contact("Glenio", "Faria", "glenio.faria@gmail.com", "8787899"));
        myPhoneBook.add(new Contact("Ekaterina", "Sementeva", "ekaterina.sementeva@gmail.com", "435454345"));
        myPhoneBook.add(new Contact("Yuliia", "Karnoza", "yulia.karnoza@gmail.com", "879898789"));
        myPhoneBook.add(new Contact("Sumeye", "Dalkilinc", "dalkilincsumeye@gmail.com", "745637456"));
        myPhoneBook.add(new Contact("Sebastian", "Early", "sebas4idua@gmail.com", "9898989989"));
        myPhoneBook.add(new Contact("Yusuf", "Abakli", "abakliyusufziya@gmail.com", "8776554343"));
        myPhoneBook.add(new Contact("Iskender", "Colak", "iclk84@gmail.com", "12345689"));
        myPhoneBook.add(new Contact("Mehmet", "Ozbekler", "mehmetozbekler@gmail.com", "908734321"));
        myPhoneBook.add(new Contact("Mehmet", "Hero", "mehmet@hero.com", "54869987"));
        myPhoneBook.add(new Contact("Mehmet", "TheTeacher", "mehmet@theteacher.com", "46566765"));
        myPhoneBook.add(new Contact("Yusuf", "Hero", "yusuf@hero.com", "9088787675"));


        System.out.println(myPhoneBook.isEmpty());
        System.out.println(myPhoneBook.size());
        System.out.println("********************************");
        myPhoneBook.printPhoneBook();
        System.out.println("********************************");
        System.out.println(myPhoneBook.findAll());
        System.out.println("********************************");
        System.out.println(myPhoneBook.findByFirstName("Iskender").contact);
        System.out.println("********************************");
        System.out.println(myPhoneBook.findAllByLastName("Colak"));
        System.out.println("********************************");
        myPhoneBook.deleteFirstNode();
        myPhoneBook.deleteLastNode();
        System.out.println("********************************");
        myPhoneBook.printPhoneBook();
        System.out.println(myPhoneBook.size());

    }

}
/*
    myPhoneBook.add(new Contact("Glenio", "Faria", "glenio.faria@gmail.com", "8787899"));
    myPhoneBook.add(new Contact("Ekaterina", "Sementeva", "ekaterina.sementeva@gmail.com", "435454345"));
    myPhoneBook.add(new Contact("Yuliia", "Karnoza", "yulia.karnoza@gmail.com", "879898789"));
    myPhoneBook.add(new Contact("Sumeye", "Dalkilinc", "dalkilincsumeye@gmail.com", "745637456"));
    myPhoneBook.add(new Contact("Sebastian", "Early", "sebas4idua@gmail.com", "9898989989"));
    myPhoneBook.add(new Contact("Yusuf", "Abakli", "abakliyusufziya@gmail.com", "8776554343"));
    myPhoneBook.add(new Contact("Iskender", "Colak", "iclk84@gmail.com", "12345689"));
    myPhoneBook.add(new Contact("Mehmet", "Ozbekler", "mehmetozbekler@gmail.com", "908734321"));
    myPhoneBook.add(new Contact("Mehmet", "Hero", "mehmet@hero.com", "54869987"));
    myPhoneBook.add(new Contact("Mehmet", "TheTeacher", "mehmet@theteacher.com", "46566765"));
    myPhoneBook.add(new Contact("Yusuf", "Hero", "yusuf@hero.com", "9088787675"));
*/
