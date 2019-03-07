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

    private Integer subscribe;
    private String openid;
    private String nickname;
    private String sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String headimgurl;

    @JSONField(name = "subscribe_time")
    @JsonProperty("subscribe_time")
    private Integer subscribeTime;
    private String unionid;
    private String remark;
    private Integer groupid;

    @JSONField(name = "tagid_list")
    @JsonProperty("tagid_list")
    private Integer[] tagidList;

    @JSONField(name = "subscribe_scene")
    @JsonProperty("subscribe_scene")
    private String subscribeScene;

    @JSONField(name = "qr_scene")
    @JsonProperty("qr_scene")
    private Integer qrScene;

    @JSONField(name = "qr_scene_str")
    @JsonProperty("qr_scene_str")
    private String qrSceneStr;
}