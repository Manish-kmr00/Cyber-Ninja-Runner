package com.bytedance.adsdk.ugeno.pA.pA;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public abstract class pA {
    private String KZx;
    protected com.bytedance.adsdk.ugeno.Og.KZx Og;
    protected JSONObject pA;

    public abstract List<PropertyValuesHolder> KZx();

    public abstract void Og();

    public abstract void pA(int i, int i2);

    public abstract void pA(Canvas canvas);

    public pA(com.bytedance.adsdk.ugeno.Og.KZx kZx, JSONObject jSONObject) {
        this.pA = jSONObject;
        this.Og = kZx;
        pA();
    }

    public void pA() {
        this.KZx = this.pA.optString("type");
        Og();
    }

    public String ZZv() {
        return this.KZx;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.pA.pA.pA$pA, reason: collision with other inner class name */
    public static class C0182pA {
        public static pA pA(com.bytedance.adsdk.ugeno.Og.KZx kZx, JSONObject jSONObject) {
            if (kZx == null || jSONObject == null) {
                return null;
            }
            String strOptString = jSONObject.optString("type");
            strOptString.hashCode();
            switch (strOptString) {
                case "stretch":
                    return new ML(kZx, jSONObject);
                case "ripple":
                    return new Og(kZx, jSONObject);
                case "rub_in":
                    return new KZx(kZx, jSONObject);
                case "shine":
                    return new ZZv(kZx, jSONObject);
                default:
                    return null;
            }
        }
    }
}
