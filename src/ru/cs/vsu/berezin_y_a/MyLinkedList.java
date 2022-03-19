package ru.cs.vsu.berezin_y_a;

public class MyLinkedList<T> {

    private MyLinkedListNode first = null;
    private MyLinkedListNode last = null;
    private int size;

    private class MyLinkedListNode {

        public T value;
        public MyLinkedListNode next;
        public MyLinkedListNode previous;

        public MyLinkedListNode(T value, MyLinkedListNode next, MyLinkedListNode previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public MyLinkedListNode(T value) {
            this(value, null, null);
        }

    }

    private void checkEmptyError() throws Exception {
        if (size == 0) {
            throw new IllegalStateException("Empty list");
        }
    }

    // TODO: 19.03.2022 add(value, index) method
    public void add() {

    }

    public void addFirst(T value) {
        first = new MyLinkedListNode(value, first, null);

        if (size == 0) {
            last = first;
        }

        size++;
    }

    public void addLast(T value) {

        if (size == 0) {
            first = last = new MyLinkedListNode(value);
        } else {
            MyLinkedListNode tmp = last;
            last.next = new MyLinkedListNode(value);
            last = last.next;
            last.previous = tmp;
        }

        size++;
    }

    public void addNext(T value, int index) throws Exception {
        checkEmptyError();

        if (index < 0 || index >= size) {
            throw new IllegalStateException("Incorrect index");
        } else {
            MyLinkedListNode actualNode = getNode(index);
            MyLinkedListNode newNode = new MyLinkedListNode(value);

            if (actualNode.next != null) {
                newNode.next = actualNode.next;
                newNode.next.previous = newNode;
            }

            actualNode.next = newNode;
            newNode.previous = actualNode;

            if (actualNode == last) {
                last = newNode;
            }

            size++;
        }
    }

    public void addPrevious(T value, int index) throws Exception {
        checkEmptyError();

        if (index < 0 || index >= size) {
            throw new IllegalStateException("Incorrect index");
        } else {
            MyLinkedListNode actualNode = getNode(index);
            MyLinkedListNode newNode = new MyLinkedListNode(value);

            if (actualNode != first) {
                newNode.previous = actualNode.previous;
                newNode.previous.next = newNode;
            }

            actualNode.previous = newNode;
            newNode.next = actualNode;

            if (actualNode == first) {
                first = newNode;
            }

            size++;
        }
    }

    public void removeFirst() throws Exception {
        checkEmptyError();

        if (size == 1) {
            last = first = null;
        } else {
            first = first.next;
            first.previous = null;
        }

        size--;
    }

    public void removeLast() throws Exception {
        checkEmptyError();

        if (size == 1) {
            first = last = null;
        } else {
            last = last.previous;
            last.next = null;
        }

        size--;
    }

    public void remove(int index) throws Exception {
        checkEmptyError();

        if (index < 0 || index >= size) {
            throw new IllegalStateException("Incorrect index");
        } else if (index == 0) {
            removeFirst();
        } else {
            MyLinkedListNode actual = getNode(index);
            if (actual != first) {
                actual.previous.next = actual.next;
            }
            if (actual != last) {
                actual.next.previous = actual.previous;
            }
            size--;
        }
    } // TODO: 19.03.2022 move here: removeLast and removeFirst

    public MyLinkedListNode getNode(int index) {
        MyLinkedListNode current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public T get(int index) throws Exception {
        checkEmptyError();
        return getNode(index).value;
    }

    public T first() throws Exception {
        checkEmptyError();
        return first.value;
    }

    public T last() throws Exception {
        checkEmptyError();
        return last.value;
    }

    public int size() {
        return size;
    }

}
