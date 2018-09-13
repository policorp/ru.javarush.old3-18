package com.javarush.test.level14.lesson06.home01;

/**
 * Created by mihanya on 13.07.2014.
 */
public class RussianHen extends Hen
{
    public String country = Country.RUSSIA;

    @Override
    public int getCountOfEggsPerMonth()
    {
        return 43;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + country + ". Я несу " +
                getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
