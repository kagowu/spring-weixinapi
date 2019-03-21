package com.qq.weixin.api.wxa.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gong.hua
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddnearbypoiRequest {
    @JSONField(name = "related_name")
    @JsonProperty("related_name")
    private String relatedName;

    @JSONField(name = "related_credential")
    @JsonProperty("related_credential")
    private String relatedCredential;

    @JSONField(name = "related_address")
    @JsonProperty("related_address")
    private String relatedAddress;

    @JSONField(name = "related_proof_material")
    @JsonProperty("related_proof_material")
    private String relatedProofMaterial;
}
