package main.java.test;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 * 文件导出类
 *
 * @author ZhuQiuPing
 *         on 2018/12/19
 */
public class ExportFileTest {

    private static final Logger LOG = Logger.getLogger("ExportFileTest");

    /**
     * 允许的后缀格式
     */
    private static final String CSV_FILE_EXTENSION = "csv", JSON_FILE_EXTENSION = "json", XLSX_FILE_EXTENSION = "xlsx";

    /**
     * 此处变量只是为了声明出来，本来这个变量是通过读取配置文件拿到的结果
     */
    private static final String exportFileExtension = "xlsx";

    /**
     * 导出流ID和所属的业务路径
     */
    public static void main(String[] args) {

        //遍历流信息，封装流对应的路径名信息集合
        Map<String, String> streamIdAndTopoNamesMap = Maps.newLinkedHashMap();
        streamIdAndTopoNamesMap.put("123123123123", "业务路径1-1,业务路径1-2");
        streamIdAndTopoNamesMap.put("765432345666", "业务路径2-1,业务路径2-2");
        streamIdAndTopoNamesMap.put("765445654343", "业务路径3-1,业务路径3-2,业务路径3-3");
        streamIdAndTopoNamesMap.put("454353234532", "业务路径4-1,业务路径4-2,业务路径4-3,业务路径4-4");
        streamIdAndTopoNamesMap.put("876578345432", "业务路径5-1,业务路径5-2");
        streamIdAndTopoNamesMap.put("213432421234", "业务路径6-1,业务路径6-2");

        //导出文件的文件夹地址
        String exportDirectory = "/Users/zhuqiuping/java/test";
        //导出的文件名上要包括导出的日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String fileName = simpleDateFormat.format(new Date()) + "流ID和路径名称对应表";

        switch (exportFileExtension) {
            case XLSX_FILE_EXTENSION:
                //导出xlsx可以分为有Response方式（网页请求，里面分为get请求和post请求两种方式）和无Response方式。
                writeXlsxNoResponse(exportDirectory, fileName, streamIdAndTopoNamesMap);
                break;
            case CSV_FILE_EXTENSION:
                writeCsv(exportDirectory, fileName, streamIdAndTopoNamesMap);
                break;
            default:
                Gson gson = new Gson();
                String json = gson.toJson(streamIdAndTopoNamesMap);
                writeJson(exportDirectory, fileName, json);
                break;
        }
    }

