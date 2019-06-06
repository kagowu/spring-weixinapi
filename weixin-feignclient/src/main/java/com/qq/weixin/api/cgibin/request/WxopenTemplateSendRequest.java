package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WxopenTemplateSendRequest {

    @JSONField(name = "touser")
    @JsonProperty("touser")
    private String toUser;

    @JSONField(name = "form_id")
    @JsonProperty("form_id")
    private String formId;

    @JSONField(name = "template_id")
    @JsonProperty("template_id")
    private String templateId;

    private String page;

    @JSONField(name = "emphasis_keyword")
    @JsonProperty("emphasis_keyword")
    private String emphasisKeyword;

    private DataBean data;

    @Data
    @Accessors(chain = true)
    public static class DataBean {

        private KeywordBean keyword1;
        private KeywordBean keyword2;
        private KeywordBean keyword3;
        private KeywordBean keyword4;
        private KeywordBean keyword5;
        private KeywordBean keyword6;
        private KeywordBean keyword7;
        private KeywordBean keyword8;
        private KeywordBean keyword9;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class KeywordBean {
        private String value;
    }
}
