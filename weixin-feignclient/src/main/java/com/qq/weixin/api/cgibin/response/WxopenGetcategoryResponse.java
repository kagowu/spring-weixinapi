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
public class WxopenGetcategoryResponse extends BaseResponse {

    private List<Category> categories;


    @Data
    public static class Category {
        private String first;

        @JSONField(name = "first_name")
        @JsonProperty("first_name")
        private String firstName;
        private String second;

        @JSONField(name = "second_name")
        @JsonProperty("second_name")
        private String secondName;

        @JSONField(name = "audit_status")
        @JsonProperty("audit_status")
        private Integer auditStatus;

        @JSONField(name = "audit_reason")
        @JsonProperty("audit_reason")
        private String auditReason;
    }

    private String limit;
    private String quota;
    @JSONField(name = "category_limit")
    @JsonProperty("category_limit")
    private String categoryLimit;


}