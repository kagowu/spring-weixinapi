package com.qq.weixin.xml.mp.accept;

import com.qq.weixin.xml.mp.BaseAcceptMsg;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * 普通消息
 *
 * @author gong.hua
 * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140453}
 */
@Data
public class BasicMsg extends BaseAcceptMsg {
    /**
     * 消息id，64位整型
     */
    @XmlElement(name = "MsgId")
    private String msgId;

    protected BasicMsg(String msgType) {
        super(msgType);
    }
}
