package com.qq.weixin.api.wxa.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class GettemplatelistResopnse extends BaseResponse {
    @JSONField(name = "template_list")
    @JsonProperty("template_list")
    private List<Template> templateList;

    @Data
    public static class Template {
        @JSONField(name = "create_time")
        @JsonProperty("create_time")
        private Integer createTime;
        @JSONField(name = "user_version")
        @JsonProperty("user_version")
        private String userVersion;
        @JSONField(name = "user_desc")
        @JsonProperty("user_desc")
        private String userDesc;
        @JSONField(name = "template_id")
        @JsonProperty("template_id")
        private Integer templateId;
    }

}
