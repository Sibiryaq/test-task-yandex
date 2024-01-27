package org.example;

class MyLinkedList<T> {
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    MyLinkedList() {
        this.head = null;
    }

    // Добавление в голову списка
    public void addToHead(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Добавление в хвост списка
    public void addToTail(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
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
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }

    // Удаление из головы списка
    public T removeFromHead() {
        if (head == null) {
            throw new IllegalStateException("Список пуст");
        }
        Node temp = head;
        head = head.next;
        return temp.data;
    }

    // Удаление из хвоста списка
    public T removeFromTail() {
        if (head == null) {
            throw new IllegalStateException("Список пуст");
        }
        if (head.next == null) {
            T data = head.data;
            head = null;
            return data;
        }
        Node prev = null;
        Node curr = head;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        T data = curr.data;
        prev.next = null;
        return data;
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
        }
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        Node temp = curr.next;
        T data = temp.data;
        curr.next = temp.next;
        return data;
    }

    // Разворот списка
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
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
