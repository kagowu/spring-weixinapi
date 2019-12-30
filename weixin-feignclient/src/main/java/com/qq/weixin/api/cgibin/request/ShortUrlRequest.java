package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShortUrlRequest {

    private String action;

    @JSONField(name = "long_url")
    @JsonProperty("long_url")
    private String longUrl;
}
