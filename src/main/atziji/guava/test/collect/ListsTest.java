package main.atziji.guava.test.collect;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 针对Lists.transform方法进行测试
 * @author ZhuQiuPing
 *         on 2018/2/7
 */
public class ListsTest {

    @Test
    public void testXxx() {
        String xx = "http://192.168.100.145:8085";
        System.out.println(xx.length());
    }

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

    static Set<String> dayIndexSet = Sets.newHashSet();
    static Set<String> hourIndexSet = Sets.newHashSet();
    static List<String> existIndexesList = Lists.newArrayList();
    static List<String> dataIndexList = Lists.newArrayList();
    static List<String> dayIndexTempList;
    //最后一天索引
    static String lastDayIndex;
    {

        hourIndexSet.add("ezsonar_2019-09-28-01");
        hourIndexSet.add("ezsonar_2019-09-28-02");
        dayIndexSet.add("ezsonar_2019-09-25");
        dayIndexSet.add("ezsonar_2019-09-26");
        hourIndexSet.add("ezsonar_2019-09-28-05");
        dayIndexSet.add("ezsonar_2019-09-23");
        dayIndexSet.add("ezsonar_2019-09-24");
        dayIndexSet.add("ezsonar_2019-09-27");
        dayIndexSet.add("ezsonar_2019-09-28");

        hourIndexSet.add("ezsonar_2019-09-28-03");
        hourIndexSet.add("ezsonar_2019-09-28-04");
        //List<String> dayIndexList = Lists.newArrayList(dayIndexSet);
        //Collections.sort(dayIndexList);

        //.

        //dataIndexList.addAll(dayIndexList);
        dataIndexList.add("ezsonar_2019-09-23-06");
        dataIndexList.add("ezsonar_2019-09-23-07");
        dataIndexList.add("ezsonar_2019-09-25-08");
        dataIndexList.add("ezsonar_2019-09-26-06");
        dataIndexList.add("ezsonar_2019-09-27-05");
        dataIndexList.add("ezsonar_2019-09-23-09");
        dataIndexList.add("ezsonar_2019-09-23-01");
        dataIndexList.add("ezsonar_2019-09-25-09");
        dataIndexList.add("ezsonar_2019-09-24-03");
        dataIndexList.add("ezsonar_2019-09-24-02");
        dataIndexList.add("ezsonar_2019-09-24-01");
        dataIndexList.add("ezsonar_2019-09-24-09");
        dataIndexList.add("ezsonar_2019-09-28-01");
        dataIndexList.add("ezsonar_2019-09-28-02");
        dataIndexList.add("ezsonar_2019-09-28-03");
        dataIndexList.add("ezsonar_2019-09-28-04");
        dataIndexList.add("ezsonar_2019-09-28-05");
        dataIndexList.add("ezsonar_2019-09-28");
        dataIndexList.add("ezsonar_2019-09-27");
        dayIndexTempList = Lists.newArrayList(dayIndexSet);
        //最后一天索引
        //lastDayIndex = dayIndexTempList.remove(dayIndexList.size() - 1);
    }

    private static SimpleDateFormat hourDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Test
    public void listTest() {
        for(String index : dataIndexList) {
            //    //apm
            //    if (index.startsWith("ezsonar_")) {
            //        //天索引
            //        if (index.split("-").length == 3 && dayIndexSet.contains(index)) {
            //            existIndexesList.add(index);
            //        }
            //        //小时索引
            //        else if (index.split("-").length == 4) {
            //            //转成天索引
            //            String hourChangeDayIndex = new String(index);
            //            hourChangeDayIndex = hourChangeDayIndex.substring(0, index.lastIndexOf("-"));
            //            if (lastDayIndex.equals(hourChangeDayIndex)) {
            //                existIndexesList.add(index);
            //            }
            //            //只添加最后一天 天索引之后的小时索引
            //            else if (!dayIndexTempList.contains(hourChangeDayIndex)) {
            //                existIndexesList.add(index);
            //            }
            //        }
            //    } else {
            //        existIndexesList.add(index);
            //    }
            //}

            if (index.split("-").length == 3 && index.startsWith("ezsonar_") && dayIndexSet.contains(index)) {
                existIndexesList.add(index);
            } else if (index.split("-").length == 4 && index.startsWith("ezsonar_")) {
                String[] hours = index.split("_");
                if (hourIndexSet.contains(index) || hours[1].contains(hourDateFormat.format(new Date()))) {
                    existIndexesList.add(index);
                }
            } else if (!index.startsWith("ezsonar_")) {
                existIndexesList.add(index);
            }
        }
        System.out.println(existIndexesList);
    }

