package com.qq.weixin.qyapi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QyBaseResponse {

    /**
     * 返回码
     */
    @JSONField(name = "errcode")
    @JsonProperty("errcode")
    private int errCode;

    /**
     * 对返回码的文本描述内容
     */
    @JSONField(name = "errmsg")
    @JsonProperty("errmsg")
    private String errMsg;
}
