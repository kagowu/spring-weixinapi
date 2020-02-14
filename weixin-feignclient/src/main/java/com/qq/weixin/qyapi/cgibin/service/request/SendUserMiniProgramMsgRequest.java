package com.qq.weixin.qyapi.cgibin.service.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 小程序通知消息
 */
@Data
@NoArgsConstructor
public class SendUserMiniProgramMsgRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * touser	否	成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）
     * toparty	否	部门ID列表，多个接收者用‘|’分隔，最多支持100个。
     * totag	否	标签ID列表，多个接收者用‘|’分隔，最多支持100个。
     * msgtype	是	消息类型，此时固定为：miniprogram_notice
     * appid	是	小程序appid，必须是与当前小程序应用关联的小程序
     * page	否	点击消息卡片后的小程序页面，仅限本小程序内的页面。该字段不填则消息点击后不跳转。
     * title	是	消息标题，长度限制4-12个汉字（支持id转译）
     * description	否	消息描述，长度限制4-12个汉字（支持id转译）
     * emphasis_first_item	否	是否放大第一个content_item
     * content_item	否	消息内容键值对，最多允许10个item
     * key	是	长度10个汉字以内
     * value	是	长度30个汉字以内（支持id转译）
     * enable_id_trans	否	表示是否开启id转译，0表示否，1表示是，默认0
     * enable_duplicate_check	否	表示是否开启重复消息检查，0表示否，1表示是，默认0
     * duplicate_check_interval	否	表示是否重复消息检查的时间间隔，默认1800s，最大不超过4小时
     */

    @JSONField(name = "touser")
    @JsonProperty("touser")
    private String toUser;

    @JSONField(name = "toparty")
    @JsonProperty("toparty")
    private String toParty;

    @JSONField(name = "totag")
    @JsonProperty("totag")
    private String toTag;

    @JSONField(name = "msgtype")
    @JsonProperty("msgtype")
    private String msgType;

    @JSONField(name = "enable_id_trans")
    @JsonProperty("enable_id_trans")
    private Integer enableIdTrans;

    @JSONField(name = "enable_duplicate_chec")
    @JsonProperty("enable_duplicate_chec")
    private Integer enableDuplicateChec;

    @JSONField(name = "miniprogram_notice")
    @JsonProperty("miniprogram_notice")
    private MiniProgramNotice miniProgramNotice;


    @Data
    @NoArgsConstructor
    public class MiniProgramNotice {

        @JSONField(name = "appid")
        @JsonProperty("appid")
        private String appId;

        @JSONField(name = "page")
        @JsonProperty("page")
        private String page;

        @JSONField(name = "title")
        @JsonProperty("title")
        private String title;

        @JSONField(name = "description")
        @JsonProperty("description")
        private String description;

        @JSONField(name = "emphasis_first_item")
        @JsonProperty("emphasis_first_item")
        private Boolean emphasisFirstItem;

        @JSONField(name = "content_item")
        @JsonProperty("content_item")
        private List<ContentItem> contentItem;


        @Data
        @NoArgsConstructor
        public class ContentItem {

            @JSONField(name = "key")
            @JsonProperty("key")
            private String key;

            @JSONField(name = "value")
            @JsonProperty("value")
            private String value;
        }
    }

}
