package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class AccountGetaccountbasicinfoResponse extends BaseResponse {
    private String appid;

    @JSONField(name = "account_type")
    @JsonProperty("account_type")
    private String accountType;

    @JSONField(name = "principal_type")
    @JsonProperty("principal_type")
    private String principalType;


    @JSONField(name = "principal_name")
    @JsonProperty("principal_name")
    private String principalName;


    @JSONField(name = "realname_status")
    @JsonProperty("realname_status")
    private Integer realnameStatus;

    @JSONField(name = "wx_verify_info")
    @JsonProperty("wx_verify_info")
    private WxVerifyInfo wxVerifyInfo;

    @Data
    public static class WxVerifyInfo {

        @JSONField(name = "qualification_verify")
        @JsonProperty("qualification_verify")
        private Integer qualificationVerify;

        @JSONField(name = "naming_verify")
        @JsonProperty("naming_verify")
        private Integer namingVerify;

        @JSONField(name = "annual_review")
        @JsonProperty("annual_review")
        private Integer annualReview;

        @JSONField(name = "annual_review_begin_time")
        @JsonProperty("annual_review_begin_time")
        private Integer annualReviewBeginTime;

        @JSONField(name = "annual_review_end_time")
        @JsonProperty("annual_review_end_time")
        private Integer annualReviewEndTime;
    }

    private SignatureInfo signatureInfo;

    @Data
    public static class SignatureInfo {
        private String signature;

        @JSONField(name = "modify_used_count")
        @JsonProperty("modify_used_count")
        private Integer modifyUsedCount;


        @JSONField(name = "modify_quota")
        @JsonProperty("modify_quota")
        private Integer modifyQuota;
    }

    private HeadImageInfo headImageInfo;

    @Data
    public static class HeadImageInfo{
        @JSONField(name = "head_image_url")
        @JsonProperty("head_image_url")
        private String headImageUrl;

        @JSONField(name = "modify_used_count")
        @JsonProperty("modify_used_count")
        private Integer modifyUsedCount;

        @JSONField(name = "modify_quota")
        @JsonProperty("modify_quota")
        private Integer modifyQuota;

    }

}
