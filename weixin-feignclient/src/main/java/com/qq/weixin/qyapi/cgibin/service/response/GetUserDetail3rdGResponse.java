package com.qq.weixin.qyapi.cgibin.service.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.qyapi.QyBaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetUserDetail3rdGResponse extends QyBaseResponse {

    @JSONField(name = "corpid")
    @JsonProperty("corpid")
    private String corpId;

    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userId;

    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;

    @JSONField(name = "gender")
    @JsonProperty("gender")
    private String gender;

    @JSONField(name = "avatar")
    @JsonProperty("avatar")
    private String avatar;

    @JSONField(name = "qr_code")
    @JsonProperty("qr_code")
    private String qrCode;
}
