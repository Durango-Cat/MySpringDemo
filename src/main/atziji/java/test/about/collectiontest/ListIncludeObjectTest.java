package main.atziji.java.test.about.collectiontest;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 针对list中包含有对象，并在遍历对象时更改对象中的属性，看是否在list中更改成功
 *
 * Create by ZhuQiuPing
 * on 2017/10/20
 */
public class ListIncludeObjectTest {
    public static void main(String[] args) {
        PersonTest p1 = new PersonTest("孙哲", 23);
        PersonTest p2 = new PersonTest("汪倩", 24);
        PersonTest p3 = new PersonTest("张鑫", 25);
        PersonTest p4 = new PersonTest("丁一", 21);
        List<PersonTest> personTestList = Lists.newArrayListWithExpectedSize(4);
//        List<PersonTest> personTestList = new ArrayList();
        personTestList.add(p1);
        personTestList.add(p2);
        personTestList.add(p3);
        personTestList.add(p4);

        Iterator<PersonTest> iterator = personTestList.iterator();
//        while (iterator.hasNext()){
//            PersonTest p = iterator.next();
//            if(p.getName().equals("汪倩")) {
//                iterator.remove();
//            } else {
//                p.setSex(true);
//            }
//        }
        PersonTest p5 = new PersonTest("丁一", 21);
        PersonTest p6 = new PersonTest("汪倩", 24);
        List<PersonTest> personTestList1 = new ArrayList<>();
        personTestList1.add(p5);
        personTestList1.add(p6);
//        if(personTestList.contains(p5)) {
//            System.out.println("xxxxx");
//        } else {
//            System.out.println("ooooo");
//        }
//        if(personTestList.containsAll(personTestList1)) {
//            System.out.println("xxxxx");
//        } else {
//            System.out.println("ooooo");
//        }
//        Set<PersonTest> personTestSet = new TreeSet<>();
//        Set<PersonTest> personTestSet = new HashSet<>();
//        personTestSet.addAll(personTestList);
//        if(personTestSet.contains(p5)) {
//            System.out.println("xxxxx");
//        } else {
//            System.out.println("ooooo");
//        }

//        personTestList.forEach(System.out::println);
//          personTestSet.forEach(System.out:: println);
//        Collections.OrderedDict

        //自己再测试下List下面的subList(from, to)里from 和 to的取值范围问题
//        List<PersonTest> test = personTestList.subList(0, 0);
//        System.out.println(test == null);
//        System.out.println(test.isEmpty());

        //还要继续测试下向List中从指定位置添加集合，会不会报超出范围异常
//        personTestList.addAll(0, personTestList1);
//        System.out.println(personTestList.size());

    }
}
class PersonTest {
    private String name;
    private int age;
    private Boolean sex;

    public PersonTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PersonTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

//    @Override
//    public int compare(Object o1, Object o2) {
//        PersonTest p1 = (PersonTest)o1;
//        PersonTest p2 = (PersonTest)o2;
//        return p1.
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonTest)) return false;

        PersonTest that = (PersonTest) o;

        if (age != that.age) return false;
        return name.equals(that.name);
//        return this.getName().equals(that.getName()) && this.getAge() == that.getAge();
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }



}
