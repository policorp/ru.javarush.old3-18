package com.javarush.test.level15.lesson12.home04;

/**
 * Created by mihanya on 18.07.2014.
 */
public class Sun implements Planet
{
    private static Sun earth = null;

    private Sun() {

    }

    public static Sun getInstance() {
        if (earth == null)
            earth = new Sun();
        return earth;
    }
}
