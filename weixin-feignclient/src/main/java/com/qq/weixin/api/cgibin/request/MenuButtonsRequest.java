package com.qq.weixin.api.cgibin.request;

import lombok.Data;

import java.util.List;

@Data
public class MenuButtonsRequest {
    /**
     * 一级菜单数组，个数应为1~3个
     */
    private MenuButtonsRequest.Button[] button;

    @Data
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
        private List<Button> sub_button;

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
        private String media_id;

    }

    @Data
    public static class ViewButton extends Button {

        @Override
        public String getType() {
            return "view";
        }
    }

    @Data
    public static class MiniprogramButton extends ViewButton {
        @Override
        public String getType() {
            return "miniprogram";
        }


    }

    @Data
    public static class ClickButton extends Button {
        @Override
        public String getType() {
            return "click";
        }


    }

    @Data
    public static class MediaIdButton extends Button {
        @Override
        public String getType() {
            return "media_id";
        }


    }

    @Data
    public static class ViewLimitedButton extends MediaIdButton {
        @Override
        public String getType() {
            return "view_limited";
        }
    }
}