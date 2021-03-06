package main.java.test;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
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
        //Map<String, String> streamIdAndTopoNamesMap = Maps.newLinkedHashMap();
        //streamIdAndTopoNamesMap.put("123123123123", "业务路径1-1,业务路径1-2");
        //streamIdAndTopoNamesMap.put("765432345666", "业务路径2-1,业务路径2-2");
        //streamIdAndTopoNamesMap.put("765445654343", "业务路径3-1,业务路径3-2");
        //streamIdAndTopoNamesMap.put("454353234532", "业务路径4-1,业务路径4-2,业务路径4-3,业务路径4-4,4343434,344345345345,345345345345,3453523523,353523242,2342523452");
        ////streamIdAndTopoNamesMap.put("454353234532", "业务路径4-1,业务路径4-2");
        //streamIdAndTopoNamesMap.put("876578345432", "业务路径5-1,业务路径5-2");
        //streamIdAndTopoNamesMap.put("213432421234", "业务路径6-1,业务路径6-2");

        //导出文件的文件夹地址
        String exportDirectory = "/Users/zhuqiuping/test/topos.xls";
        InputStream inputStream = null;
        Map<String, String> topoNameByTwoSystem = Maps.newHashMap();
        try {
            inputStream = new FileInputStream(exportDirectory);
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            //获取xlsx里面的sheet页数，如果sheet页不是3个，就提示报错
            int sheetIndexNumber = workbook.getNumberOfSheets();
            if (sheetIndexNumber != 3) {
                throw new IOException("传入的excel的sheet页不足三个！");
            }
            HSSFSheet sheet = workbook.getSheetAt(2);
            if (sheet == null) {
                throw new IOException("传入的excel的第三个sheet页有误！");
            }
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                HSSFRow row = sheet.getRow(rowNum);
                System.out.println("row:"+ row);
                //被同步的路径名称
                HSSFCell firstCell = row.getCell(0);
                String firstValue = "";
                if (firstCell != null) {
                    firstValue = firstCell.getStringCellValue();
                }
                System.out.println(firstCell);
                //同步的路径名称
                HSSFCell secondCell = row.getCell(1);
                String secondValue = "";
                if (secondCell != null) {
                    secondValue = secondCell.getStringCellValue();
                }
                if (Strings.isNullOrEmpty(secondValue)) {
                    continue;
                }
                System.out.println(secondValue);
            }
        } catch (FileNotFoundException e) {
            //LOG.error("读取的xlsx文件不存在", e);
        } catch (IOException e) {
            //LOG.error(e.getMessage(), e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    //LOG.error("读取的xlsx文件中关闭输入流出现异常", e);
                }
            }
        }

        //导出的文件名上要包括导出的日期
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        //String fileName = simpleDateFormat.format(new Date()) + "=-+-_";
        //fileName = fileName.replace("?", " ");
        //fileName = fileName.replace("/", " ");
        //fileName = fileName.replace("*", " ");
        //fileName = fileName.replace("[", " ");
        //fileName = fileName.replace("]", " ");
        //switch (exportFileExtension) {
        //    case XLSX_FILE_EXTENSION:
        //        //导出xlsx可以分为有Response方式（网页请求，里面分为get请求和post请求两种方式）和无Response方式。
        //        writeXlsxNoResponse(exportDirectory, fileName, streamIdAndTopoNamesMap);
        //        break;
        //    case CSV_FILE_EXTENSION:
        //        writeCsv(exportDirectory, fileName, streamIdAndTopoNamesMap);
        //        break;
        //    default:
        //        Gson gson = new Gson();
        //        String json = gson.toJson(streamIdAndTopoNamesMap);
        //        writeJson(exportDirectory, fileName, json);
        //        break;
        //}
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
     *   此处为了适应4.2里面的报表导出excel支持图片，此处试下
     *
     *
     * @param path          文件路径
     * @param fileName      文件名
     * @param dataMap       数据集合
     */
    private static void writeXlsxResponseNew(String path, String fileName, Map<String, String> dataMap) {
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



           //URL url = ExportFileTest.class.getProtectionDomain().getCodeSource().getLocation();
           // String fileInfo = url.getPath();
           // System.out.println(fileInfo);
           // int index = path.indexOf("WEB-INF");
           // if (index == -1) {
           //     index = path.indexOf("classes");
           // }
           // if (index == -1) {
           //     index = path.indexOf("bin");
           // }
           //ServletContext context =

            //path = "/Users/zhuqiuping/java/IdeaWorkSpace/test/MySpringDemo/src/main";
           // System.out.println(fileInfo);
            //图片绝对路径   
            //String picFileName = URLDecoder.decode(path + "/pic/favicon-16x16.png", "utf-8");
            //System.out.println("picFileName-----" + fileInfo);
            //BufferedImage user_headImg = ImageIO.read(new File(picFileName));
            //ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            //ImageIO.write(user_headImg, "jpg", byteArrayOut);
            byte[] byteData = null;
            String filePathInfo = path + "ewewerewerwr";
            try {
                byteData = readInputStream(new FileInputStream(new File(filePathInfo)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            //sheet只能获取一个
            XSSFDrawing patriarch = sheet.createDrawingPatriarch();
            //设置图片的属性
            XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0,(short) 0, 0, (short) 1, 4);
            anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_DONT_RESIZE);
            //插入图片 
            patriarch.createPicture(anchor, workbook2007.addPicture(byteData, XSSFWorkbook.PICTURE_TYPE_JPEG));
            // 创建样式
            XSSFFont font = workbook2007.createFont();
            XSSFCellStyle headerStyle = workbook2007.createCellStyle();
            XSSFCellStyle cellStyle = workbook2007.createCellStyle();

            // 字体加粗
            font.setBold(true);
            // 设置长文本自动换行
            headerStyle.setWrapText(true);
            headerStyle.setFont(font);
            //设置填充数据的单元格自动换行
            cellStyle.setWrapText(true);
            // 创建表头
            XSSFRow headerRow = sheet.createRow(3);
            headerRow.setHeightInPoints(25f);

            XSSFCell termHeader = headerRow.createCell(0);
            termHeader.setCellValue("流ID");
            termHeader.setCellStyle(headerStyle);

            XSSFCell transCountHeader = headerRow.createCell(1);
            transCountHeader.setCellValue("路径名称");
            transCountHeader.setCellStyle(headerStyle);

            Set<String> keySet = dataMap.keySet();
            int i = 4;
            int firstColumnLength = 0, secondColumnLength = 0;

            for(String key : keySet) {
                // 创建行
                XSSFRow row = sheet.createRow(i++);
                int enterCnt = 0;
                //row.setHeightInPoints(20f);
                // 开始创建单元格并赋值
                XSSFCell termCell = row.createCell(0);
                //if(firstColumnLength < key.length()) {
                //    firstColumnLength = key.length();
                //}
                //int rwsTemp = row.getCell(0).toString().split("\r\n").length;
                //if (rwsTemp > enterCnt) {
                //    enterCnt = rwsTemp;
                //}

                termCell.setCellValue(key);
                termCell.setCellStyle(cellStyle);
                if(firstColumnLength < termCell.getStringCellValue().length()) {
                    firstColumnLength = termCell.getStringCellValue().length();
                }
                String value = dataMap.get(key);
                //if(secondColumnLength < value.length()) {
                //    secondColumnLength = value.length();
                //}
                XSSFCell countCell = row.createCell(1);

                countCell.setCellValue(value);
                countCell.setCellStyle(cellStyle);
                //rwsTemp = row.getCell(1).toString().split("\n").length;
                //System.out.println(rwsTemp);
                //if (rwsTemp > enterCnt) {
                //    enterCnt = rwsTemp;
                //}
                if(secondColumnLength < countCell.getStringCellValue().length()) {
                    secondColumnLength = countCell.getStringCellValue().length();
                }
                System.out.println(enterCnt);
                //增加行的高度以适应2行文本的高度,设置高度单位(像素)
                //row.setHeightInPoints((enterCnt * sheet.getDefaultRowHeightInPoints()));
            }

            //在列上加样式（第一列15个字符的长度，第二列70个字符的长度）
            //这种方法是手动设置列宽，因为poi导出excel只支持英文、数字列宽自适应（用sheet.AutoSizeColumn(i);如果出现中文就会出现列宽不足现象)
            sheet.setColumnWidth(1, 50 * 256);
            sheet.setColumnWidth(0, 20 * 256);
            //sheet.autoSizeColumn(0, true);
            //sheet.autoSizeColumn(1, true);

            XSSFSheet xssfSheet = workbook2007.createSheet("第二个");
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
            //设置填充数据的单元格自动换行
            cellStyle.setWrapText(true);
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
                int enterCnt = 0;
                //row.setHeightInPoints(20f);
                // 开始创建单元格并赋值
                XSSFCell termCell = row.createCell(0);
                //if(firstColumnLength < key.length()) {
                //    firstColumnLength = key.length();
                //}
                //int rwsTemp = row.getCell(0).toString().split("\r\n").length;
                //if (rwsTemp > enterCnt) {
                //    enterCnt = rwsTemp;
                //}

                termCell.setCellValue(key);
                termCell.setCellStyle(cellStyle);
                if(firstColumnLength < termCell.getStringCellValue().length()) {
                    firstColumnLength = termCell.getStringCellValue().length();
                }
                String value = dataMap.get(key);
                //if(secondColumnLength < value.length()) {
                //    secondColumnLength = value.length();
                //}
                XSSFCell countCell = row.createCell(1);

                countCell.setCellValue(value);
                countCell.setCellStyle(cellStyle);
                //rwsTemp = row.getCell(1).toString().split("\n").length;
                //System.out.println(rwsTemp);
                //if (rwsTemp > enterCnt) {
                //    enterCnt = rwsTemp;
                //}
                if(secondColumnLength < countCell.getStringCellValue().length()) {
                    secondColumnLength = countCell.getStringCellValue().length();
                }
                System.out.println(enterCnt);
                //增加行的高度以适应2行文本的高度,设置高度单位(像素)
                //row.setHeightInPoints((enterCnt * sheet.getDefaultRowHeightInPoints()));
            }

            //在列上加样式（第一列15个字符的长度，第二列70个字符的长度）
            //这种方法是手动设置列宽，因为poi导出excel只支持英文、数字列宽自适应（用sheet.AutoSizeColumn(i);如果出现中文就会出现列宽不足现象)
            sheet.setColumnWidth(1, 50 * 256);
            sheet.setColumnWidth(0, 20 * 256);
            //sheet.autoSizeColumn(0, true);
            //sheet.autoSizeColumn(1, true);

            XSSFSheet xssfSheet = workbook2007.createSheet("第二个");
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
    public static boolean judgeFileExists(String fileName, File file, File filePath, String fileExtension) {
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

    private static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }
}
