package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by mihanya on 15.07.2014.
 */
public class Singleton
{
    private static Singleton obj = new Singleton();

    private Singleton()
    {
    }

    public static Singleton getInstance() {
        return obj;
    }
}
