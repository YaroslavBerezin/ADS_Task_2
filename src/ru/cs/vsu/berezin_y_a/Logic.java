package ru.cs.vsu.berezin_y_a;

public class Logic {

    public MyLinkedList<Integer> changeList(MyLinkedList list) throws Exception {

        for (int i = 0; i < list.size(); i++) {
            if (checkSimple((Integer) list.get(i))) {
                list.addNext(0, i);
                list.addPrevious(0, i);
                i += 2;
            }
        }

        return list;
    }

    public boolean checkSimple(Integer num) {
        if (num < 2) {
            return false;
        }
        double s = Math.sqrt(num);
        for (int i = 2; i <= s; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
