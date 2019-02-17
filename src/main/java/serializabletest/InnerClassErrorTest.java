package main.java.serializabletest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 内部类中不能实例化的问题
 *
 * Create by zhuqiuping
 * on 2017/5/17
 */
public class InnerClassErrorTest {
    public static void main(String[] args) {
        InnerClassError innerClassError = new InnerClassError();
        innerClassError.setName("斑点狗");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(innerClassError.new Inner());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(oos != null) {
                oos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
