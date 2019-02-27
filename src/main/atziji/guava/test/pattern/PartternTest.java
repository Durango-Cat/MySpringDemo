package main.atziji.guava.test.pattern;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配字符串
 *
 * @author ZhuQiuPing
 *         on 2018/2/6
 */
public class PartternTest {

    private static final String MATCH = "[0-9]*";
    @Test
    public void testOne() {

        Pattern pattern = Pattern.compile(MATCH);
        Matcher matcher = pattern.matcher("057687432370.281221517291353741");
        System.out.println(matcher.matches());
    }
}
