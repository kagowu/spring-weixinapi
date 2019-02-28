package com.qq.weixin.api.cgibin.response;

import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentApi_query_authResponse extends BaseResponse {
    private Authorization_info authorization_info;

    @Data
    public static class Authorization_info {
        private String authorizer_appid;
        private String authorizer_access_token;
        private Integer expires_in;
        private String authorizer_refresh_token;
        private Func_info[] func_info;
    }

    @Data
    public static class Func_info {
        private String[] funcscope_category;
    }


}