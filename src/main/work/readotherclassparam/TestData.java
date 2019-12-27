package main.work.readotherclassparam;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author Zhuqiuping on 2019/12/27
 */
public class TestData {

    @Test
    public void test1() {
        AppData appData = new AppData(343L, "85.3", "99.9", "--", "--");
        appData.setAppName("white_2R");
        appData.setAppAliasName("别名2");

        ServerData serverData = new ServerData(797856L, "444.22", "100", "20", "100");
        serverData.setServerName("4948343433222");
        serverData.setServerAliasName("");

        List<IData> dataList = Lists.newArrayList();
        dataList.add(appData);
        dataList.add(serverData);

        System.out.println(dataList);
    }
}
