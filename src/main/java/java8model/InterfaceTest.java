package main.java.java8model;

/**
 * Create by zhuqiuping
 * on 2017/3/26
 */
public class InterfaceTest {

    public static void main(String[] args) {
        Student student = new Student("慧慧", 22);
        IFunction test = new FunctionImpl();
        Person person = (Person)test.apply(student);

        System.out.println(person);

//        IFunction test2 = (19) -> {
//            return new Double(19);
//        };
        test.showFunction();

        IFunction.engine();
    }


}
