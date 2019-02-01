package com.qq.weixin.api;

import lombok.Data;

import java.util.Date;

@Data
public class BaseResponse {
    private String errcode;
    private String errmsg;
    private Date createTime;
}