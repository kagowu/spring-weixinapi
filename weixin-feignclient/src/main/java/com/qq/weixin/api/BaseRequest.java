package com.qq.weixin.api;

import com.alibaba.fastjson.JSONObject;


/**
 * @author gong.hua
 */
public class BaseRequest extends JSONObject {
    public static BaseRequest fromJSONObject(JSONObject jsonObject) {
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.putAll(jsonObject);
        return baseRequest;
    }
}
