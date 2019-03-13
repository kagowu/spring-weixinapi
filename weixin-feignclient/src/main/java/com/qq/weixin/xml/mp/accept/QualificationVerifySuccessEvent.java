package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * 小程序名称设置回调
 *
 * @author gong.hua
 */
@Data
public class QualificationVerifySuccessEvent extends BasicEvent {


    @XmlElement(name = "ExpiredTime")
    private String expiredTime;

    public QualificationVerifySuccessEvent() {
        super("qualification_verify_success");
    }
}
