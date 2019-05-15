package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 年审通知
 *
 * @author gong.hua
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class AnnualRenewEvent extends BasicEvent {


    @XmlElement(name = "ExpiredTime")
    private String expiredTime;

    public AnnualRenewEvent() {
        super("annual_renew");
    }
}
