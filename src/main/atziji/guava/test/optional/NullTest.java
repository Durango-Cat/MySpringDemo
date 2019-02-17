package main.atziji.guava.test.optional;

import com.google.common.base.Optional;
import org.junit.jupiter.api.Test;

import java.util.Set;


/**
 * Optional中的null测试
 *
 * @author ZhuQiuPing
 *         on 2017/12/26
 */
public class NullTest {

    /**
     * 调用Optional静态方法（of、absent、fromNullable)
     */
    @Test
    public void getStaticOptionalMethodTest() {
        //如果of内传null，会立即报错，即快速失败异常；内部包含了非空的T类型参数
        Optional ofOptional = Optional.of(6);
        System.out.println(ofOptional.isPresent());
        //Optional空的构造器，默认内容为空
        Optional<Integer> absentOptional = Optional.absent();
        System.out.println(absentOptional.isPresent());
        //接受数据为空，不报错， fromNullable(null)等价于absent()
        Optional<Integer> nullOptional = Optional.fromNullable(null);
        System.out.println(nullOptional.isPresent());

        Optional<Integer> nonNullOptional = Optional.fromNullable(11);
        System.out.println(nonNullOptional.isPresent());
    }

    /**
     * 调用Optional实例方法
     */
    @Test
    public void getOtherTest() {
        Optional<Long> nullOptional = Optional.fromNullable(null);
        //想看看null时，get好像直接报IllegalStateException: Optional.get() cannot be called on an absent value
//        System.out.println(nullOptional.get());
        //不论输入什么，输出被比较的数据, 此处不能输入null,因为null不属于Object下面的子类；
        System.out.println("nullOptional的or方法： " + nullOptional.or(-12L));
        //如果为null，就直接输出null
        System.out.println("nullOptional的orNull方法：" + nullOptional.orNull());

        Optional<Long> nonNullOptional = Optional.fromNullable(15L);
        System.out.println("nonNullOptional的get方法：" + nonNullOptional.get());
        System.out.println("nonNullOptional的or方法：" + nonNullOptional.or(0L));
        System.out.println("nonNullOptional的or方法：" + nonNullOptional.or(15L));
        System.out.println("nonNullOptional的orNull方法：" + nonNullOptional.orNull());

        Set<Long> set = nonNullOptional.asSet();
        System.out.println(set.size());
        System.out.println(set);
    }
}
