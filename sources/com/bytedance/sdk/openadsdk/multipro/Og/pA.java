package com.bytedance.sdk.openadsdk.multipro.Og;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class pA {
    public long JG;
    public boolean KZx;
    public long ML;
    public boolean Og;
    public long SD;
    public boolean ZZv;
    public boolean pA;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.multipro.Og.pA$pA, reason: collision with other inner class name */
    public interface InterfaceC0252pA {
        pA JG();
    }

    public pA pA(boolean z) {
        this.ZZv = z;
        return this;
    }

    public pA Og(boolean z) {
        this.pA = z;
        return this;
    }

    public pA KZx(boolean z) {
        this.Og = z;
        return this;
    }

    public pA ZZv(boolean z) {
        this.KZx = z;
        return this;
    }

    public pA pA(long j) {
        this.ML = j;
        return this;
    }

    public pA Og(long j) {
        this.JG = j;
        return this;
    }

    public pA KZx(long j) {
        this.SD = j;
        return this;
    }

    public JSONObject pA() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.pA);
            jSONObject.put("isFromVideoDetailPage", this.Og);
            jSONObject.put("isFromDetailPage", this.KZx);
            jSONObject.put("duration", this.ML);
            jSONObject.put("totalPlayDuration", this.JG);
            jSONObject.put("currentPlayPosition", this.SD);
            jSONObject.put("isAutoPlay", this.ZZv);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static pA pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        pA pAVar = new pA();
        pAVar.Og(jSONObject.optBoolean("isCompleted"));
        pAVar.KZx(jSONObject.optBoolean("isFromVideoDetailPage"));
        pAVar.ZZv(jSONObject.optBoolean("isFromDetailPage"));
        pAVar.pA(jSONObject.optLong("duration"));
        pAVar.Og(jSONObject.optLong("totalPlayDuration"));
        pAVar.KZx(jSONObject.optLong("currentPlayPosition"));
        pAVar.pA(jSONObject.optBoolean("isAutoPlay"));
        return pAVar;
    }
}
