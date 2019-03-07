package com.qq.weixin.api.cgibin.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MenuCreateRequest {
    /**
     * 一级菜单数组，个数应为1~3个
     */
    private List<Button> button;

    @Data
    @NoArgsConstructor
    public static class Button {

        /**
         * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
         *
         * @return
         */
        private String type;

        /**
         * 菜单标题，不超过16个字节，子菜单不超过60个字节
         */
        private String name;

        /**
         * 二级菜单数组，个数应为1~5个
         */
        @JSONField(name = "sub_button")
        @JsonProperty("sub_button")
        private List<Button> subButtons;

        /**
         * view、miniprogram类型必须
         * 网页 链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，不支持小程序的老版本客户端将打开本url
         */
        private String url;

        /**
         * miniprogram类型必须
         * 小程序的appid（仅认证公众号可配置）
         */
        private String appid;
        /**
         * miniprogram类型必须
         * 小程序的页面路径
         */
        private String pagepath;

        /**
         * click等点击类型必须
         * 菜单KEY值，用于消息接口推送，不超过128字节
         */
        private String key;

        /**
         * media_id类型和view_limited类型必须
         * 调用新增永久素材接口返回的合法media_id
         */
        @JSONField(name = "media_id")
        @JsonProperty("media_id")
        private String mediaId;

        protected Button(String type) {
            this.type = type;
        }

    }

    @Data
    public static class ViewButton extends Button {

        public ViewButton() {
            super("view");
        }

    }

    @Data
    public static class MiniprogramButton extends Button {
        public MiniprogramButton() {
            super("miniprogram");
        }

    }

    @Data
    public static class ClickButton extends Button {
        public ClickButton() {
            super("click");
        }

    }

    @Data
    public static class MediaIdButton extends Button {
        public MediaIdButton() {
            super("media_id");
        }


    }

    @Data
    public static class ViewLimitedButton extends Button {
        public ViewLimitedButton() {
            super("view_limited");
        }
    }
}