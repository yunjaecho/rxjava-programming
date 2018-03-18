package com.yunjae.rxjava.Session3;


import io.reactivex.Observable;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class QueryTvSales {
    public static void main(String[] args) {
        List<Pair<String, Integer>> sales = new ArrayList<>();

        sales.add(Pair.of("TV", 2500));
        sales.add(Pair.of("Camera", 300));
        sales.add(Pair.of("TV", 1600));
        sales.add(Pair.of("Phone", 860));

        Observable
                .fromIterable(sales)
                .filter(sale -> ("TV").equals(sale.getLeft()))
                .map(sale -> sale.getRight())
                .reduce((0), (x, y) -> x + y)
                .subscribe(sum -> System.out.println(" Total Price : " + sum));


    }
}
