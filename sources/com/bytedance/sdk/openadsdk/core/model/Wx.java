package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class Wx {
    private final int KZx;
    private final int Og;
    private final int ZZv;
    private final int pA;

    public Wx(JSONObject jSONObject) {
        this.pA = jSONObject.optInt("auto_click", 0);
        this.Og = jSONObject.optInt("close_jump_probability", 0);
        this.KZx = jSONObject.optInt("skip_jump_probability", 0);
        this.ZZv = jSONObject.optInt("hidden_bar", 0);
    }

    public int pA() {
        return this.pA;
    }

    public int Og() {
        int i = this.Og;
        if (i < 0 || i > 100) {
            return 0;
        }
        return i;
    }

    public int KZx() {
        int i = this.KZx;
        if (i < 0 || i > 100) {
            return 0;
        }
        return i;
    }

    public boolean ZZv() {
        return this.ZZv == 1;
    }

    public JSONObject ML() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = this.pA;
            if (i == 1) {
                jSONObject.put("auto_click", i);
            }
            int i2 = this.Og;
            if (i2 > 0 && i2 <= 100) {
                jSONObject.put("close_jump_probability", i2);
            }
            int i3 = this.KZx;
            if (i3 > 0 && i3 <= 100) {
                jSONObject.put("skip_jump_probability", i3);
            }
            if (this.ZZv == 1) {
                jSONObject.put("hidden_bar", 1);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean pA(yFO yfo) {
        if (yfo == null || !yfo.rjD() || yfo.aj() == null) {
            return false;
        }
        return yfo.aj().ZZv();
    }
}
