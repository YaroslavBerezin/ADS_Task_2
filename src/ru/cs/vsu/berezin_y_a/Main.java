package ru.cs.vsu.berezin_y_a;

public class Main {

    public static void main(String[] args) throws Exception {

        MyLinkedList<Integer> list = new MyLinkedList<>();
        Logic logic = new Logic();

        list.addLast(2);
        list.addLast(3);
        list.addLast(6);
        list.addLast(6);
        list.addLast(5);
        list.addLast(1000);
        list.addLast(7);

        logic.changeList(list, 0);

        for (int i = 0; i < list.size(); i++) {
            System.out.print((i > 0 ? ", " : "") + list.get(i));
        }

    }

}
