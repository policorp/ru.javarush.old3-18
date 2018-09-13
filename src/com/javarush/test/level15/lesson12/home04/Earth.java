package com.javarush.test.level15.lesson12.home04;

/**
 * Created by mihanya on 18.07.2014.
 */
public class Earth implements Planet
{
    private static Earth earth = null;

    private Earth() {

    }

    public static Earth getInstance() {
        if (earth == null)
            earth = new Earth();
        return earth;
    }
}
