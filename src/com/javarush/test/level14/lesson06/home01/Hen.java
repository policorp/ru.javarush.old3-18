package com.javarush.test.level14.lesson06.home01;

/**
 * Created by mihanya on 13.07.2014.
 */
public abstract class Hen implements Country
{
    public abstract int getCountOfEggsPerMonth();

    public String getDescription() {
        return "Я курица.";
    }
}
