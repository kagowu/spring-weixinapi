package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WxopenTemplateDelRequest {

    @JSONField(name = "template_id")
    @JsonProperty("template_id")
    private String templateId;
}
