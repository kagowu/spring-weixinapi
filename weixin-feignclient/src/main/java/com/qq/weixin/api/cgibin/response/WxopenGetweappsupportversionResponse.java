package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class WxopenGetweappsupportversionResponse extends BaseResponse {

    @JSONField(name = "now_version")
    @JsonProperty("now_version")
    private String nowVersion;


    @JSONField(name = "uv_info")
    @JsonProperty("uv_info")
    private UvInfo uvInfo;

    @Data
    public static class UvInfo {
        private List<Item> items;
    }

    @Data
    public static class Item {
        private Integer percentage;
        private String version;
    }
}