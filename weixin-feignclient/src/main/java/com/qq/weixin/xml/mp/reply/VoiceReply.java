package com.qq.weixin.xml.mp.reply;

import com.qq.weixin.xml.mp.BaseReplyMsg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 回复语音消息
 *
 * @author gong.hua
 */
@Getter
@Setter
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class VoiceReply extends BaseReplyMsg {

    @XmlElement(name = "Voice")
    private Voice voice;

    @Data
    @XmlRootElement(name = "Voice")
    @XmlAccessorType(XmlAccessType.NONE)
    @AllArgsConstructor
    public static class Voice {
        /**
         * 通过素材管理中的接口上传多媒体文件，得到的id。
         */
        @XmlElement(name = "MediaId")
        private String mediaId;
    }

    public VoiceReply() {
        super("voice");
    }


}
