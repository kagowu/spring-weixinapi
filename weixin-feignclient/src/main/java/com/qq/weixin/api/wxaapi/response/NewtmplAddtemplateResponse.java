package com.qq.weixin.api.wxaapi.response;

import com.qq.weixin.api.BaseResponse;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class NewtmplAddtemplateResponse extends BaseResponse {

    private String priTmplId;
}
