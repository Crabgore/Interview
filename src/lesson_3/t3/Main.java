package lesson_3.t3;

import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> mll= new MyLinkedList<>();

        mll.insertFirst("Katia");
        mll.insertFirst("Maria");
        mll.insertFirst("Sania");
        mll.insertFirst("Petia");
        mll.insertFirst("Fedia");

        System.out.println(mll);

        ListIterator<String> listIterator = mll.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
