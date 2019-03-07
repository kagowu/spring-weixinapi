package com.qq.weixin.xml.mp.reply;

import com.qq.weixin.xml.mp.BaseReplyMsg;
import com.qq.weixin.xml.util.JAXBUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 回复文本消息
 *
 * @author gong.hua
 */
@Getter
@Setter
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class TextReply extends BaseReplyMsg {
    /**
     * 文本消息内容
     */
    @XmlElement(name = "Content")
    private String content;

    public TextReply() {
        super("text");
    }
    @Override
    public String toString() {
        return JAXBUtils.convertToXml(this);
    }
}
