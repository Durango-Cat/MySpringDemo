package main.atziji.guava.test.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import org.junit.Test;

/**
 * 分割字符串测试
 *
 * @author ZhuQiuPing
 *         on 2018/1/22
 */
public class SpliterTest {

    @Test
    public void easyTest() {
        String str = "abc, def, ghi, jkl,, pqr, stu, vw, xyz";
        System.out.println(Splitter.on(",").omitEmptyStrings().split(str));
    }

    @Test
    public void mapSplitterTest() {
        String str = "key3=value3,key2=value2,key1=value1";
        System.out.println(Splitter.on(",").withKeyValueSeparator("=").split(str));
    }

    @Test
    public void simpleTest() {
        String str = "abc, def,   jkl  , mno    , pqr, stu, vw, xyz";
        System.out.println(Splitter.on(",").trimResults().split(str));
    }

    @Test
    public void trimResultsTest() {
        String str = "*a*,*b*,c**";
        //前后都匹配，只是不能存在空格了，此处不会再默认去掉空格了
        System.out.println(Splitter.onPattern(",").trimResults(CharMatcher.is('*')).split(str));
    }

    @Test
    public void limitTest() {
        String str = "a,v,w,r,q,t,e";
        System.out.println(Splitter.onPattern(",").limit(4).split(str));
    }
}
