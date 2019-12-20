package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@Accessors(chain = true)
public class MessageSubscribeSendRequest {

    @JSONField(name = "touser")
    @JsonProperty("touser")
    private String toUser;


    @JSONField(name = "template_id")
    @JsonProperty("template_id")
    private String templateId;

    private String page;

    @JSONField(name = "emphasis_keyword")
    @JsonProperty("emphasis_keyword")
    private String emphasisKeyword;

    private Map<String, KeywordBean> data;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class KeywordBean {
        private String value;
    }
}
