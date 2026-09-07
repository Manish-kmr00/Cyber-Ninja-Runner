package com.bytedance.adsdk.pA.Og.Og.pA;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class SGo implements com.bytedance.adsdk.pA.Og.Og.pA {
    private com.bytedance.adsdk.pA.Og.pA.pA KZx;
    private String Og;
    private com.bytedance.adsdk.pA.Og.Og.pA[] pA;

    public SGo(String str) {
        this.Og = str;
    }

    public void pA(com.bytedance.adsdk.pA.Og.Og.pA[] pAVarArr) {
        this.pA = pAVarArr;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public Object pA(Map<String, JSONObject> map) {
        com.bytedance.adsdk.pA.Og.pA.pA pAVar = new com.bytedance.adsdk.pA.Og.pA.pA();
        this.KZx = pAVar;
        pAVar.pA(this.Og);
        Object[] objArr = new Object[this.pA.length];
        int i = 0;
        while (true) {
            com.bytedance.adsdk.pA.Og.Og.pA[] pAVarArr = this.pA;
            if (i < pAVarArr.length) {
                com.bytedance.adsdk.pA.Og.Og.pA pAVar2 = pAVarArr[i];
                if (pAVar2 != null) {
                    objArr[i] = pAVar2.pA(map);
                }
                i++;
            } else {
                this.KZx.pA(objArr);
                return com.bytedance.adsdk.pA.SD.pA(this.Og).pA(map.get("default_key"), objArr);
            }
        }
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public com.bytedance.adsdk.pA.Og.ZZv.ML pA() {
        return com.bytedance.adsdk.pA.Og.ZZv.Og.METHOD;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public String Og() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.Og).append("(");
        com.bytedance.adsdk.pA.Og.Og.pA[] pAVarArr = this.pA;
        if (pAVarArr != null && pAVarArr.length > 0) {
            int i = 0;
            while (true) {
                com.bytedance.adsdk.pA.Og.Og.pA[] pAVarArr2 = this.pA;
                if (i >= pAVarArr2.length) {
                    break;
                }
                sb.append(pAVarArr2[i].Og()).append(StringUtils.COMMA);
                i++;
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
