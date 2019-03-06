package com.qq.weixin.xml.open;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author gong.hua
 */
@Data
@XmlAccessorType(XmlAccessType.NONE)
public class BaseAuthorizationEvent {
    public static final String authorized = "authorized";
    public static final String component_verify_ticket = "component_verify_ticket";

    @XmlElement(name = "AppId")
    private String appId;

    @XmlElement(name = "CreateTime")
    private String createTime;

    @XmlElement(name = "InfoType")
    private String infoType;

    protected BaseAuthorizationEvent(String infoType) {
        setInfoType(infoType);
    }


}
