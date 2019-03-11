package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class UnionUserInfoResponse extends BaseResponse {

    /**
     * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
     */
    private Integer subscribe;
    private String openid;
    private String nickname;
    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private Integer sex;
    private String language;
    private String city;
    private String province;
    private String country;
    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。
     * 若用户更换头像，原有头像URL将失效。
     */
    private String headimgurl;

    @JSONField(name = "subscribe_time")
    @JsonProperty("subscribe_time")
    private Integer subscribeTime;
    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    private String unionid;
    private String remark;
    private Integer groupid;

    /**
     * 用户被打上的标签ID列表
     */
    @JSONField(name = "tagid_list")
    @JsonProperty("tagid_list")
    private Integer[] tagidList;

    /**
     * subscribe_scene
     * 返回用户关注的渠道来源，
     * ADD_SCENE_SEARCH 公众号搜索，
     * ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，
     * ADD_SCENE_PROFILE_CARD 名片分享，
     * ADD_SCENE_QR_CODE 扫描二维码，
     * ADD_SCENEPROFILE LINK 图文页内名称点击，
     * ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，
     * ADD_SCENE_PAID 支付后关注，
     * ADD_SCENE_OTHERS 其他
     */
    @JSONField(name = "subscribe_scene")
    @JsonProperty("subscribe_scene")
    private String subscribeScene;

    /**
     * 二维码扫码场景（开发者自定义）
     */
    @JSONField(name = "qr_scene")
    @JsonProperty("qr_scene")
    private Integer qrScene;

    /**
     * 二维码扫码场景描述（开发者自定义）
     */
    @JSONField(name = "qr_scene_str")
    @JsonProperty("qr_scene_str")
    private String qrSceneStr;
}