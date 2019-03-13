package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * 年审通知
 *
 * @author gong.hua
 */
@Data
public class AnnualRenewEvent extends BasicEvent {


    @XmlElement(name = "ExpiredTime")
    private String expiredTime;

    public AnnualRenewEvent() {
        super("annual_renew");
    }
}
