package com.qq.weixin.api.wxa.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class CommitRequest {
    @JSONField(name = "template_id")
    @JsonProperty("template_id")
    private Integer templateId;

    @JSONField(name = "ext_json")
    @JsonProperty("ext_json")
    private String extJson;

    @JSONField(name = "user_version")
    @JsonProperty("user_version")
    private String userVersion;

    @JSONField(name = "user_desc")
    @JsonProperty("user_desc")
    private String userDesc;
}
