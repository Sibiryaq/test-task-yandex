package org.example;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        MyDoubleLinkedList<String> doubleLinkedList = new MyDoubleLinkedList<>();

        linkedList.addToHead(3);
        linkedList.addToHead(2);
        linkedList.addToHead(1);

        linkedList.addToTail(4);
        linkedList.addToTail(5);

        linkedList.addAtIndex(2, 6);

        System.out.print("Текущий односвязный список: ");
        linkedList.printList();

        System.out.println("Имеет размер: " + linkedList.size());

        System.out.println("Удаляем с головы: " + linkedList.removeFromHead());
        System.out.print("Односвязный список после удаления из головы: ");
        linkedList.printList();

        System.out.println("Удаляем с хвоста: " + linkedList.removeFromTail());
        System.out.print("Односвязный список после удаления с хвоста: ");
        linkedList.printList();

        System.out.println("Удаляем по индексу [2]: " + linkedList.removeAtIndex(2));
        System.out.print("Односвязный список после удаления по индексу [2]: ");
        linkedList.printList();

        linkedList.reverse();
        System.out.print("И под конец разворачиваем односвязный список : ");
        linkedList.printList();
        System.out.println("\n");

        ////////////////////////////////////////////// Двусвязный список /////////////////////////////////////

        doubleLinkedList.addToHead("C");
        doubleLinkedList.addToHead("B");
        doubleLinkedList.addToHead("A");

        doubleLinkedList.addToTail("D");
        doubleLinkedList.addToTail("E");

        doubleLinkedList.addAtIndex(2, "F");

        System.out.print("Текущий двусвязный список: ");
        doubleLinkedList.printList();

        System.out.println("Имеет размер: " + doubleLinkedList.size());

        System.out.println("Удаляем с головы: " + doubleLinkedList.removeFromHead());
        System.out.print("Двусвязный список после удаления с головы: ");
        doubleLinkedList.printList();

        System.out.println("Удаляем с хвоста: " + doubleLinkedList.removeFromTail());
        System.out.print("Двусвязный список после удаления с хвоста: ");
        doubleLinkedList.printList();

        System.out.println("Удаляем по индексу [2]: " + doubleLinkedList.removeAtIndex(2));
        System.out.print("Двусвязный список после удаления по индексу [2]: ");
        doubleLinkedList.printList();

        doubleLinkedList.reverse();
        System.out.print("И под конец разворачиваем двусвязный список: ");
        doubleLinkedList.printList();
    }
}

