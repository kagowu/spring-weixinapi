package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class MessageCustomSendBaseRequest {
    /**
     * 第三方平台appid
     */
    private String touser;


    private String msgtype;


    protected MessageCustomSendBaseRequest(String msgtype) {
        this.msgtype = msgtype;
    }

    void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    /**
     * 发送文本消息
     */
    @Data
    public static class TextMessage extends MessageCustomSendBaseRequest {
        private Text text;

        public TextMessage() {
            super("text");
        }
    }

    @Data
    @AllArgsConstructor
    public static class Text {
        private String content;
    }

    @Data
    public static class ImageMessage extends MessageCustomSendBaseRequest {
        private Image image;

        public ImageMessage() {
            super("image");
        }
    }

    @Data
    @AllArgsConstructor
    public static class Image {
        @JSONField(name = "media_id")
        @JsonProperty("media_id")
        private String mediaId;
    }

    @Data

    public static class NewsMessage extends MessageCustomSendBaseRequest {
        private News news;

        public NewsMessage() {
            super("news");
        }
    }

    @Data
    @AllArgsConstructor
    public static class News{
        private List<Article> articles;
    }
    @Data
    @AllArgsConstructor
    public static class Article {
        private String title;
        private String description;
        private String url;
        private String picurl;
    }

    @Data
    public static class MiniprogrampageMessage extends MessageCustomSendBaseRequest {
        private Miniprogrampage miniprogrampage;

        public MiniprogrampageMessage() {
            super("miniprogrampage");
        }
    }

    @Data
    @AllArgsConstructor
    public static class Miniprogrampage {
        private String title;
        private String pagepath;
        private String url;
        @JSONField(name = "thumb_media_id")
        @JsonProperty("thumb_media_id")
        private String thumbMediaId;
    }
}
