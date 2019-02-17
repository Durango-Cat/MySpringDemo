package main.atziji.java.test;

/**
 * 测试Map集合的操作
 *
 * @author ZhuQiuPing
 *         on 2018/1/3
 */
public class MapObjectTest {
    public static void main(String[] args) {
        //Map<String, PersonTest> maps = Maps.newHashMap();
        //maps.put("1", new PersonTest("丽丽", 23, "莲湖路"));
        //maps.put("2", new PersonTest("花花", 21, "北苑路"));
        //maps.put("3", new PersonTest("欣欣", 20, "三里屯"));
        //maps.put("4", new PersonTest("鑫鑫", 19, "灵境胡同"));
        //maps.put("5", new PersonTest("新新", 24, "学院路"));
        //maps.put("6", new PersonTest("莉莉", 22, "立汤路"));
        //
        //List<Map<String, Object>> lists = Lists.newArrayList();
        //Map<String, Object> maps1 = Maps.newHashMap();
        //maps1.put("susu", "素素");
        //maps1.put("lala", "啦啦");
        //maps1.put("sunzhe", "孙哲");
        //lists.add(maps1);
        //
        //Map<String, Object> maps2 = Maps.newHashMap();
        //maps2.put("tutu", "兔兔");
        //maps2.put("lala", "兔兔");
        //maps2.put("sunzhe", "兔兔");
        //maps2.put("susu", "兔兔");
        //lists.add(maps2);
        //
        //System.out.println(lists);
        //
        //lists.forEach(map -> {
        //    map.put("lala", "拉拉");
        //});

        //System.out.println("-------");
        //System.out.println(lists);

    }
}

class PersonTest {
    private String name;
    private Integer age;
    private String position;

    public PersonTest(String name, Integer age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "PersonTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                '}';
    }
}
