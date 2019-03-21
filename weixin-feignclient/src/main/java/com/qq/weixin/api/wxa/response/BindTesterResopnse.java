package com.qq.weixin.api.wxa.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

import java.util.List;

/**
 * @author gong.hua
 */
@Data
public class BindTesterResopnse extends BaseResponse {
    private String userstr;
}
