package com.mzc.utils;

import com.mzc.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MaZhiCheng
 * @date 2021/7/16 - 22:52
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */


@Component
public class HtmlParseUtil {

    public static void main(String[] args) throws Exception {
        new HtmlParseUtil().parseJD("vue").forEach(System.out::println);

    }

    public  ArrayList<Content> parseJD(String keywords) throws Exception {
        //获取请求https://search.jd.com/Search?keyword=java
        //前提，需要联网，ajax数据不能获取到
        String url = "https://search.jd.com/Search?keyword="+keywords;
        //解析网页,返回的document就是js页面对象
        Document document = Jsoup.parse(new URL(url), 30000);
        //所有在js里面能用的方法在这里都能用
        Element element = document.getElementById("J_goodsList");
        //System.out.println(element.html());

        ArrayList<Content> goodslist = new ArrayList<>();

        //获取所有的li元素
        Elements elements = element.getElementsByTag("li");
        //获取元素中的内容，这里el就是每个li标签了
        for (Element el : elements) {
            //关于图片多的网站，图片一般都是懒加载的source-data-lazy-img
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            Content content = new Content();
            content.setImg(img);
            content.setPrice(price);
            content.setTitle(title);
            goodslist.add(content);
        }
        return goodslist;
    }
}
