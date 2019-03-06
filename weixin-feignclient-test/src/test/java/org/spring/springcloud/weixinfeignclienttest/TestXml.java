package org.spring.springcloud.weixinfeignclienttest;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.xml.open.accept.AuthorizedAuthorizationEvent;
import com.qq.weixin.xml.open.accept.ComponentVerifyTicketAuthorizationEvent;
import com.qq.weixin.xml.util.JAXBUtils;
import lombok.val;
import org.junit.Test;

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

        val val2 = JAXBUtils.convertToJavaBean(xml, ComponentVerifyTicketAuthorizationEvent.class);
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
}
