package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class QrcodeCreateResponse extends BaseResponse {
    private String ticket;
    @JSONField(name = "expire_seconds")
    @JsonProperty("expire_seconds")
    private Integer expireSeconds;
    private String url;
}