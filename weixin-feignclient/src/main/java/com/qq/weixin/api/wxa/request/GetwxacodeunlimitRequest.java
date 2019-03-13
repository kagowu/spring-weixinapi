package com.qq.weixin.api.wxa.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class GetwxacodeunlimitRequest {
    private String scene;
    private String page;
    private Integer width;
    @JSONField(name = "auto_color")
    @JsonProperty("auto_color")
    private boolean autoColor;
    @JSONField(name = "line_color")
    @JsonProperty("line_color")
    private LineColor lineColor;
    @JSONField(name = "is_hyaline")
    @JsonProperty("is_hyaline")
    private boolean hyaline;

    @Data
    public static class LineColor {
        private String r;
        private String g;
        private String b;
    }
}
