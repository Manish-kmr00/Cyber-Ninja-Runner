package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class omh {
    private JSONObject KZx;
    private JSONObject Og;
    private Map<String, Object> ZZv;
    private Context pA;

    public void pA(Context context) {
        this.pA = context;
    }

    public void pA(JSONObject jSONObject) {
        this.Og = jSONObject;
    }

    public JSONObject pA() {
        return this.KZx;
    }

    public void Og(JSONObject jSONObject) {
        this.KZx = jSONObject;
    }

    public Map<String, Object> Og() {
        return this.ZZv;
    }

    public void pA(Map<String, Object> map) {
        this.ZZv = map;
    }
}
