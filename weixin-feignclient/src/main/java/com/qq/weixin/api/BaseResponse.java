package com.qq.weixin.api;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;

@Data
public class BaseResponse extends HashMap {
    private String errcode;
    private String errmsg;
    private Date createTime;
}