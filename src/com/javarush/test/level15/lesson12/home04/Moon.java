package com.javarush.test.level15.lesson12.home04;

/**
 * Created by mihanya on 18.07.2014.
 */
public class Moon implements Planet
{
    private static Moon earth = null;

    private Moon() {

    }

    public static Moon getInstance() {
        if (earth == null)
            earth = new Moon();
        return earth;
    }
}
