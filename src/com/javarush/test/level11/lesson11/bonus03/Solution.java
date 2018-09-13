package com.javarush.test.level11.lesson11.bonus03;

/* Задача по алгоритмам
Написать метод, который возвращает минимальное и максимальное числа в массиве.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return new Pair<Integer, Integer>(null, null);
        }

        Pair<Integer, Integer> pair = new Pair<Integer, Integer>(array[0], array[0]);
        for (int i = 1; i < array.length; i++) {
            if (pair.x > array[i])
                pair.x = array[i];
            if (pair.y < array[i])
                pair.y = array[i];
        }
        return pair;
    }


    public static class Pair<X, Y>
    {
        public X x; //min
        public Y y; //max

        public Pair(X x, Y y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
