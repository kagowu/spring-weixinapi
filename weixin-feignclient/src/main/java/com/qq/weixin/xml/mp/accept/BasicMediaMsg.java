package com.qq.weixin.xml.mp.accept;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * 普通消息
 *
 * @author gong.hua
 * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140453}
 */
@Data
public class BasicMediaMsg extends BasicMsg {
    /**
     * 多媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @XmlElement(name = "MediaId")
    private String mediaId;

    protected BasicMediaMsg(String msgType) {
        super(msgType);
    }
}
