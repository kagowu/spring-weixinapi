package com.qq.weixin.api.cgibin.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class WxverifyCheckwxverifynicknameResponse extends BaseResponse {
    @JSONField(name = "hit_condition")
    @JsonProperty("hit_condition")
    private String hitCondition;

    private String wording;
}