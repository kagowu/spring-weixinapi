package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author gong.hua
 * 文本消息
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class TextMsg extends BasicMsg {

    /**
     * 文本消息内容
     */
    @XmlElement(name = "Content")
    private String content;

    public TextMsg() {
        super("text");
    }
}
