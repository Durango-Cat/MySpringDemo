package main.java.serializabletest;

import java.io.Serializable;

/**
 * 为测试内部类不能实例化创建的类
 *
 * Create by zhuqiuping
 * on 2017/5/17
 */
public class InnerClassError implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class Inner implements Serializable {
        private String subject;

        public String getSubjectNum(String name) {
            return name + "选修的科目为：" + subject;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }
    }
}
