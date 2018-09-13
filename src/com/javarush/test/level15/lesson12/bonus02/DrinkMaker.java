package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by mihanya on 30.07.2014.
 */
public abstract class DrinkMaker
{
    public abstract void getRightCup();
    public abstract void putIngredient();
    public abstract void pour();

    public void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
