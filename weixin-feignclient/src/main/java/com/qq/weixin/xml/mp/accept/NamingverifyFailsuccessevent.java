package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * 名称认证失败
 *
 * @author gong.hua
 */
@Data
public class NamingverifyFailsuccessevent extends BasicEvent {


    @XmlElement(name = "ExpiredTime")
    private String expiredTime;

    public NamingverifyFailsuccessevent() {
        super("naming_verify_fail");
    }
}
