package main.atziji.java.test.about.guava.reflect;

import com.google.common.collect.Maps;
import lombok.Data;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 测试Type
 *
 * @author ZhuQiuPing
 *         on 2017/11/26
 */
public class TypeTest extends Person {

    public static void main(String[] args) {
//        Student student = new Student();
//        Class clazz = student.getClass();
        //ParameterizedType 参数化类型（Map可以，但是普通对象就不行了）
        Map<String, Object> maps = Maps.newHashMap();
        Class clazz = maps.getClass();
        System.out.println(clazz);
        ParameterizedType types = (ParameterizedType) clazz.getGenericSuperclass();
        //type是Type类型，但直接输出的不是具体Type的五种子类型，而是这五种子类型以及WildcardType具体表现形式
        System.out.println(types.getClass().getName());

        System.out.println(types.getActualTypeArguments()[0]);
        System.out.println(types.getOwnerType());
        System.out.println(types.getRawType());
//        if(types instanceof ParameterizedType) {
//            ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();
//        System.out.println(pt);
//            Type type = pt.getActualTypeArguments()[0];
//        System.out.println(type.toString());
//            Class clazz1 = (Class) types.getTypeName();
//            System.out.println(clazz1.toString());
//        }
//        System.out.println(student);
//        student.setName("露西");
//        System.out.println(student.getName());
    }
}

@Data
class Person<T> {
    private String name;
    private String position;


}
@Data
class Student extends Person {
    private String name;
    public Student() {

    }


}