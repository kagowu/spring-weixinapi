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
public class PluginResponse extends BaseResponse {
    @JSONField(name = "plugin_list")
    @JsonProperty("plugin_list")
    private List<Plugin> plugins;

    @Data
    public static class Plugin {
        private String appid;
        private Integer status;
        private String nickname;
        private String headimgurl;
    }
}
