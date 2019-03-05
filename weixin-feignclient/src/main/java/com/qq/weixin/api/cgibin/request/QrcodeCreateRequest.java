package com.qq.weixin.api.cgibin.request;

import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class QrcodeCreateRequest {

    private int expire_seconds;

    private String action_name;

    private ActionInfo action_info;

    @Data
    public static class ActionInfo {
        private Scene scene;
    }

    @Data
    public static class Scene {
        private int scene_id;
        private String scene_str;

    }
}
