package main.atziji.guava.test.collect;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 针对Lists.transform方法进行测试
 * @author ZhuQiuPing
 *         on 2018/2/7
 */
public class ListsTest {
    //各种可能坑的实验
    @Test
    public void testOne() {
        List<Student> studentList = Lists.newArrayList();
        studentList.add(new Student("九年级一班", "王明明"));
        studentList.add(new Student("八年级三班", "李玉林"));

        List<String> studentList1 = Lists.transform(studentList, new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                //如果在这里将student中的数据修改后，接下来即使对fromList怎么修改，resultList都会拿到的是上面这块修改的结果
                //student.setClassName("高一二班");
                return student.getClassName();
            }
        });

        System.out.println(studentList);

        System.out.println();
        //此处的studentList1不能修改，一旦修改就会报异常
        System.out.println(studentList1);
        for(Student student : studentList) {
               student.setClassName("高四四班");
        }
        //上面只要在apply中没有处理数据，此处修改studentList对后面studentList1遍历时会有影响
        System.out.println(studentList1);
        for(Student student : studentList) {
            student.setClassName("高四wu班");
        }

        System.out.println("...");
        for(String str : studentList1) {
            System.out.println(str);
        }
    }

    //解决办法，对transform外面重新包上一层Lists.newArrayList或者Sets.newHashSet
    //resultList数据不会受fromList数据改变影响，resultList也可以修改其中的数据
    @Test
    public void testTwo() {
        List<Student> studentList2 = Lists.newArrayList();
        studentList2.add(new Student("九年级一班", "王明明"));
        studentList2.add(new Student("八年级三班", "李玉林"));

        List<String> studentList1 = Lists.newArrayList(Lists.transform(studentList2, new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getClassName();
            }
        }));

        System.out.println(studentList2);

        System.out.println();
        //此处的studentList1不能修改，一旦修改就会报异常
        System.out.println(studentList1);
        for(Student student : studentList2) {
            student.setClassName("高四四班");
        }
        //上面只要在apply中没有处理数据，此处修改studentList对后面studentList1遍历时会有影响
        System.out.println(studentList1);
        for(Student student : studentList2) {
            student.setClassName("高四wu班");
        }

        System.out.println("...");
        for(String str : studentList1) {
            System.out.println(str);
        }
    }

    @Test
    public void listToList(){
        //源list
        List<Result> listResults = Lists.newArrayList(new Result(1,"test1"),new Result(2,"test2"),new Result(3,"test3"));
        //转换为目标list
        List<String> strLists = Lists.transform(listResults,new Function<Result,String>(){
            @Override
            public String apply(Result result){
                return result.getNameStr();
            }
        });
        //转换后目标list打印
        System.out.println("strLists 1 values:");
        for(String str:strLists){
            System.out.println(str+";");
        }
        //修改源list的值
        for(Result result:listResults){
            result.setNameStr("reset");
        }
        //再次打印目标list
        System.out.println("strLists 2 values:");
        for(String str:strLists){
            System.out.println(str+";");
        }
    }

    //给List中添加了null, 然后list数组竟然存进去了，不报错
    @Test
    public void listAddNullData() {
        List<String> strList = Lists.newArrayList();
        strList.add(null);
        System.out.println(strList.size());
        strList.forEach(System.out::println);
    }

}

class Student {
    String className;
    String name;

    public Student(String className, String name) {
        this.className = className;
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class Result {
    private int index;
    private String nameStr;

    public Result(int index, String nameStr) {
        this.index = index;
        this.nameStr = nameStr;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    @Override
    public String toString() {
        return "Result{" +
                "index=" + index +
                ", nameStr='" + nameStr + '\'' +
                '}';
    }
}
