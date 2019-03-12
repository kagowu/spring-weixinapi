package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class ApiGetAuthorizerListResponse extends BaseResponse {
    @JSONField(name = "total_count")
    @JsonProperty("total_count")
    private Integer totalCount;

    private List<Info> list;

    @Data
    public static class Info{
        @JSONField(name = "authorizer_appid")
        @JsonProperty("authorizer_appid")
        private String authorizerAppid;
        @JSONField(name = "refresh_token")
        @JsonProperty("refresh_token")
        private String refreshToken;

        @JSONField(name = "auth_time")
        @JsonProperty("auth_time")
        private long authTime;
    }
}