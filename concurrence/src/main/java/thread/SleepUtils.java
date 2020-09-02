package thread;

import java.util.concurrent.TimeUnit;

/**
 * 睡眠工具类
 *
 * @author Zhuqiuping on 2020/6/19
 */
public class SleepUtils {

    public static final void second(long second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {

        }
    }
}
