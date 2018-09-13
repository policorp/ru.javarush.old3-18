package com.javarush.test.level17.lesson10.bonus02;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        synchronized (allPeople) {
            char command = args[0].charAt(1);
            int length = args.length;

            //create -c name1 sex1 bd1 name2 sex2 bd2 ...
            if (command == 'c') {
                int groupCounter = ((length - 1) / 3);
                String name = null;
                char sex = '\0';
                SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date birthDate = null;

                for (int i = 0; i < groupCounter; i++) {
                    name = args[1 + 3*i];
                    sex = args[2 + 3*i].charAt(0);
                    birthDate = formater.parse(args[3 + 3*i]);

                    if (sex == 'м') {
                        allPeople.add(Person.createMale(name, birthDate));
                    } else {
                        allPeople.add(Person.createFemale(name, birthDate));
                    }
                    System.out.println(allPeople.size() - 1);
                }
            }

            //update -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
            if (command == 'u') {
                int groupCounter = ((length - 1) / 4);
                int id = 0;
                String name = null;
                char sex = '\0';
                SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date birthDate = null;
                Person someP = null;

                for (int i = 0; i < groupCounter; i++) {
                    id = Integer.parseInt(args[1 + 4*i]);
                    name = args[2 + 4*i];
                    sex = args[3 + 4*i].charAt(0);
                    birthDate = formater.parse(args[4 + 4*i]);

                    if (sex == 'м') {
                        someP = Person.createMale(name, birthDate);
                    } else {
                        someP = Person.createFemale(name, birthDate);
                    }
                    allPeople.add(id, someP);
                    allPeople.remove(id + 1);
                }
            }

            //delete -d id1 id2 id3 id4 ...
            if (command == 'd') {
                int groupCounter = (length - 1);
                int id = 0;
                Person someP = Person.createFemale("", new Date(0, 0, 0));

                for (int i = 0; i < groupCounter; i++) {
                    id = Integer.parseInt(args[1 + 1*i]);
                    allPeople.add(id, someP);
                    allPeople.remove(id + 1);
                }
            }

            //info -i id1 id2 id3 id4 ...
            if (command == 'i') {
                int groupCounter = (length - 1);
                int id = 0;
                Person someP = null;
                SimpleDateFormat formater = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

                for (int i = 0; i < groupCounter; i++) {
                    id = Integer.parseInt(args[1 + 1*i]);
                    someP = allPeople.get(id);
                    System.out.print(someP.getName() + " ");
                    if (someP.getSex() == Sex.MALE)
                        System.out.print("м" + " ");
                    else
                        System.out.print("ж" + " ");
                    System.out.println(formater.format(someP.getBirthDay()));
                }
            }


            //print all for check
            //printAll();
        }
    }

//    public static void printAll() {
//        for (Person x: allPeople) {
//            System.out.print(x.getName() + " ");
//            if (x.getSex() == Sex.MALE)
//                System.out.print("м" + " ");
//            else
//                System.out.print("ж" + " ");
//            SimpleDateFormat formatDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//            System.out.println(formatDate.format(x.getBirthDay()));
//        }
//    }
}
