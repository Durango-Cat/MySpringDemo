package main.atziji.guava.test.cache;

import com.google.common.cache.*;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * guava中的缓存测试
 *
 * @author ZhuQiuPing
 *         on 2018/1/25
 */
public class CacheBuilderTest {



    public Map<String, String> getMapTest() {
        Map<String, String> mapTest = Maps.newHashMap();
        mapTest.put("1", "郑和");
        mapTest.put("2", "雍正");
        mapTest.put("3", "李白");
        mapTest.put("4", "杜甫");
        mapTest.put("5", "李商隐");
        mapTest.put("6", "陆游");
        mapTest.put("7", "李清照");
        mapTest.put("8", "曹操");
        mapTest.put("9", "曹丕");
        mapTest.put("10", "曹植");
        mapTest.put("11", "屈原");
        mapTest.put("12", "白居易");
        mapTest.put("13", "刘禹锡");
        return mapTest;
    }

    public String getValueForKey(String key) {
        return getMapTest().get(key);
    }

    /**
     * 测试CacheLoader方式查找缓存中的数据
     * （从缓存中取key X的值，如果该值已经缓存过了，则返回缓存中的值，如果没有缓存过，可以通过某个方法来获取这个值）
     * 一般用的CacheLoader方式比较多，
     */
    @Test
    public void cacheLoaderTest() {

        LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
                //最大存储100个
                .maximumSize(100)
                .build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return getValueForKey(key);
            }
        });

        String value = "-1";
        try {
           value = graphs.get("3");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(value);
    }

    /**
     * 测试在get方式中添加Callable来查找缓存中的数据
     * （不同的在于cacheloader的定义比较宽泛， 是针对整个cache定义的，可以认为是统一的根据key值load value的方法。而callable的方式较为灵活，允许你在get的时候指定）
     */
    @Test
    public void callableTest() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(20)
                .build();

        try {
            String result = cache.get("12", new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "result";
                }
            });
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试权重，好像并不管什么用
     */
    @Test
    public void weightTest() {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumWeight(2)
                .weigher(new Weigher<String, String>() {
                    @Override
                    public int weigh(String k1, String v1) {
                        return v1.length();
                    }
                })
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return getValueForKey(s);
                    }
                });

        try {
            String value = cache.get("13");
            System.out.println(value);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于容量回收测试
     */
    @Test
    public void capacityRecoveryTest() {
        LoadingCache<String, Student> cache = CacheBuilder.newBuilder()
                .maximumSize(10)
                //.maximumWeight(40)
                //.weigher(new Weigher<String, Student>() {
                //    @Override
                //    public int weigh(String k1, Student v1) {
                //        return v1.getAge();
                //    }
                //})
                //.removalListener(new RemovalListener<String, Student>() {
                //    @Override
                //    public void onRemoval(RemovalNotification<String, Student> removalNotification) {
                //        System.out.println(removalNotification.getKey() + "----->被移除");
                //    }
                //})
                .build(new CacheLoader<String, Student>() {
                    @Override
                    public Student load(String s) throws Exception {
                        return getStudentForKey(s);
                    }
                });

        Student student = null;
        try {
            student = cache.get("stu10");
            System.out.println(student);
            //student = cache.get("stu2");
            //System.out.println(student);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        cache.put("stu11", new Student("zhuOne", 25));
        for(int i = 0; i < 9; i++) {
            cache.put("stu" + i, new Student("zhuTwo", 26));
        }

        System.out.println(cache.asMap());
    }

    /**
     * 定时回收
     * (expireAfterWrite是如果在指定的时间内没有创建或覆盖，就从缓存中回收，即从缓存中清除出去，如果再次查询的话，就会重新调用数据库或者数据源中的数据即加载load方法)
     */
    @Test
    public void timerEvicationTest() {
        LoadingCache<String, Student> cache2 = CacheBuilder.newBuilder().maximumSize(10)
                .expireAfterAccess(2, TimeUnit.MILLISECONDS)
                .removalListener(new RemovalListener<String, Student>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, Student> removalNotification) {
                        System.out.println(removalNotification.getValue().getName() + "被删除掉了--------------");
                    }
                }).build(new CacheLoader<String, Student>() {
                    @Override
                    public Student load(String s) throws Exception {
                        System.out.println("嘟嘟");
                        return getStudentForKey(s);
                    }
                });

        try {
///*这块是测试expireAfterWrite方式的
            Student student = cache2.get("stu1", new Callable<Student>() {
                @Override
                public Student call() throws Exception {
                    return new Student("傻逼", 24);
                }
            });
            System.out.println(cache2.get("stu1"));
            Thread.sleep(300);
            System.out.println(cache2.get("stu1"));

            Student student1 = cache2.get("stu2", new Callable<Student>() {
                @Override
                public Student call() throws Exception {
                    return new Student("傻逼兮兮", 31);
                }
            });
            System.out.println(cache2.get("stu2"));
            Thread.sleep(600);
            System.out.println(cache2.get("stu2"));
            System.out.println(cache2.size());

            //Student student2 = cache2.get("stu3", new Callable<Student>() {
            //    @Override
            //    public Student call() throws Exception {
            //        return new Student("臭傻逼", 31);
            //    }
            //});
            //
            //System.out.println(cache2.size());
            //Thread.sleep(80000);
            //System.out.println(cache2.size());
            //Thread.sleep(8000);
            //System.out.println(cache2.get("stu1"));
            //System.out.println(cache2.get("stu2"));
            ////*/
            //
            //System.out.println(cache2.get("stu1").getName());
            //cache2.get("stu1", new Callable<Student>() {
            //    @Override
            //    public Student call() throws Exception {
            //        return new Student("你为毛这样", 23);
            //    }
            //});

            //System.out.println(cache2.get("stu1").getName());
            //System.out.println(cache2.get("stu2"));
            //System.out.println(cache2.get("stu3"));
            //Thread.sleep(300);
            //System.out.println("bbbb");
            //cache2.put("stu14", new Student("无语", 23));
            //Thread.sleep(120);
            //System.out.println(cache2.get("stu2"));
            //cache2.put("stu15", new Student("ewedw",3));
            //Thread.sleep(200);
            //System.out.println(cache2.get("stu3"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 试试刷新
     * 添加refreshAfterWrite跟在build方法中添加reload方法是没有太大必然联系的
     */
    @Test
    public void refreshTest() {
        LoadingCache<String, Student> cacheBuilder = CacheBuilder.newBuilder()
                .maximumSize(15)
                .refreshAfterWrite(10, TimeUnit.MILLISECONDS)
                .build(new CacheLoader<String, Student>() {
                    @Override
                    public Student load(String key) throws Exception {
                        return getStudentForKey(key);
                    }
                    //多线程异步刷新时，调用的加载资源的方式；
                    @Override
                    public ListenableFuture<Student> reload(final String key, Student oldValue) throws Exception {
                        System.out.println("OLDVALUE: " + oldValue);
                        if("I love you".equalsIgnoreCase(key)) {
                            return Futures.immediateFuture(new Student("I love you", 100000));
                        } else {
                            ListenableFutureTask<Student> taks = ListenableFutureTask
                                    .create(new Callable<Student>() {
                                        @Override
                                        public Student call() throws Exception {
                                            return getStudentForKey(key);
                                        }
                                    });
                            //自己也在网上又看到实现里面ListenableFuture的方式
                            //但是阿里文档会有告警提示，说不支持Executors方式，这样很容易引起资源浪费，避免资源耗尽风险；
                            MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10)).submit(new Callable<Student>() {
                                @Override
                                public Student call() throws Exception {
                                    return getStudentForKey(key);
                                }
                            });
                            return taks;
                            //这块没打算弄定时刷新，所以没有弄多线程的东西
                            //Executor executor = new Executor() {
                            //    @Override
                            //    public void execute(Runnable command) {
                            //
                            //    }
                            //};
                            //executor.execute(taks);
                        }
                    }
                });

        try {
            Student student = cacheBuilder.get("stu1");
            System.out.println(student);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public Student getStudentForKey(String key) {
        return getStudentInfo().get(key);
    }

    private static Map<String, Student> getStudentInfo() {
        Map<String, Student> studentInfoMap = Maps.newHashMap();
        studentInfoMap.put("stu1", new Student("yibo", 20));
        studentInfoMap.put("stu2", new Student("erbo", 21));
        studentInfoMap.put("stu3", new Student("sanbo", 22));
        studentInfoMap.put("stu4", new Student("sibo", 23));
        studentInfoMap.put("stu5", new Student("wubo", 24));
        studentInfoMap.put("stu6", new Student("liubo", 25));
        studentInfoMap.put("stu7", new Student("qibo", 26));
        studentInfoMap.put("stu8", new Student("babo", 27));
        studentInfoMap.put("stu9", new Student("jiubo", 28));
        studentInfoMap.put("stu10", new Student("shibo", 29));
        studentInfoMap.put("stu11", new Student("shibo", 29));

        return studentInfoMap;
    }


}

class Student {
    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

