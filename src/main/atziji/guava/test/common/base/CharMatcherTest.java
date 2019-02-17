package main.atziji.guava.test.common.base;

import com.google.common.base.CharMatcher;
import org.junit.Test;

/**
 * 对字符匹配的测试
 *
 * @author ZhuQiuPing
 *         on 2018/1/20
 */
public class CharMatcherTest {

    @Test
    public void testOne() {
        CharMatcher charMatcher = CharMatcher.javaIsoControl();
        //System.out.println(inRange('a', 'z').or(inRange('A', 'Z')).retainFrom("43dwaERERFEAegeg"));
        //System.out.println(charMatcher.or(inRange('A', 'Z')).retainFrom("好汉RERFEAegeg"));
        //System.out.println(CharMatcher.anyOf("eko").collapseFrom("bookkeeper", '-'));
        //System.out.println(charMatcher.collapseFrom("dsdsd swwww  weeee  efff fff", ' '));
        //去掉开头和结尾中匹配a和d之内的元素的包括空格
        System.out.println(CharMatcher.inRange('a', 'd').trimFrom("asda  dewd ad"));
        //System.out.println(CharMatcher.anyOf("ab").trimFrom("abacatbab"));
    }

    @Test
    public void testOther() {
        String str = "921212,22323,2121231,1234341";
        System.out.println(str.replace(",", " "));
        String str1 = " 932323 323  ";
        str1 = str1.trim();
        System.out.print(str1.trim());
        System.out.println(str1.trim().replace(",", " "));
    }

    @Test
    public void testSize() {
        int length = 10000;
        int maxLength = 10000;
        int page = 1;
        int pageSize = 50;
        int size = pageSize;
        for(page = 1; size <= maxLength;) {
            if(size == 9983) {
                System.out.println(pageSize);
            }
            length = 9983;

            if(page == 1) {
                maxLength = length;
            }

            if(size * pageSize > maxLength && (size * pageSize - maxLength < pageSize)) {
                pageSize = size * pageSize - maxLength;
                size = pageSize;
                ++page;
            } else {
                size = pageSize * ++page;
            }
        }
    }
}
