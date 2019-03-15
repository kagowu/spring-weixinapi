package com.qq.weixin.api;

import lombok.Data;

import java.util.Date;

@Data
public class BaseResponse {
    /**
     * invaid register type hint:通过API注册的小程序才能使用该接口
     */
    public static final int _41003 = 41003;
    /**
     * can not access hint
     */
    public static final int _85075 = 85075;

    /**
     * 返回码类型参考
     *
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419318634&token=2dc40382b1879696f2d7c35d221d8844cae685fd&lang=}
     */
    private String errcode;
    private String errmsg;
}