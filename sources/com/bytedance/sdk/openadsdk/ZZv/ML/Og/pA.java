package com.bytedance.sdk.openadsdk.ZZv.ML.Og;

import com.bytedance.sdk.openadsdk.ZZv.ML.Og.KZx;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class pA<T extends KZx> {
    private JSONObject KZx;
    private boolean ML = false;
    private String Og;
    private T ZZv;
    private yFO pA;

    public pA(yFO yfo, String str, JSONObject jSONObject, T t) {
        this.pA = yfo;
        this.Og = str;
        this.KZx = jSONObject;
        this.ZZv = t;
    }

    public yFO pA() {
        return this.pA;
    }

    public String Og() {
        return this.Og;
    }

    public JSONObject KZx() {
        if (this.KZx == null) {
            this.KZx = new JSONObject();
        }
        return this.KZx;
    }

    public T ZZv() {
        return this.ZZv;
    }

    public boolean ML() {
        return this.ML;
    }

    public void pA(boolean z) {
        this.ML = z;
    }
}
