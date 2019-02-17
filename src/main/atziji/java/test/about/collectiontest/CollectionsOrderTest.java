package main.atziji.java.test.about.collectiontest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * 测试List中Collections.sort排序
 *
 * Create by ZhuQiuPing
 * on 2017/9/10
 */
public class CollectionsOrderTest {

    public static void main(String[] args) {
        List<PersonNew> personList = new ArrayList<>();
        personList.add(new PersonNew("孙哲", 23));
        personList.add(new PersonNew("李希", 18));
        personList.add(new PersonNew("李默", 21));
        personList.add(new PersonNew("赵瑞", 24));
        personList.add(new PersonNew("陈一喆", 20));
        personList.add(new PersonNew("李欣姿", 23));
        personList.add(new PersonNew("孙哲", 28));
        personList.add(new PersonNew("孙哲", 25));
        personList.add(new PersonNew("张志远", 29));
        personList.add(new PersonNew("吴亦凡", 28));
        personList.add(new PersonNew("张馨予", 31));
        personList.add(new PersonNew("李魏西", 32));

        System.out.println(personList.size());
        Collections.sort(personList);

        ListIterator<PersonNew> iterator = personList.listIterator();
        while(iterator.hasNext()) {
//        while(iterator.hasPrevious()) {
            System.out.println(iterator.next().getName());
            System.out.println(iterator.previous().getName());
        }
//        for (PersonNew person: personList) {
//            System.out.println(person.getName() + " : " + person.getAge());
//        }

    }
}

class PersonNew implements Comparable<PersonNew> {

    private String name;

    private int age;



    PersonNew(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(PersonNew o) {
//        return age > o.getAge() ? 1 : (this.age == o.getAge() ? 0 : -1);
        int i = name.compareTo(o.name);
        if(i == 0)
            return age - o.age;
        else
            return i;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}