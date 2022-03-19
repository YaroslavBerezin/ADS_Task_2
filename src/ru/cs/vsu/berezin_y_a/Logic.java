package ru.cs.vsu.berezin_y_a;

public class Logic {

    public <T> void changeList(MyLinkedList<T> list, T value) throws Exception {
        for (int i = 0; i < list.getSize(); i++) {
            if (checkSimple((Integer) list.get(i))) {
                list.addNext(value, i);
                list.addPrevious(value, i);
                i += 2;
            }
        }
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
