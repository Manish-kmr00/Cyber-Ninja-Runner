package com.bytedance.adsdk.ugeno.pA;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class Og {
    private pA JG;
    private int KZx;
    private long ML;
    private long Og;
    private String SD;
    private String ZZv;
    private JSONObject omh;
    private Map<String, TreeMap<Float, String>> pA;

    public static class pA {
        public String Og;
        public String pA;
    }

    public JSONObject pA() {
        return this.omh;
    }

    public void pA(JSONObject jSONObject) {
        this.omh = jSONObject;
    }

    public Map<String, TreeMap<Float, String>> Og() {
        return this.pA;
    }

    public void pA(Map<String, TreeMap<Float, String>> map) {
        this.pA = map;
    }

    public long KZx() {
        return this.Og;
    }

    public void pA(long j) {
        this.Og = j;
    }

    public int ZZv() {
        return this.KZx;
    }

    public void pA(int i) {
        this.KZx = i;
    }

    public String ML() {
        return this.ZZv;
    }

    public void pA(String str) {
        this.ZZv = str;
    }

    public long JG() {
        return this.ML;
    }

    public void Og(long j) {
        this.ML = j;
    }

    public pA SD() {
        return this.JG;
    }

    public void pA(pA pAVar) {
        this.JG = pAVar;
    }

    public String omh() {
        return this.SD;
    }

    public void Og(String str) {
        this.SD = str;
    }

    public String toString() {
        return "AnimationModel{mKeyFramesMap=" + this.pA + ", mDuration=" + this.Og + ", mPlayCount=" + this.KZx + ", mPlayDirection=" + this.ZZv + ", mDelay=" + this.ML + ", mTransformOrigin='" + this.JG + "', mTimingFunction='" + this.SD + "'}";
    }
}
