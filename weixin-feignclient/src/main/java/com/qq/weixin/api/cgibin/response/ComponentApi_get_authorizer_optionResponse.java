package com.qq.weixin.api.cgibin.response;

import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentApi_get_authorizer_optionResponse {
    private String component_appid;
    private String authorizer_appid;
    private String option_value;
}
