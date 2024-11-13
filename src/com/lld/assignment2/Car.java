package com.lld.assignment2;

public class Car implements Comparable<Car>{

    int price;
    int speed;

    @Override
    public int compareTo(Car o) {
        return this.price - o.price;
    }
}
