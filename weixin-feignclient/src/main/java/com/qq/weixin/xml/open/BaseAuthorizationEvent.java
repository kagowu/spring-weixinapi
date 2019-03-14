package com.qq.weixin.xml.open;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author gong.hua
 * @see com.qq.weixin.xml.util.JAXBUtils#convertToJavaBean(String, Class)
 */
@Data
@XmlAccessorType(XmlAccessType.NONE)
public class BaseAuthorizationEvent {
    /**
     * 授权成功通知
     */
    public static final String AUTHORIZED = "authorized";
    /**
     * 取消授权通知
     */
    public static final String UNAUTHORIZED = "unauthorized";
    /**
     * 注册审核事件
     */
    public static final String NOTIFY_THIRD_FASTEREGISTER = "notify_third_fasteregister";
    /**
     * component_verify_ticket协议
     */
    public static final String COMPONENT_VERIFY_TICKET = "component_verify_ticket";
    /**
     * 授权更新通知
     */
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
