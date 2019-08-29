package main.design.pattern.factory.ordinary;

import main.design.pattern.factory.Bread;
import main.design.pattern.factory.Toast;

/**
 * 吐司面包工厂
 *
 * @author Zhuqiuping on 2019/8/8
 */
public class ToastFactory extends AbstractTypeFactory {
    @Override
    public Bread createBread() {
        return new Toast();
    }
}
