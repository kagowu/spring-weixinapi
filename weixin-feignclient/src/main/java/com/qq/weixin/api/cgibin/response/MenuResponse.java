package com.qq.weixin.api.cgibin.response;

import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.cgibin.request.MenuCreateRequest;
import lombok.Data;

@Data
public class MenuResponse extends BaseResponse {
    private MenuCreateRequest menu;
}