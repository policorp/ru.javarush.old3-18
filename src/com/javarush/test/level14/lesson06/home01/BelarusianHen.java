package com.javarush.test.level14.lesson06.home01;

/**
 * Created by mihanya on 13.07.2014.
 */
public class BelarusianHen extends Hen
{
    public String country = Country.BELARUS;

    @Override
    public int getCountOfEggsPerMonth()
    {
        return 30;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + country + ". Я несу " +
                getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
