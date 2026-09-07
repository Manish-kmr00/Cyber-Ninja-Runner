package com.bytedance.adsdk.ugeno.ZZv.KZx;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.ZZv.JG;
import com.bytedance.adsdk.ugeno.ZZv.SD;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class pA {
    protected String JG;
    protected com.bytedance.adsdk.ugeno.ZZv.Og KZx;
    protected Map<String, String> ML;
    protected com.bytedance.adsdk.ugeno.Og.KZx Og;
    protected String SD;
    protected com.bytedance.adsdk.ugeno.ZZv.Og.pA ZZv;
    protected Context omh;
    protected SD pA;

    public abstract boolean pA(Object... objArr);

    public pA(Context context) {
        this.omh = context;
    }

    public void pA() {
        this.ZZv = this.KZx.pA();
        com.bytedance.adsdk.ugeno.ZZv.Og og = this.KZx;
        if (og == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.ZZv.Og.pA pAVarPA = og.pA();
        this.ZZv = pAVarPA;
        if (pAVarPA == null) {
            return;
        }
        this.ML = pAVarPA.KZx();
        this.JG = this.ZZv.Og();
        this.SD = this.ZZv.pA();
    }

    public String Og() {
        return this.JG;
    }

    public void pA(com.bytedance.adsdk.ugeno.Og.KZx kZx) {
        this.Og = kZx;
    }

    public void pA(com.bytedance.adsdk.ugeno.ZZv.Og og) {
        this.KZx = og;
    }

    public void pA(SD sd) {
        this.pA = sd;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.ZZv.KZx.pA$pA, reason: collision with other inner class name */
    public static class C0176pA {
        public static pA pA(Context context, com.bytedance.adsdk.ugeno.Og.KZx kZx, JSONObject jSONObject, JSONObject jSONObject2) {
            com.bytedance.adsdk.ugeno.ZZv.Og ogPA;
            com.bytedance.adsdk.ugeno.ZZv.Og.pA pAVarPA;
            if (kZx == null || jSONObject == null || (ogPA = com.bytedance.adsdk.ugeno.ZZv.Og.pA(jSONObject, jSONObject2)) == null || (pAVarPA = ogPA.pA()) == null) {
                return null;
            }
            if (TextUtils.equals(pAVarPA.pA(), "custom")) {
                Og og = new Og(context);
                og.pA(kZx);
                og.pA(ogPA);
                og.pA();
                return og;
            }
            com.bytedance.adsdk.ugeno.ZZv.KZx kZxPA = JG.pA(pAVarPA.Og());
            if (kZxPA == null) {
                return null;
            }
            pA pAVarPA2 = kZxPA.pA(context);
            pAVarPA2.pA(kZx);
            pAVarPA2.pA(ogPA);
            pAVarPA2.pA();
            return pAVarPA2;
        }
    }
}
