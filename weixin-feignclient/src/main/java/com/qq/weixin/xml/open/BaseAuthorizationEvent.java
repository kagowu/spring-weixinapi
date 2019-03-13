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
    public static final String AUTHORIZED = "authorized";
    public static final String UNAUTHORIZED = "unauthorized";
    public static final String NOTIFY_THIRD_FASTEREGISTER = "notify_third_fasteregister";
    public static final String COMPONENT_VERIFY_TICKET = "component_verify_ticket";
    public static final String UPDATEAUTHORIZED = "updateauthorized";

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
