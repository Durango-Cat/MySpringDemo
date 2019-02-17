package main.java.java8model;

/**
 * 测试Lambda用
 *
 * Create by zhuqiuping
 * on 2017/3/24
 */
public class Person {
    private String name;
    private int age;

    public Person(final String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name.equals(person.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {
    }

//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
