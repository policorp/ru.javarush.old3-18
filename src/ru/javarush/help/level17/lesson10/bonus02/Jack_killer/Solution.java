package ru.javarush.help.level17.lesson10.bonus02.Jack_killer;

/**
 * Created by mihanya on 21.09.2014.
 */
import java.text.ParseException;
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

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        switch (args[0].charAt(1))
        {
            case 'c':
                create(args);
                break;
            case 'u':
                update(args);
                break;
            case 'd':
                delete(args);
                break;
            case 'i':
                inform(args);
                break;
        }
    }

    private  static void create(String[] args) throws ParseException
    {
        List<String> list = new ArrayList<String>();
        for (String s : args)
        {
            if (!s.contains("-"))
            {
                list.add(s);
                if (s.contains("/"))
                {
                    createTherd(list.toArray(new String[list.size()]));
                    list.clear();
                }
            }
        }
    }

    private  static void update(String[] args) throws ParseException
    {
        List<String> list = new ArrayList<String>();
        for (String s : args)
        {
            if (!s.contains("-"))
            {
                list.add(s);
                if (s.contains("/"))
                {
                    updateTherd(list.toArray(new String[list.size()]));
                    list.clear();
                }
            }
        }
    }

    private  synchronized static void delete(String[] args)
    {
        for (String s : args)
        {
            if (!s.contains("-"))
            {
                Person person = allPeople.get(Integer.parseInt(s));
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);
                allPeople.set(Integer.parseInt(s), person);
            }
        }
    }

    private synchronized static void inform(String[] args)
    {
        for (String s : args)
        {
            if (!s.contains("-"))
            {
                Person person = allPeople.get(Integer.parseInt(s));
                System.out.println(person.getName() + " " +
                        (person.getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                        dateFormatOut.format(person.getBirthDay()));
            }
        }
    }

    private  synchronized static void createTherd(String[] args) throws ParseException
    {

        Person person = null;
        int name = 0;
        int sex = 1;
        int date = 2;
        do
        {
            if (args[sex].equals("м"))
                person = Person.createMale(args[0], dateFormat.parse(args[date]));
            else if (args[sex].equals("ж")) person = Person.createFemale(args[1], dateFormat.parse(args[date]));
            else
            {
                args[0] = args[0].concat(" " + args[++name]);
                sex++;
                date++;
            }
        }
        while (person == null);

        allPeople.add(person);
        System.out.println(allPeople.indexOf(person));
    }

    private synchronized static void updateTherd(String[] args) throws ParseException
    {
        int name = 1;
        int sex = 2;
        int date = 3;
        boolean b = false;
        Person person = allPeople.get(Integer.parseInt(args[0]));
        do
        {
            if (args[sex].equals("м"))
            {
                person.setSex(Sex.MALE);
                b = true;
            } else if (args[sex].equals("ж"))
            {
                person.setSex(Sex.FEMALE);
                b = true;
            } else
            {
                args[1] = args[1].concat(" " + args[++name]);
                sex++;
                date++;
            }
        }
        while (!b);
        person.setName(args[1]);
        person.setBirthDay(dateFormat.parse(args[date]));
        allPeople.set(Integer.parseInt(args[0]), person);
    }
}