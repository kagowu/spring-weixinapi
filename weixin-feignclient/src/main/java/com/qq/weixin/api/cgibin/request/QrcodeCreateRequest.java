package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class QrcodeCreateRequest {

    @JSONField(name = "expire_seconds")
    @JsonProperty("expire_seconds")
    private int expireSeconds;

    @JSONField(name = "action_name")
    @JsonProperty("action_name")
    private String actionName;

    @JSONField(name = "action_info")
    @JsonProperty("action_info")
    private ActionInfo actionInfo;

    @Data
    public static class ActionInfo {
        private Scene scene;
    }

    @Data
    public static class Scene {
        @JSONField(name = "scene_id")
        @JsonProperty("scene_id")
        private int sceneId;

        @JSONField(name = "scene_str")
        @JsonProperty("scene_str")
        private String sceneStr;

    }
}