    @Test
    public void testEmptyListSort() {
        List<String> ssList = Lists.newArrayList("", "3234", "desd", "");
        //ssList.sort(new Comparator<String>() {
        //    @Override
        //    public int compare(String o1, String o2) {
        //        return o1.toLowerCase().compareTo(o2.toLowerCase());
        //    }
        //});

        ssList.set(3, "232344r");

        System.out.println(ssList);
    }

    @Test
    public void testChineseSort() {
        //List<String> chineseNameList = Lists.newArrayList("张胜男", "吴起", "范进", "张潇", "吕胜新", "cwerw");
        List<String> chineseNameList = Lists.newArrayList("sdfwefew", "regeeg", "vvbfvfv", "34rrege", "cdvdvdv", "cwerw", "张胜男", "吴起", "范进", "张潇", "吕胜新");
        //chineseNameList.sort(new Comparator<String>() {
        //    @Override
        //    public int compare(String o1, String o2) {
        //        return o1.compareToIgnoreCase(o2);
        //    }
        //});
        //System.out.println(chineseNameList.toString());

        chineseNameList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toLowerCase().compareToIgnoreCase(o2.toLowerCase());
            }
        });
        System.out.println(chineseNameList.toString());
    }

    /**
     * 组合字段排序
     */
    @Test
    public void testManyParamSort() {
        List<User> userList = Lists.newArrayList();
        userList.add(new User("排序", 43));
        userList.add(new User("顺序", 322));
        userList.add(new User("蒙圈", 324));
        userList.add(new User("完犊子", 43));
        userList.add(new User("孟子", 43));
        userList.add(new User("完犊子1", 43));
        userList.add(new User("孟子2", 43));
        userList.add(new User("排序1", 43));
        userList.add(new User("顺序需", 43));
        userList.add(new User("按需", 43));

        for(int i = 0; i < 10000; i++) {
            userList.sort(new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    Integer age1 = o1.getAge();
                    Integer age2 = o2.getAge();
                    int sortAge = age2.compareTo(age1);
                    if(sortAge == 0) {
                        String name1 = o1.getName();
                        String name2 = o2.getName();
                        return name2.compareToIgnoreCase(name1);
                    }
                    return sortAge;
                }
            });
            System.out.println("i\t\t" + userList);
        }


    }

    @Test
    public void testCompareToNull() {
        List<String> strList = Lists.newArrayList();

        System.out.println(strList.get(strList.size() - 1));
    }

    @Test
    public void testStreamFilter() {
        List<NewObject> studentList = Lists.newArrayList();
        studentList.add(new NewObject(false, "12312312"));
        studentList.add(new NewObject(true, "tertr"));
        studentList.add(new NewObject(false, "12312312"));
        studentList.add(new NewObject(true, "张三"));
        studentList.add(new NewObject(true, "王五"));
        studentList.add(new NewObject(null, "随便"));
        studentList.add(new NewObject(null, "kong"));
        studentList.add(new NewObject(true, "shun"));
        studentList.add(new NewObject(true, ""));

        //List<String> objectNameList = studentList.stream().filter(newObject -> newObject.isUseIt() != null && newObject.isUseIt()).
    }
    //private String convertToHanYuPinYinString(String str) {
    //
    //    StringBuilder sb = new StringBuilder();
    //    String[] arr = null;
    //
    //    for (int i = 0; i < str.length(); i++) {
    //        arr = PinyinHelper.toHanyuPinyinStringArray(str.charAt(i));
    //        if (arr != null && arr.length > 0) {
    //            for (String string : arr) {
    //                sb.append(string);
    //            }
    //        } else {
    //            sb.append(str.charAt(i));
    //        }
    //    }
    //
    //    return sb.toString();
    //}

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


class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return age != null ? age.equals(user.age) : user.age == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
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

class NewObject {
    private Boolean useIt;
    private String objectName;

    public NewObject(Boolean useIt, String objectName) {
        this.useIt = useIt;
        this.objectName = objectName;
    }

    public Boolean isUseIt() {
        return useIt;
    }

    public void setUseIt(Boolean useIt) {
        this.useIt = useIt;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    @Override
    public String toString() {
        return "NewObject{" +
                "useIt=" + useIt +
                ", objectName='" + objectName + '\'' +
                '}';
    }
}