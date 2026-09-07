package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BF {
    private int KZx;
    private String Og;
    private int ZZv;
    private String pA;

    public void pA(String str) {
        this.pA = str;
    }

    public void Og(String str) {
        this.Og = str;
    }

    public void pA(int i) {
        this.KZx = i;
    }

    public void Og(int i) {
        this.ZZv = i;
    }

    public boolean pA() {
        return this.ZZv == 1;
    }

    public static BF pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        BF bf = new BF();
        try {
            bf.pA(jSONObject.optString("market_dpl", ""));
            bf.Og(jSONObject.optString("market_dpl_auto", ""));
            bf.pA(jSONObject.optInt("exec_type", 0));
            bf.Og(jSONObject.optInt("oem_vendor_type", 0));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("OemModel", th.getMessage());
        }
        return bf;
    }

    public String Og() {
        if (this.KZx == 2) {
            return this.Og;
        }
        return this.pA;
    }

    public JSONObject KZx() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.pA)) {
                jSONObject.put("market_dpl", this.pA);
            }
            if (!TextUtils.isEmpty(this.Og)) {
                jSONObject.put("market_dpl_auto", this.Og);
            }
            jSONObject.put("exec_type", this.KZx);
            jSONObject.put("oem_vendor_type", this.ZZv);
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("OemModel", th.getMessage());
            return null;
        }
    }
}
