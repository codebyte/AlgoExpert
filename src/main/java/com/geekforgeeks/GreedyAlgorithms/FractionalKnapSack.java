package com.geekforgeeks.GreedyAlgorithms;

import java.util.*;

class WPair {
    int weights;
    int values;
    Double valuePerWeight;

    WPair(int weights, int values) {
        this.weights = weights;
        this.values = values;
        this.valuePerWeight = new Double(values / weights);
    }

    @Override
    public String toString() {
        return "WPair{" +
                "weights=" + weights +
                ", values=" + values +
                ", valuePerWeight=" + valuePerWeight +
                '}';
    }

}


public class FractionalKnapSack {

    public static int fractionalKnapSack(List<WPair> pList, int knapSackSize) {
        int value = 0;
        int currSize = knapSackSize;

        Collections.sort(pList, new Comparator<WPair>() {
            @Override
            public int compare(WPair o1, WPair o2) {
                return (int) (o2.valuePerWeight - o1.valuePerWeight);
            }
        });

        ListIterator<WPair> iter = pList.listIterator();

        while (iter.hasNext()) {
            WPair pair = iter.next();
            if (pair.weights < currSize) {
                currSize -= pair.weights;
                value += pair.values;
            } else {
                value += (currSize * pair.valuePerWeight);
                currSize = 0;
            }
        }

        if (currSize != 0) {
            System.out.println("Not enough weights ");
        }
        return value;
    }


    public static void main(String args[]) {

        List<WPair> pList = new ArrayList<>();
        pList.add(new WPair(10, 200));
        pList.add(new WPair(5, 50));
        pList.add(new WPair(20, 100));


        System.out.println(fractionalKnapSack(pList, 15));
    }
}
