package com.qq.weixin.xml.mp.accept;

import com.qq.weixin.xml.mp.BaseAcceptMsg;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 关注事件
 *
 * @author gong.hua
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class SubscribeEvent extends BasicEvent {

    public SubscribeEvent() {
        super("subscribe");
    }
}
