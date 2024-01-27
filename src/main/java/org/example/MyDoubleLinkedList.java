package org.example;

class MyDoubleLinkedList<T> {
    class Node {
        T data;
        Node prev;
        Node next;
        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    MyDoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Добавление в голову списка
    public void addToHead(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Добавление в хвост списка
    public void addToTail(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Добавление по индексу
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Индекс за пределами списка");
        }
        if (index == 0) {
            addToHead(data);
        } else if (index == size()) {
            addToTail(data);
        } else {
            Node newNode = new Node(data);
            Node curr = getNodeAtIndex(index);
            newNode.next = curr;
            newNode.prev = curr.prev;
            curr.prev.next = newNode;
            curr.prev = newNode;
        }
    }

    // Удаление из головы списка
    public T removeFromHead() {
        if (head == null) {
            throw new IllegalStateException("Список пуст");
        }
        Node temp = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        return temp.data;
    }

    // Удаление из хвоста списка
    public T removeFromTail() {
        if (tail == null) {
            throw new IllegalStateException("Список пуст");
        }
        Node temp = tail;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        return temp.data;
    }

    // Удаление по индексу
    public T removeAtIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Индекс за пределами списка");
        }
        if (index == 0) {
            return removeFromHead();
        } else if (index == size() - 1) {
            return removeFromTail();
        } else {
            Node curr = getNodeAtIndex(index);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            return curr.data;
        }
    }

    // Разворот списка
    public void reverse() {
        Node temp = null;
        Node curr = head;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Получение узла по индексу
    private Node getNodeAtIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Индекс за пределами списка");
        }
        Node curr;
        if (index <= size() / 2) {
            curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size() - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        return curr;
    }

    // Вывод списка
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Получение размера списка
    public int size() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

}