package main.java.helpyanjun;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

/**
 * json转换为对象
 *
 * @author ZhuQiuPing
 *         on 2018/1/30
 */
public class JsonChangeModel {

    String jsonString = "{\n" +
            "  \"newsList\": [\n" +
            "    {\n" +
            "      \"date\": \"2017-06-29\", \n" +
            "      \"img\": \"http://suifang.oss-cn-beijing.aliyuncs.com/20170629110530\", \n" +
            "      \"newsId\": \"8\", \n" +
            "      \"author\": \"韩小沫\", \n" +
            "      \"intro\": \"关于口腔溃疡的小常识\n" +
            "\", \n" +
            "      \"title\": \"关于口腔溃疡的小常识\",\n" +
            "      \"name\": \"儿童口腔康小常识\"\n" +
            "    }, \n" +
            "    {\n" +
            "      \"date\": \"2017-06-29\", \n" +
            "      \"img\": \"http://suifang.oss-cn-beijing.aliyuncs.com/20170629110318\", \n" +
            "      \"newsId\": \"7\", \n" +
            "      \"author\": \"韩小沫\", \n" +
            "      \"intro\": \"随着单独二孩政策的颁布，中国又掀起了新一波的新生儿潮，随之而来的婴幼儿口腔问题也越来越多的困扰到了年轻父母，据不完全统计，在中国三岁及三岁以下的婴幼儿大约有66%患有口腔问题，在世界范围内都属于高发龋国家。\", \n" +
            "      \"title\": \"儿童口腔健康小常识\", \n" +
            "      \"name\": \"儿童口腔康小常识\"\n" +
            "    }\n" +
            "  ], \n" +
            "  \"totalCount\": 2\n" +
            "}";

    @Test
    public void testOne() {
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        News news = JSON.toJavaObject(jsonObject, News.class);
        System.out.println(news);
    }

    @Test
    public void testTwo() {
        //Map<String, Object> map = (Map) JSONObject.to(JSONObject
        //        .fromObject(jsonString), Map.class);
        //for (Map.Entry<String, Object> entry : map.entrySet()) {
        //    System.out.println(entry.getKey() + " " + entry.getValue());
        //}
    }
}

class News {
    private List<Simple> newsList;
    private String totalCount;

    public List<Simple> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<Simple> newsList) {
        this.newsList = newsList;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsList=" + newsList +
                ", totalCount='" + totalCount + '\'' +
                '}';
    }
}

class Simple {
    private Date date;
    private String img;
    private String newsId;
    private String author;
    private String intro;
    private String title;
    private String name;

    public Simple() {
    }

    public Simple(Date date, String img, String newsId, String author, String intro, String title, String name) {
        this.date = date;
        this.img = img;
        this.newsId = newsId;
        this.author = author;
        this.intro = intro;
        this.title = title;
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "date=" + date +
                ", img='" + img + '\'' +
                ", newsId='" + newsId + '\'' +
                ", author='" + author + '\'' +
                ", intro='" + intro + '\'' +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}