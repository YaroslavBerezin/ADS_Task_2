package ru.cs.vsu.berezin_y_a;

public class Logic {

    public MyLinkedList<Integer> changeList(MyLinkedList list) throws Exception {
        for (int i = 0; i < list.getSize(); i++) {
            if (checkSimple((Integer) list.get(i))) {
                list.addNext(0, i);
                list.addPrevious(0, i);
                i += 2;
            }
        }

        return list;
    }

    public boolean checkSimple(Integer number) {
        if (number < 2) {
            return false;
        }

        double numberRoot = Math.sqrt(number);

        for (int i = 2; i <= numberRoot; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
