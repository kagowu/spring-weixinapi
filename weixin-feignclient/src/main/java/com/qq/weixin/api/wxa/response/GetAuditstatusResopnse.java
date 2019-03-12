package com.qq.weixin.api.wxa.response;

import com.qq.weixin.api.BaseResponse;
import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class GetAuditstatusResopnse extends BaseResponse {
    /**
     * 审核状态，其中0为审核成功，1为审核失败，2为审核中，3已撤回
     */
    private Integer status;
    /**
     * 当status=1，审核被拒绝时，返回的拒绝原因
     */
    private String reason;
    /**
     * 当status=1，审核被拒绝时，会返回审核失败的小程序截图示例。 xxx丨yyy丨zzz是media_id可通过获取永久素材接口 拉取截图内容）
     */
    private String screenshot;
}
