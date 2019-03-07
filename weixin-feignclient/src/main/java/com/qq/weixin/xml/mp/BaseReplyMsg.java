package com.qq.weixin.xml.mp;

import com.qq.weixin.xml.util.JAXBUtils;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 被动回复用户消息基类
 * 这些消息需要解析出来
 *
 * @author gong.hua
 * @see com.qq.weixin.xml.util.JAXBUtils#convertToXml(Object)
 */
@Data
@XmlAccessorType(XmlAccessType.NONE)
public class BaseReplyMsg {
    /**
     * 接收方帐号（收到的OpenID）
     */
    @XmlElement(name = "ToUserName")
    private String toUserName;

    /**
     * 开发者微信号
     */
    @XmlElement(name = "FromUserName")
    private String fromUserName;

    /**
     * 消息创建时间 （整型）
     */
    @XmlElement(name = "CreateTime")
    private Integer createTime;

    /**
     * 消息类型
     */
    @XmlElement(name = "MsgType")
    private String msgType;

    protected BaseReplyMsg(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public String toString() {
        return JAXBUtils.convertToXml(this);
    }

}
