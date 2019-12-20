package com.qq.weixin.api.wxaapi.response;

import com.qq.weixin.api.BaseResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class NewtmplGettemplateResponse extends BaseResponse {

    private List<DataBean> data;

    @Data
    public static class DataBean {

        private String priTmplId;
        private String title;
        private String content;
        private String example;
        private int type;
    }
}
