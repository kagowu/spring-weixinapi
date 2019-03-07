package com.qq.weixin.api.sns.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class UserinfoResponse extends BaseResponse {
    private Integer subscribe;
    private String openid;
    private String nickname;
    private Integer sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String headimgurl;
    @JSONField(name = "subscribe_time")
    @JsonProperty("subscribe_time")
    private Integer subscribeTime;
    private String[] privilege;
    private String unionid;
}