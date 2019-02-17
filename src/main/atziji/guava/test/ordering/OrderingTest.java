package main.atziji.guava.test.ordering;


import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Doubles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

/**
 * 测试里面的Ordering
 *
 * @author ZhuQiuPing
 *         on 2018/1/2
 */
public class OrderingTest {

    @Test
    public void testOfOrderingConstructor() {
        List<String> studentsList = Lists.newArrayList();
//        studentsList.add("张明");
//        studentsList.add("李希");
//        studentsList.add("王宇");
//        studentsList.add("Lucy");
//        studentsList.add("Mark");
//        studentsList.add("Mery");
//        studentsList.add("Christina");
//        studentsList.add("Laura");
//        studentsList.add("Rose");
        studentsList.add("peida");
        studentsList.add("jerry");
        studentsList.add("harry");
        studentsList.add("eva");
        studentsList.add("jhon");
        studentsList.add("neron");
//        studentsList.add("瑶瑶");
//        studentsList.add("舜宇");

//        Ordering<String> naturalOrderingList = Ordering.natural();
//        studentsList = naturalOrderingList.sortedCopy(studentsList);
//        System.out.println(studentsList);

//        Ordering<Object> usingToStringList = Ordering.usingToString();
//        System.out.println(usingToStringList.sortedCopy(studentsList));

//        Ordering.natural().nullsFirst().

        Ordering<String> fromList = Ordering.from(String.CASE_INSENSITIVE_ORDER);
        System.out.println(fromList.sortedCopy(studentsList));
    }

    @Test
    public void testIntegerOrdering() {
        List<Integer> integerList = Lists.newArrayList();
        integerList.add(12143);
        integerList.add(2323);
        integerList.add(12145443);
        integerList.add(4542);
        integerList.add(5452);
        integerList.add(656232);
        integerList.add(34312);
        integerList.add(65634);

        Ordering<Integer> integerOrdering = Ordering.natural();
        System.out.println(integerOrdering.sortedCopy(integerList));
    }

    @Test
    public void testOnResultOf() {
        List<Person> personList = Lists.newArrayList();
        personList.add(new Person("张明", 23));
        personList.add(new Person("李希",22));
        personList.add(new Person("王宇",18));
        personList.add(new Person("Lucy",32));
        personList.add(new Person("Mark",33));
        personList.add(new Person("Mery",19));
        personList.add(new Person("Christina",23));
        personList.add(new Person("Laura",12));
        personList.add(new Person("Rose",21));
        personList.add(null);
        
        Ordering<Person> personOrdering = Ordering.natural().onResultOf(new Function<Person, Integer>() {
            //我理解的onResultOf就是结果中按照什么字段排序
            @Override
            public Integer apply(Person person) {
                return person.getAge();
            }
        }).nullsFirst();

        //最小的前3位
//        System.out.println(personOrdering.leastOf(personList, 3));
        //此List是否有序
        System.out.println(personOrdering.isOrdered(personList));
    }

    //实在不会用这个方法，所以办法也没测试出来怎么用的
    @Test
    public void testLexicographical() {
        List<Double> studentsList = Lists.newArrayList();
        studentsList.add(23.4);
        studentsList.add(121.3);
        studentsList.add(3443.1);
        studentsList.add(121.3);
        studentsList.add(545.12);
        studentsList.add(323.54);
        studentsList.add(3231.54);
        studentsList.add(323.5423);
        studentsList.add(545.12);
        studentsList.add(null);

        Ordering<Iterable<Double>> lexicographicalList = Ordering.natural().lexicographical();

//        System.out.println(lexicographicalList.leastOf(studentsList.iterator(),3));

    }
}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
