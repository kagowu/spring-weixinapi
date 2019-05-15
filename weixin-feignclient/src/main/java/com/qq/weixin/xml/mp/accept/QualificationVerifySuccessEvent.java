package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 小程序名称设置回调
 *
 * @author gong.hua
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class QualificationVerifySuccessEvent extends BasicEvent {


    @XmlElement(name = "ExpiredTime")
    private String expiredTime;

    public QualificationVerifySuccessEvent() {
        super("qualification_verify_success");
    }
}
