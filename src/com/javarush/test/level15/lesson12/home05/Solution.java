package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    Solution () {}
    Solution (int a) {}
    Solution (float a) {}

    protected Solution (double a) {}
    protected Solution (short a) {}
    protected Solution (int a, int b) {}

    public Solution (int a, double b) {}
    public Solution (int a, short b) {}
    public Solution (short a, int b) {}

    private Solution (String x) {}
    private Solution (String x, int a) {}
    private Solution (long a) {}

}

