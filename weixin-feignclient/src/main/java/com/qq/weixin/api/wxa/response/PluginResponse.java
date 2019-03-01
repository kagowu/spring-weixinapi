package com.qq.weixin.api.wxa.response;

import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class PluginResponse extends BaseResponse {
    private Plugin[] plugin_list;

    @Data
    public static class Plugin {
        private String appid;
        private Integer status;
        private String nickname;
        private String headimgurl;
    }
}
