package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class WxopenQrcodejumpaddRequest {
    private String prefix;
    private String path;
    @JSONField(name = "open_version")
    @JsonProperty("open_version")
    private String openVersion;

    @JSONField(name = "debug_url")
    @JsonProperty("debug_url")
    private List<String> debugUrl;

    @JSONField(name = "is_edit")
    @JsonProperty("is_edit")
    private Integer edit;

}
