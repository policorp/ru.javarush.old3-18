package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

import java.util.ArrayList;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

/*    static ArrayList<Beach> array = new ArrayList<Beach>();

    public static void main(String[] args) {
        System.out.println("Awesome task:");

        array.add(new Beach("beach1", 1.0f, 5));
        array.add(new Beach("beach1", 1.0f, 5));
        array.add(new Beach("beach", 2.0f, 6));
        array.add(new Beach("beach", 2.5f, 7));
        array.add(new Beach("beach", 1.1f, 2));
        array.add(new Beach("beach", 1.4f, 10));
        array.add(new Beach("beach", 1.7f, 1));
        array.add(new Beach("beach8", 1.8f, 2));
        array.add(new Beach("beach9", 1.9f, 3));
        array.add(new Beach("beach10", 10.0f, 8));

        //System.out.println("beach1".compareTo("beach"));
        System.out.println("Nachalo: ");
        printArray();
        System.out.println("Sorting...");
        sortArray();
        printArray();
        sortArray();
        printArray();
        sortArray();
        printArray();
        sortArray();
        printArray();
        sortArray();
        printArray();
        System.out.println("Sorted!");
    }*/

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o)
    {
        synchronized (o) {
            int q = quality - o.getQuality();
            int d = (int)(distance - o.getDistance());
            //10 * name.compareTo(o.getName()) +
            return (10 * d + 1000 * q);
        }
    }
/*
    @Override
    public String toString()
    {
        return "@" + name + " " + distance + "_" + quality + "   ";
    }

    public static void sortArray() {
        Beach b1 = null, b2 = null;
        for (int i = 0; i < array.size() - 1; i++)
            for (int j = i + 1; j < array.size(); j++) {
                b1 = array.get(i);
                b2 = array.get(j);
                if (b1.compareTo(b2) < 0) {
                    //Beach buf = b1;
                    array.add(i, b2);
                    array.remove(i + 1);
                    array.add(j, b1);
                    array.remove(j + 1);
                }
            }
    }

    public static void printArray() {
        for (Beach x: array) {
            System.out.print(x);
        }
        System.out.println();
    }*/
}
