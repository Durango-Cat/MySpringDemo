package main.atziji.java.test;

import org.junit.Test;

/**
 * 校验器测试类型
 *
 * @author ZhuQiuPing
 *         on 2019/1/14
 */
public class ValidatorTest {

    @Test
    public void validatorOne() {
        // 获得验证器

        //Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        String trans_ref_x = "trans_ref_x.123";
        String trans_ref = "";
        if(trans_ref_x.contains(".")) {
            trans_ref = trans_ref_x.split("\\.")[0];
        }
        System.out.println(trans_ref + "\n" + trans_ref_x);
    }
}
