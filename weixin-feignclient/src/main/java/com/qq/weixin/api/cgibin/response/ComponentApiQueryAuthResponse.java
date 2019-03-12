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
public class ComponentApiQueryAuthResponse extends BaseResponse {
    @JSONField(name = "authorization_info")
    @JsonProperty("authorization_info")
    private AuthorizationInfo authorizationInfo;

    @Data
    public static class AuthorizationInfo {
        @JSONField(name = "authorizer_appid")
        @JsonProperty("authorizer_appid")
        private String authorizerAppid;

        @JSONField(name = "authorizer_access_token")
        @JsonProperty("authorizer_access_token")
        private String authorizerAccessToken;

        @JSONField(name = "expires_in")
        @JsonProperty("expires_in")
        private Integer expiresIn;

        @JSONField(name = "authorizer_refresh_token")
        @JsonProperty("authorizer_refresh_token")
        private String authorizerRefreshToken;

        @JSONField(name = "func_info")
        @JsonProperty("func_info")
        private List<FuncInfo> funcInfos;
    }

    @Data
    public static class FuncInfo {
        @JSONField(name = "funcscope_category")
        @JsonProperty("funcscope_category")
        private FuncscopeCategory funcscopeCategory;

        @JSONField(name = "confirm_info")
        @JsonProperty("confirm_info")
        private ConfirmInfo confirmInfo;
    }

    @Data
    public static class FuncscopeCategory {
        private Integer id;
    }

    @Data
    public static class ConfirmInfo {
        @JSONField(name = "need_confirm")
        @JsonProperty("need_confirm")
        private Integer needConfirm;

        @JSONField(name = "already_confirm")
        @JsonProperty("already_confirm")
        private Integer alreadyConfirm;

        @JSONField(name = "can_confirm")
        @JsonProperty("can_confirm")
        private Integer canConfirm;
    }

}
