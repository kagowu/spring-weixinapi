package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * 名称认证成功
 *
 * @author gong.hua
 */
@Data
public class NamingVerifySuccessEvent extends BasicEvent {

    @XmlElement(name = "FailReason")
    private String failReason;

    @XmlElement(name = "FailTime")
    private Integer failTime;

    public NamingVerifySuccessEvent() {
        super("naming_verify_success");
    }
}
