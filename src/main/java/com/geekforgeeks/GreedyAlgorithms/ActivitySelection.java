package com.geekforgeeks.GreedyAlgorithms;

import java.util.*;

class Pair {
    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

}


public class ActivitySelection {

    public static int activitySelection(List<Pair> pList) {
        int count = 0;

        Collections.sort(pList, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.b - o2.b;
            }
        });

        ListIterator<Pair> iter = pList.listIterator();

        Pair last = iter.next();
        while (iter.hasNext()) {
            Pair next = iter.next();
            if (next.a >= last.b) {
                count++;
                last = next;
            }
        }
        return count + 1;
    }


    public static void main(String args[]) {

        List<Pair> pList = new ArrayList<>();
        pList.add(new Pair(2, 3));
        pList.add(new Pair(1, 4));
        pList.add(new Pair(5, 8));
        pList.add(new Pair(6, 10));

        System.out.println(activitySelection(pList));
    }
}
