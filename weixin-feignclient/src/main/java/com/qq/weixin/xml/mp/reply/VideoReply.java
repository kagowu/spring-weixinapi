package com.qq.weixin.xml.mp.reply;

import com.qq.weixin.xml.mp.BaseReplyMsg;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 回复视频消息
 *
 * @author gong.hua
 */
@Getter
@Setter
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class VideoReply extends BaseReplyMsg {

    @XmlElement(name = "Video")
    private Video video;

    @Data
    @XmlRootElement(name = "Video")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Video {
        /**
         * 通过素材管理中的接口上传多媒体文件，得到的id。
         */
        @XmlElement(name = "MediaId")
        private String mediaId;
        /**
         * 消息标题
         */
        @XmlElement(name = "Title")
        private String title;
        /**
         * 消息描述
         */
        @XmlElement(name = "Description")
        private String description;
    }

    public VideoReply() {
        super("video");
    }


}
