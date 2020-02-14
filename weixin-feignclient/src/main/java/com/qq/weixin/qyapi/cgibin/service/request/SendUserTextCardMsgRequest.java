package com.qq.weixin.qyapi.cgibin.service.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 文本卡片消息
 */
@Data
@NoArgsConstructor
public class SendUserTextCardMsgRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * touser	否	成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送
     * toparty	否	部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     * totag	否	标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     * msgtype	是	消息类型，此时固定为：textcard
     * agentid	是	企业应用的id，整型。企业内部开发，可在应用的设置页面查看；第三方服务商，可通过接口 获取企业授权信息 获取该参数值
     * title	是	标题，不超过128个字节，超过会自动截断（支持id转译）
     * description	是	描述，不超过512个字节，超过会自动截断（支持id转译）
     * url	是	点击后跳转的链接。
     * btntxt	否	按钮文字。 默认为“详情”， 不超过4个文字，超过自动截断。
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

    @JSONField(name = "agentid")
    @JsonProperty("agentid")
    private Integer agentId;

    @JSONField(name = "enable_id_trans")
    @JsonProperty("enable_id_trans")
    private Integer enableIdTrans;

    @JSONField(name = "enable_duplicate_chec")
    @JsonProperty("enable_duplicate_chec")
    private Integer enableDuplicateChec;

    @JSONField(name = "textcard")
    @JsonProperty("textcard")
    private TextCard textCard;


    @Data
    @NoArgsConstructor
    public class TextCard {

        @JSONField(name = "title")
        @JsonProperty("title")
        private String title;

        @JSONField(name = "description")
        @JsonProperty("description")
        private String description;

        @JSONField(name = "url")
        @JsonProperty("url")
        private String url;

        @JSONField(name = "btntxt")
        @JsonProperty("btntxt")
        private String btntxt;

    }

}
