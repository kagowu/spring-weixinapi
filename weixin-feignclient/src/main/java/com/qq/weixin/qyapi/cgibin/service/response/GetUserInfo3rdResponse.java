package com.qq.weixin.qyapi.cgibin.service.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.qyapi.QyBaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetUserInfo3rdResponse extends QyBaseResponse {

    /**
     * 用户所属企业的corpid
     */
    @JSONField(name = "CorpId")
    @JsonProperty("CorpId")
    private String corpId;

    /**
     * 用户在企业内的UserID
     * 如果该企业与第三方应用有授权关系时，返回明文UserId，否则返回密文UserId
     */
    @JSONField(name = "UserId")
    @JsonProperty("UserId")
    private String userId;

    /**
     * 手机设备号
     * (由企业微信在安装时随机生成，删除重装会改变，升级不受影响)
     */
    @JSONField(name = "DeviceId")
    @JsonProperty("DeviceId")
    private String deviceId;

    /**
     * 成员票据
     * 最大为512字节。
     * scope为snsapi_userinfo或snsapi_privateinfo，且用户在应用可见范围之内时返回此参数。
     * 后续利用该参数可以获取用户信息或敏感信息，参见“第三方使用user_ticket获取成员详情”。
     */
    @JSONField(name = "user_ticket")
    @JsonProperty("user_ticket")
    private String userTicket;

    /**
     * user_ticket的有效时间（秒）
     * 随user_ticket一起返回
     */
    @JSONField(name = "expires_in")
    @JsonProperty("expires_in")
    private int expiresIn;

    /**
     * 非企业成员的标识，对当前服务商唯一
     */
    @JSONField(name = "OpenId")
    @JsonProperty("OpenId")
    private String openId;
}
