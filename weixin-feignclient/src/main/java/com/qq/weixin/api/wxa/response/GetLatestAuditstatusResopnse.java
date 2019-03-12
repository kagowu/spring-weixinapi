package com.qq.weixin.api.wxa.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class GetLatestAuditstatusResopnse extends BaseResponse {
    private String auditid;
    /**
     * 审核状态，其中0为审核成功，1为审核失败，2为审核中，3已撤回
     */
    private Integer status;
    /**
     * 当status=1，审核被拒绝时，返回的拒绝原因
     */
    private String reason;
    /**
     * 审核失败的小程序截图示例 （xxx yyy zzz是图片media_id，可通过获取永久素材接口 拉取截图内容）
     */
    @JSONField(name = "ScreenShot")
    @JsonProperty("ScreenShot")
    private String screenShot;
}
