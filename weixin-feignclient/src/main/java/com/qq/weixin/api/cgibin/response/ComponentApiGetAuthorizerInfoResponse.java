package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class ComponentApiGetAuthorizerInfoResponse extends BaseResponse {
    @JSONField(name = "authorizer_info")
    @JsonProperty("authorizer_info")
    private AuthorizerInfo authorizerInfo;

    @Data
    public static class AuthorizerInfo {
        @JSONField(name = "nick_name")
        @JsonProperty("nick_name")
        private String nickName;

        @JSONField(name = "head_img")
        @JsonProperty("head_img")
        private String headImg;

        @JSONField(name = "service_type_info")
        @JsonProperty("service_type_info")
        private TypeInfo serviceTypeInfo;

        @JSONField(name = "verify_type_info")
        @JsonProperty("verify_type_info")
        private TypeInfo verifyTypeInfo;
        /**
         * 授权方公众号的原始ID :gh_eb5e3a772040
         */
        @JSONField(name = "user_name")
        @JsonProperty("user_name")
        private String userName;
        /**
         * 公众号的主体名称:XX计算机系统有限公司
         */
        @JSONField(name = "business_info")
        @JsonProperty("business_info")
        private String principalName;

        @JSONField(name = "business_info")
        @JsonProperty("business_info")
        private BusinessInfo businessInfo;
        // 小程序专用开始--

        @JSONField(name = "qrcode_url")
        @JsonProperty("qrcode_url")
        private String qrcodeUrl;

        @JSONField(name = "MiniProgramInfo")
        @JsonProperty("MiniProgramInfo")
        private MiniProgramInfo miniProgramInfo;
        // --小程序专用结束

        private String signature;

        @JSONField(name = "authorization_info")
        @JsonProperty("authorization_info")
        private AuthorizationInfo authorizationInfo;

        @JsonIgnore
        public ComponentApiGetAuthorizerInfoResponse.MiniProgramInfo getMiniProgramInfo() {
            return miniProgramInfo;
        }

        @JsonIgnore
        public void setMiniProgramInfo(ComponentApiGetAuthorizerInfoResponse.MiniProgramInfo miniProgramInfo) {
            this.miniProgramInfo = miniProgramInfo;
        }
    }

    @Data
    public static class TypeInfo {
        private Integer id;
    }

    /**
     * 用以了解以下功能的开通状况（0代表未开通，1代表已开通）：
     * open_store:是否开通微信门店功能
     * open_scan:是否开通微信扫商品功能
     * open_pay:是否开通微信支付功能
     * open_card:是否开通微信卡券功能
     * open_shake:是否开通微信摇一摇功能
     */
    @Data
    public static class BusinessInfo {
        @JSONField(name = "open_store")
        @JsonProperty("open_store")
        private Integer openStore;

        @JSONField(name = "open_scan")
        @JsonProperty("open_scan")
        private Integer openScan;

        @JSONField(name = "open_pay")
        @JsonProperty("open_pay")
        private Integer openPay;

        @JSONField(name = "open_card")
        @JsonProperty("open_card")
        private Integer openCard;

        @JSONField(name = "open_shake")
        @JsonProperty("open_shake")
        private Integer openShake;
    }

    @Data
    public static class AuthorizationInfo {
        @JSONField(name = "authorization_appid")
        @JsonProperty("authorization_appid")
        private String authorizationAppid;

        @JSONField(name = "func_info")
        @JsonProperty("func_info")
        private List<FuncInfo> funcInfos;
    }

    @Data
    public static class FuncInfo {
        @JSONField(name = "funcscope_category")
        @JsonProperty("funcscope_category")
        private List<String> funcscopeCategory;
    }

    @Data
    public static class MiniProgramInfo {
        private Network network;
        private List<Categorie> categories;

        @JSONField(name = "visit_status")
        @JsonProperty("visit_status")
        private Integer visitStatus;

    }

    @Data
    public static class Network {
        @JSONField(name = "RequestDomain")
        @JsonProperty("RequestDomain")
        private List<String> requestDomain;

        @JSONField(name = "WsRequestDomain")
        @JsonProperty("WsRequestDomain")
        private List<String> wsRequestDomain;

        @JSONField(name = "UploadDomain")
        @JsonProperty("UploadDomain")
        private List<String> uploadDomain;

        @JSONField(name = "DownloadDomain")
        @JsonProperty("DownloadDomain")
        private List<String> downloadDomain;


    }

    @Data
    public static class Categorie {
        private String first;
        private String second;
    }


}
