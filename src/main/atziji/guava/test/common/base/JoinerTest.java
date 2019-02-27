package main.atziji.guava.test.common.base;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * 针对Joiner拼接字符串的练习
 *
 * @author ZhuQiuPing
 *         on 2018/1/21
 */
public class JoinerTest {

    @Test
    public void testJoiner() {
        StringBuilder sb = new StringBuilder("new String");
        Joiner joiner = Joiner.on(",").skipNulls();
        joiner.appendTo(sb, "appendTo", "StringBuilder");
        System.out.println(sb);

        try {
            FileWriter fileWriter = new FileWriter("fileWriterTest.txt");
            joiner.appendTo(fileWriter, "appendTo", "xxxx00", "FileWriter");
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void MapJoiner() {
        Map<String, Object> maps = Maps.newHashMap();
        maps.put("id", "1233423212");
        maps.put("name", "shent");
        System.out.println(Joiner.on(",").withKeyValueSeparator(":").join(maps));

    }
}
