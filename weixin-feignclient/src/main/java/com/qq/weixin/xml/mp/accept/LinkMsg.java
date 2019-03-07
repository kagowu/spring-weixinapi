package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 链接消息
 *
 * @author gong.hua
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class LinkMsg extends BasicMsg {

    /**
     * 消息标题
     */
    @XmlElement(name = "Title")
    private String title;
    /**
     * 消息描述
     */
    @XmlElement(name = "Description")
    private String description;
    /**
     * 消息链接
     */
    @XmlElement(name = "Url")
    private String url;

    public LinkMsg() {
        super("link");
    }
}
