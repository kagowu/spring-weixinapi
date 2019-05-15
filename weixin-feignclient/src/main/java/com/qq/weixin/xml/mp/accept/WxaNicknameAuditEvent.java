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
public class WxaNicknameAuditEvent extends BasicEvent {


    @XmlElement(name = "SuccTime")
    private String succTime;

    public WxaNicknameAuditEvent() {
        super("wxa_nickname_audit");
    }
}
