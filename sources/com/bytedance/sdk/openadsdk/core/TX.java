package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.component.embedapplog.IDefaultEncrypt;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class TX implements IDefaultEncrypt {
    private final PangleEncryptConstant.CryptDataScene pA;

    public TX(PangleEncryptConstant.CryptDataScene cryptDataScene) {
        this.pA = cryptDataScene;
    }

    @Override // com.bytedance.sdk.component.embedapplog.IDefaultEncrypt
    public JSONObject encrypt(JSONObject jSONObject, int i) {
        BF.pA(1, this.pA, i);
        return com.bytedance.sdk.component.utils.pA.pA(jSONObject);
    }
}
