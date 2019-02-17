package main.atziji.java.test.about.model;

/**
 * 向类中添加默认属性的测试类
 *
 * Create by ZhuQiuPing
 * on 2017/11/12
 */
public class ModelAddDefaultParamTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("薛志伟");

        System.out.println(person);
//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        person.setName("袁英昊");
        System.out.println(person);
    }
}

class Person {
    private String name;
    private School school = School.getSchoolInfo();
    private long dateTime = System.currentTimeMillis();

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", school=" + school +
                ", dateTime=" + dateTime +
                '}';
    }


}

class School {
    private String name;
    private String location;
    private String level;

    private School(String name, String location, String level) {
        this.name = name;
        this.location = location;
        this.level = level;
    }

    public static School getSchoolInfo() {
        return new School("承德一中", "陕西省榆林市承德区承德一中", "highschool");
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
