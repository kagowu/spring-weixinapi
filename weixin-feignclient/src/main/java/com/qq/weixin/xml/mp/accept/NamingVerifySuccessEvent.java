package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 名称认证成功
 *
 * @author gong.hua
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class NamingVerifySuccessEvent extends BasicEvent {

    @XmlElement(name = "FailReason")
    private String failReason;

    @XmlElement(name = "FailTime")
    private Integer failTime;

    public NamingVerifySuccessEvent() {
        super("naming_verify_success");
    }
}
