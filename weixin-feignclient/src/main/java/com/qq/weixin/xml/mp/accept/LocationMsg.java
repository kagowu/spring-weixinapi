package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 地理位置消息
 *
 * @author gong.hua
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class LocationMsg extends BasicMsg {


    @XmlElement(name = "Location_X")
    private String title;

    @XmlElement(name = "Location_Y")
    private String description;

    @XmlElement(name = "Scale")
    private String scale;

    @XmlElement(name = "Label")
    private String label;

    public LocationMsg() {
        super("location");
    }
}
