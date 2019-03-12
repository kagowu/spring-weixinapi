package com.qq.weixin.api;

import lombok.Data;

import java.util.Date;

@Data
public class BaseResponse {
    /**
     * 返回码类型参考
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419318634&token=2dc40382b1879696f2d7c35d221d8844cae685fd&lang=}
     */
    private String errcode;
    private String errmsg;
}