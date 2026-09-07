package com.bytedance.adsdk.ugeno.core;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class SGo {
    private JSONObject KZx;
    private SGo ML;
    private int Og;
    private SGo ZZv;
    private com.bytedance.adsdk.ugeno.Og.KZx pA;

    public com.bytedance.adsdk.ugeno.Og.KZx pA() {
        return this.pA;
    }

    public void pA(com.bytedance.adsdk.ugeno.Og.KZx kZx) {
        this.pA = kZx;
    }

    public int Og() {
        return this.Og;
    }

    public void pA(int i) {
        this.Og = i;
    }

    public JSONObject KZx() {
        return this.KZx;
    }

    public void pA(JSONObject jSONObject) {
        this.KZx = jSONObject;
    }

    public SGo ZZv() {
        return this.ZZv;
    }

    public void pA(SGo sGo) {
        this.ZZv = sGo;
    }

    public void Og(SGo sGo) {
        this.ML = sGo;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.pA + ", mEventType=" + this.Og + ", mEvent=" + this.KZx + AbstractJsonLexerKt.END_OBJ;
    }
}
