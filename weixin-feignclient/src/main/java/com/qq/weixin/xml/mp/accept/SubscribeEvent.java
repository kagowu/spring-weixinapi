package com.qq.weixin.xml.mp.accept;

import com.qq.weixin.xml.mp.BaseAcceptMsg;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * 关注事件
 *
 * @author gong.hua
 */
@Data
public class SubscribeEvent extends BasicEvent {

    public SubscribeEvent() {
        super("subscribe");
    }
}
