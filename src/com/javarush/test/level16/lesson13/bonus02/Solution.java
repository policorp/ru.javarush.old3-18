package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(0, new InfinityThread());
        threads.add(1, new WithExeptionThread());
        threads.add(2, new GoodMoodThread());
        threads.add(3, new MessageThread());
        threads.add(4, new ArithmeticThread());
    }

    public static void main(String[] args) throws InterruptedException{
        Thread current = threads.get(3);
        Message mess = (Message)current;
        current.start();
        Thread.sleep(500);
        mess.showWarning();
        //Thread.sleep(100);
        System.out.println(current.isAlive());

    }

    public static class InfinityThread extends Thread {
        @Override
        public void run()
        {
            while (true) {
                //
            }
        }
    }

    public static class WithExeptionThread extends Thread {
        @Override
        public void run()
        {
            try {
                throw new InterruptedException();
            }
            catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class GoodMoodThread extends Thread {
        @Override
        public void run()
        {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MessageThread extends Thread implements Message {
        private volatile boolean state = true;
        @Override
        public void showWarning()
        {
            state = false;
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run()
        {
            while (state) {
                //
            }
        }
    }

    public static class ArithmeticThread extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        @Override
        public void run()
        {
            String s = null;
            Integer amount = 0;
            try {
                while (!("N".equals(s = reader.readLine()))) {
                    amount += Integer.parseInt(s);
                }
                reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(amount);
        }
    }
}
