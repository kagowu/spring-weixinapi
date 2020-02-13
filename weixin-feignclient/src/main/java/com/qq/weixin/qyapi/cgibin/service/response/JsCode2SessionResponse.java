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
public class JsCode2SessionResponse extends QyBaseResponse {

    /**
     * 用户所属企业的corpid
     */
    @JSONField(name = "corpid")
    @JsonProperty("corpid")
    private String corpId;

    /**
     * 用户在企业内的UserID
     * 如果该企业与第三方应用有授权关系时，返回明文UserId，否则返回密文UserId
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userId;

    /**
     * 会话密钥
     */
    @JSONField(name = "session_key")
    @JsonProperty("session_key")
    private String sessionKey;


}