    /**
     * 将以csv格式写入文件
     *
     * @param path         文件路径
     * @param fileName     文件名
     * @param dataMap      数据集合
     */
    private static void writeCsv(String path, String fileName, Map<String, String> dataMap) {
        BufferedWriter writer = null;
        OutputStreamWriter outputStreamWriter = null;
        //FileOutputStream fileOutputStream = null;
        File file = new File(path + "/" + fileName + ".csv");
        File filePath = new File(path);

        if(!judgeFileExists(fileName, file, filePath, ".csv")) {
            return ;
        }

        // 写入
        try {
            System.out.println(file.getPath());
            //fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            writer = new BufferedWriter(new FileWriter(file));

            //设置表头
            StringBuffer sb = new StringBuffer();
            sb.append("\"").append("流ID").append("\",").append("\"").append("路径名称").append("\"");
            writer.write(sb.toString().toCharArray());
            writer.newLine();

            //填充内容
            for (Map.Entry<String, String> data : dataMap.entrySet()) {
                for(int i = 0; i < 5000; i++) {
                    StringBuffer sbNew = new StringBuffer();
                    sbNew.append("\"").append(data.getKey()).append("\",").append("\"[").append(data.getValue()).append("]\"");
                    writer.write(sbNew.toString().toCharArray());
                    writer.newLine();
                }
            }
            //for(int i = 0; i < 10; i++) {
            //    String str = "\"354353534345345\",\"35353535345345\"";
            //    outputStreamWriter.write(str);
            //    System.out.println(outputStreamWriter.toString().toCharArray());
            //    outputStreamWriter.write("\n");
            //}
            outputStreamWriter.flush();
            //outputStreamWriter.close();
        } catch (IOException e) {
            //LOG.info("json类型的写入文件后异常" + e);
        } finally {
            //try {
            //    if (fileOutputStream != null) {
            //        fileOutputStream.close();
            //    }
            //} catch (IOException e) {
            //    //LOG.info("json类型的写入文件后关闭FileOutputStream资源异常");
            //}

            try {
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            } catch (IOException e) {
                //LOG.info("json类型的写入文件后关闭OutputStreamWriter资源异常");
            }

            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                //LOG.info("json类型的写入文件后关闭BufferedWriter资源异常");
            }
        }
    }

    /**
     * 将以xlsx格式写入文件
     * （此处必须说一下因为没用maven，为了能导出成功xlsx，下了poi-4.0.1.jar, poi-excelant-4.0.1.jar, poi-ooxml-4.0.1.jar,
     *   poi-ooxml-schemas-4.0.1.jar, poi-scratchpad-4.0.1.jar, xmlbeans-3.0.2.jar, dom4j-1.6.1.jar, commons-collections4-4.2.jar,
     *   commons-compress-1.18.jar, commons-logging-1.1.1.jar)
     *
     * @param path          文件路径
     * @param fileName      文件名
     * @param dataMap       数据集合
     */
    private static void writeXlsxNoResponse(String path, String fileName, Map<String, String> dataMap) {
        FileOutputStream fileOutputStream = null;
        XSSFWorkbook workbook2007 = null;

        File file = new File(path + "/" + fileName + ".xlsx");
        File filePath = new File(path);
        //判断文件是否存在，不存在创建
        if(!judgeFileExists(fileName, file, filePath, ".xlsx")) {
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

            // 字体加粗
            font.setBold(true);
            // 设置长文本自动换行
            headerStyle.setWrapText(true);
            headerStyle.setFont(font);
            // 创建表头
            XSSFRow headerRow = sheet.createRow(0);
            headerRow.setHeightInPoints(25f);

            XSSFCell termHeader = headerRow.createCell(0);
            termHeader.setCellValue("流ID");
            termHeader.setCellStyle(headerStyle);

            XSSFCell transCountHeader = headerRow.createCell(1);
            transCountHeader.setCellValue("路径名称");
            transCountHeader.setCellStyle(headerStyle);

            Set<String> keySet = dataMap.keySet();
            int i = 1;
            int firstColumnLength = 0, secondColumnLength = 0;
            for(String key : keySet) {
                // 创建行
                XSSFRow row = sheet.createRow(i++);
                row.setHeightInPoints(20f);
                // 开始创建单元格并赋值
                XSSFCell termCell = row.createCell(0);
                if(firstColumnLength < key.length()) {
                    firstColumnLength = key.length();
                }
                termCell.setCellValue(key);
                termCell.setCellStyle(cellStyle);

                String value = dataMap.get(key);
                if(secondColumnLength < value.length()) {
                    secondColumnLength = value.length();
                }
                XSSFCell countCell = row.createCell(1);
                countCell.setCellValue(value);
                countCell.setCellStyle(cellStyle);
            }

            //在列上加样式（第一列15个字符的长度，第二列70个字符的长度）
            //这种方法是手动设置列宽，因为poi导出excel只支持英文、数字列宽自适应（用sheet.AutoSizeColumn(i);如果出现中文就会出现列宽不足现象)
            sheet.setColumnWidth(1, (secondColumnLength + 2) * 256);
            sheet.setColumnWidth(0, (firstColumnLength + 2) * 256);
            workbook2007.write(fileOutputStream);
        } catch (IOException e) {
            LOG.info("json类型的写入文件后异常" + e);
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                LOG.info("json类型的写入文件后关闭FileOutputStream资源异常");
            }

            try {
                if (workbook2007 != null) {
                    workbook2007.close();
                }
            } catch (IOException e) {
                LOG.info("json类型的写入文件后关闭XSSFWorkbook资源异常");
            }

        }
    }

    /**
     * 将以json格式写入文件
     * (此处需要的jar就是gson-2.6.2.jar)
     *
     * @param path          文件路径
     * @param fileName      文件名
     * @param json          json对象
     */
    private static void writeJson(String path, String fileName, String json) {
        BufferedWriter writer = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        File file = new File(path + "/" + fileName + ".json");
        File filePath = new File(path);
        if(!judgeFileExists(fileName, file, filePath, ".json")) {
            return ;
        }

        // 写入
        try {
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            writer = new BufferedWriter(outputStreamWriter);
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            LOG.info("json类型的写入文件后异常");
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                LOG.info("json类型的写入文件后关闭FileOutputStream资源异常");
            }

            try {
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            } catch (IOException e) {
                LOG.info("json类型的写入文件后关闭OutputStreamWriter资源异常");
            }

            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                LOG.info("json类型的写入文件后关闭BufferedWriter资源异常");
            }
        }
    }

    /**
     * 判断文件是否存在且不存在时创建（如果存在判断下在该文件夹下，存在的时候删掉7天以上生成的文件）
     *
     * @param fileName          文件名
     * @param file              文件
     * @param filePath          文件路径
     * @param fileExtension     文件后缀名
     * @return     文件是否创建成功
     */
    private static boolean judgeFileExists(String fileName, File file, File filePath, String fileExtension) {
        Boolean successOperation = true;

        // 如果文件不存在，则新建一个
        if (!file.exists() && !filePath.exists()) {
            try {
                filePath.mkdirs();
                file = new File(filePath + "/" + fileName + fileExtension);
                file.createNewFile();
            } catch (IOException e) {
                successOperation = false;
                LOG.info(fileExtension + "类型的写入文件时创建文件夹异常");
            }
        }
        //如果存在也要判断下这个文件夹下是不是已经有超过存天数的文件
        else if (filePath.exists() && filePath.isDirectory()) {
            String[] files = filePath.list();
            if (files != null && files.length > 0) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                String todayTime = simpleDateFormat.format(new Date());

                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE, 1 - 7);
                String timeBeforeSixDay = simpleDateFormat.format(calendar.getTime());
                for (String fileInfo : files) {
                    String fileTemp = fileInfo.substring(0, 8);
                    //表示小于之前那个数值或者大于等于今天的数值都会删掉
                    if (todayTime.compareTo(fileTemp) <= 0 || timeBeforeSixDay.compareTo(fileTemp) > 0) {
                        File deleteFile = new File(filePath + "/" + fileInfo);
                        deleteFile.delete();
                    }
                }
                try {
                    file = new File(filePath + "/" + fileName + fileExtension);
                    file.createNewFile();
                } catch (IOException e) {
                    successOperation = false;
                    LOG.info(fileExtension + "类型的写入文件时创建文件夹异常");
                }
            }
        }
        return successOperation;
    }
}
