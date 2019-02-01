package com.qq.weixin.api.cgibin.response;

import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.cgibin.request.MenuButtonsRequest;
import lombok.Data;

@Data
public class MenuResponse extends BaseResponse {
    private MenuButtonsRequest menu;
}