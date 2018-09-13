package com.javarush.test.level13.lesson11.bonus03;

public abstract class AbstractRobot implements Attackable, Defensable
{
    private String name;

    public AbstractRobot(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public abstract BodyPart attack();

    @Override
    public abstract BodyPart defense();


}
