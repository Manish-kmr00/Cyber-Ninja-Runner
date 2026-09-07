package com.bytedance.adsdk.pA;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class ZZv implements ML {
    @Override // com.bytedance.adsdk.pA.ML
    /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
    public Boolean pA(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return Boolean.FALSE;
        }
        try {
            Double.parseDouble(String.valueOf(objArr[0]));
            return Boolean.TRUE;
        } catch (NumberFormatException unused) {
            return Boolean.FALSE;
        }
    }
}
