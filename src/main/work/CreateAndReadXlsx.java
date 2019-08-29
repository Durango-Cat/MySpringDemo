package main.work;

import com.google.common.collect.Lists;
import main.java.test.ExportFileTest;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * 创建和读取xlsx类型的文件
 *
 * @author Zhuqiuping on 2019/8/14
 */
public class CreateAndReadXlsx {

    private static final Logger LOG = Logger.getLogger("CreateAndReadXlsx");
    //public
    //public static void main(String[] args) {
    //
    //
    //}

    /**
     * 数据库13的假数据
     */
    public List<String> mongodb13List = Lists.newArrayList(
            "数据链路", "展示路径", "0401test", "041101", "mr-5.6-test",
            "20190320-路径", "渤海异步用（勿动）", "北京-SY-MDZZ-业务路径-AA",
            "根源告警四种情况勿动", "testdat路径", "111111", "lifeng测试路径",
            "1217"
    );

    /**
     * 数据库100的假数据
     */
    public List<String> mongodb100List = Lists.newArrayList(
            "数据链路", "展示路径", "0401test", "041101", "mr-5.6-test",
            "20190320-路径", "渤海异步用（勿动）", "北京-SY-MDZZ-业务路径-AA",
            "根源告警四种情况勿动", "testdat路径1", "1111111", "lifeng测试路径1",
            "1218"
    );

    public void readConfiguration() {

    }

    private void exportXlsx(String filePath, String fileName) {
        FileOutputStream fileOutputStream = null;
        XSSFWorkbook workbook2007 = null;

        File file = new File(filePath + "/" + fileName + ".xlsx");
        File path = new File(filePath);
        //判断文件是否存在，不存在创建
        if(!ExportFileTest.judgeFileExists(fileName, file, path, ".xlsx")) {
            return ;
        }

        // 写入
        try {
            fileOutputStream = new FileOutputStream(file);
            // 先创建工作薄的对象
            workbook2007 = new XSSFWorkbook();
            // 创建工作表对象并命名
            XSSFSheet sheet = workbook2007.createSheet(fileName);
            // 创建样式
            XSSFFont font = workbook2007.createFont();
            XSSFCellStyle headerStyle = workbook2007.createCellStyle();
            XSSFCellStyle cellStyle = workbook2007.createCellStyle();


            workbook2007.write(fileOutputStream);
        } catch (IOException e) {
            LOG.info("xlsx类型的写入文件后异常" + e);
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                LOG.info("xlsx类型的写入文件后关闭FileOutputStream资源异常");
            }

            try {
                if (workbook2007 != null) {
                    workbook2007.close();
                }
            } catch (IOException e) {
                LOG.info("xlsx类型的写入文件后关闭XSSFWorkbook资源异常");
            }

        }
    }

    //public static MongoOperations getMongo() {
    //    try {
    //        // Init the Spring Data MongoDB
    //        @SuppressWarnings("resource")
    //        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    //        ctx.register(MongoConfig.class);
    //        PropertiesPropertySource source = new PropertiesPropertySource("MongoConfig",
    //                getMongoConfigProperties());
    //        ctx.getEnvironment().getPropertySources().addFirst(source);
    //        ctx.refresh();
    //        return (MongoOperations) ctx.getBean("mongoTemplate");
    //    } catch (Exception e) {
    //        System.exit(1);
    //        return null;
    //    }
    //}

    private static Properties getMongoConfigProperties() {
        Properties mongoProp = new Properties();
        mongoProp.put("mongodb_user", "ezsonaruser");
        mongoProp.put("mongodb_password", "123");
        mongoProp.put("mongodb_database", "ezsonar");
//        mongoProp.put("mongodb_host", "192.168.1.233");
        mongoProp.put("mongodb_host", "192.168.6.134");
        mongoProp.put("mongodb_port", 27017);
        return mongoProp;
    }
}
