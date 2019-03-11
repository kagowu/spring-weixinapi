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
 * 回复音乐消息
 *
 * @author gong.hua
 */
@Getter
@Setter
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class MusicReply extends BaseReplyMsg {

    @XmlElement(name = "Music")
    private Music music;

    @Data
    @XmlRootElement(name = "Music")
    @XmlAccessorType(XmlAccessType.NONE)
    @AllArgsConstructor
    public static class Music {
        /**
         * 音乐标题
         */
        @XmlElement(name = "Title")
        private String title;
        /**
         * 音乐描述
         */
        @XmlElement(name = "Description")
        private String description;
        /**
         * 音乐链接
         */
        @XmlElement(name = "MusicURL")
        private String musicURL;
        /**
         * 语音格式，如amr，speex等
         */
        @XmlElement(name = "ThumbMediaId")
        private String thumbMediaId;
    }

    public MusicReply() {
        super("music");
    }


}
