package main.java.test;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Zhuqiuping on 2019/8/18
 */
public class ReadXlsxFileTest {

    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("D:\\test.xlsx");
        ReadXlsxFileTest re = new ReadXlsxFileTest();
        //re.readExcels(is);
    }


}
