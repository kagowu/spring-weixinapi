package com.qq.weixin.api.cgibin.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentApi_get_authorizer_infoResponse extends BaseResponse {
    private Authorizer_info authorizer_info;

    @Data
    public static class Authorizer_info {
        private String nick_name;
        private String head_img;
        private Type_info service_type_info;
        private Type_info verify_type_info;
        /**
         * 授权方公众号的原始ID :gh_eb5e3a772040
         */
        private String user_name;
        /**
         * 公众号的主体名称:XX计算机系统有限公司
         */
        private String principal_name;
        private Business_info business_info;
        // 小程序专用开始--

        private String qrcode_url;

        @JsonProperty("MiniProgramInfo")
        private MiniProgramInfo MiniProgramInfo;
        // --小程序专用结束

        private String signature;

        private Authorization_info authorization_info;

        @JsonIgnore
        public ComponentApi_get_authorizer_infoResponse.MiniProgramInfo getMiniProgramInfo() {
            return MiniProgramInfo;
        }

        @JsonIgnore
        public void setMiniProgramInfo(ComponentApi_get_authorizer_infoResponse.MiniProgramInfo miniProgramInfo) {
            MiniProgramInfo = miniProgramInfo;
        }
    }

    @Data
    public static class Type_info {
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
    public static class Business_info {
        private Integer open_store;
        private Integer open_scan;
        private Integer open_pay;
        private Integer open_card;
        private Integer open_shake;
    }

    @Data
    public static class Authorization_info {
        private String authorization_appid;

        private Func_info[] func_info;
    }

    @Data
    public static class Func_info {
        private String[] funcscope_category;
    }

    @Data
    public static class MiniProgramInfo {
        private Network network;
        private Categorie[] categories;
        private Integer visit_status;

    }

    @Data
    public static class Network {
        @JsonProperty("RequestDomain")
        private String[] RequestDomain;
        @JsonProperty("WsRequestDomain")
        private String[] WsRequestDomain;
        @JsonProperty("UploadDomain")
        private String[] UploadDomain;
        @JsonProperty("DownloadDomain")
        private String[] DownloadDomain;

//        @JsonIgnore
//        public String[] getRequestDomain() {
//            return RequestDomain;
//        }
//
//        @JsonIgnore
//        public void setRequestDomain(String[] requestDomain) {
//            RequestDomain = requestDomain;
//        }
//
//        @JsonIgnore
//        public String[] getWsRequestDomain() {
//            return WsRequestDomain;
//        }
//
//        @JsonIgnore
//        public void setWsRequestDomain(String[] wsRequestDomain) {
//            WsRequestDomain = wsRequestDomain;
//        }
//
//        @JsonIgnore
//        public String[] getUploadDomain() {
//            return UploadDomain;
//        }
//
//        @JsonIgnore
//        public void setUploadDomain(String[] uploadDomain) {
//            UploadDomain = uploadDomain;
//        }
//
//        @JsonIgnore
//        public String[] getDownloadDomain() {
//            return DownloadDomain;
//        }
//
////        @JsonIgnore
//        public void setDownloadDomain(String[] downloadDomain) {
//            DownloadDomain = downloadDomain;
//        }


    }

    @Data
    public static class Categorie {
        private String first;
        private String second;
    }


}
