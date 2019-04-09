package main.atziji.normalstructure.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * BigDecimal的测试类
 *
 * @author ZhuqiuPping on 2019/4/9
 */
public class TestBigDecimal {

    /**
     * 测试BigDecimal中100.0取整管用不
     * 结果：取整了
     */
    @Test
    public void testBigDecimalRounding() {
        Float rate = 100.0F;
        BigDecimal bd = new BigDecimal(rate.toString());
        System.out.println(bd.setScale(0, BigDecimal.ROUND_HALF_DOWN));
    }
}
