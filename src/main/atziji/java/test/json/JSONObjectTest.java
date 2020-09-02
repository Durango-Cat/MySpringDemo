package main.atziji.java.test.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Iterator;

/**
 * @author Zhuqiuping on 2020/9/2
 */
public class JSONObjectTest {

    @Test
    public void testPutFunction() {
        JSONArray mapping = new JSONArray();
        JSONObject agenct = new JSONObject();
        agenct.put("key", "3232");
        mapping.add(agenct);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ip", "12.2.2.2");
        mapping.add(jsonObject);
        Iterator<Object> iterator = mapping.iterator();
        while (iterator.hasNext()) {
            JSONObject next = (JSONObject)iterator.next();
            if(next.get("ip") != null) {
                next.put("ip", "23.22.44.152");
            }
        }
        //jsonObject.put("ip", "23.22.44.152");
        System.out.println(mapping.toJSONString());
    }
}
