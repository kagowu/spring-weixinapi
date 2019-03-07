package com.qq.weixin.api.sns.response;

import lombok.Data;

/**
 * @author gong.hua
 * 小程序解密包使用
 */
@Data
public class MpUserResponse {
    private String openId;
    private String nickname;
    private Integer gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
}