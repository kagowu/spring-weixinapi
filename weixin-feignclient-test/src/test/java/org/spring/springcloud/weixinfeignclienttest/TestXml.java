package org.spring.springcloud.weixinfeignclienttest;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.xml.mp.reply.ImageReply;
import com.qq.weixin.xml.mp.reply.NewsReply;
import com.qq.weixin.xml.mp.reply.TextReply;
import com.qq.weixin.xml.open.BaseAuthorizationEvent;
import com.qq.weixin.xml.open.accept.AuthorizedAuthorizationEvent;
import com.qq.weixin.xml.open.accept.ComponentVerifyTicketAuthorizationEvent;
import com.qq.weixin.xml.util.JAXBUtils;
import lombok.val;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

/**
 * @author gong.hua
 */
public class TestXml {
    @Test
    public void test1() {
        val val = new ComponentVerifyTicketAuthorizationEvent();
        val.setComponentVerifyTicket("ticket");
        String xml = JAXBUtils.convertToXml(val, true);
        System.err.println(xml);

        xml = "<xml><AppId><![CDATA[wxb5520b267480440f]]></AppId>\n" +
                "<CreateTime>1551865439</CreateTime>\n" +
                "<InfoType><![CDATA[component_verify_ticket]]></InfoType>\n" +
                "<ComponentVerifyTicket><![CDATA[ticket@@@_5d4K-QOuADQTyVlqzb_CIB2Ih-vmKkoJwWNDcVeLC-jTZq76caZfFSXk7rPTGaLhGNnkONcQZV09oyQZcAYhQ]]></ComponentVerifyTicket>\n" +
                "</xml> ";
        System.err.println(xml);

        ComponentVerifyTicketAuthorizationEvent val2 = JAXBUtils.convertToJavaBean(xml, ComponentVerifyTicketAuthorizationEvent.class);
        System.err.println(JSON.toJSONString(val2, true));

    }

    @Test
    public void test2() {
        val val = new AuthorizedAuthorizationEvent();
        val.setAuthorizationCode("code");

        String xml = JAXBUtils.convertToXml(val, true);
        System.err.println(xml);

        val val2 = JAXBUtils.convertToJavaBean(xml, AuthorizedAuthorizationEvent.class);
        System.err.println(JSON.toJSONString(val2, true));

    }

    @Test
    public void test3() {
        val val = new ImageReply();
        ImageReply.Image image = new ImageReply.Image();
        image.setMediaId("mediaId");
        val.setImage(image);
        val.setCreateTime(123);

        System.err.println(val.toString());


    }


    @Test
    public void test4() {
        val val = new NewsReply();
        NewsReply.Item item = new NewsReply.Item();
        item.setDescription("description");
        NewsReply.Item item1 = new NewsReply.Item();
        item1.setDescription("description");
        NewsReply.Item[] items = new NewsReply.Item[]{item, item1};
        NewsReply.Articles articles = new NewsReply.Articles();
        articles.setItems(Arrays.asList(items));
        val.setArticles(articles);
        val.setCreateTime(123);

        System.err.println(val.toString());
        System.err.println(JSON.toJSONString(val, true));


    }
}
