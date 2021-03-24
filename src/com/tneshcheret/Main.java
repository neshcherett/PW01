package com.tneshcheret;

public class Main {

    public static void main(String[] args) {
        TimeSpan first = new TimeSpan(1, 20);
        TimeSpan second = new TimeSpan(5, 30);
        TimeSpan third = new TimeSpan(2, 50);

        first.add(second);
        System.out.println(first);
        second.sub(third);
        System.out.println(second);
        first.sub(third);
        System.out.println(first);
        first.mult(0.4);
        System.out.println(first);
    }
}
