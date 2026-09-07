package com.bytedance.sdk.openadsdk.core.WV.Og;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class Og extends KZx implements Comparable<Og> {
    private final float pA;

    private Og(float f, String str, KZx.EnumC0234KZx enumC0234KZx, Boolean bool) {
        super(str, enumC0234KZx, bool);
        this.pA = f;
    }

    public boolean pA(float f) {
        return this.pA <= f && !ML();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public int compareTo(Og og) {
        if (og == null) {
            return 1;
        }
        float f = this.pA;
        float f2 = og.pA;
        if (f > f2) {
            return 1;
        }
        return f < f2 ? -1 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.WV.Og.KZx
    public void j_() {
        super.j_();
    }

    public static class pA {
        private final float Og;
        private final String pA;
        private KZx.EnumC0234KZx KZx = KZx.EnumC0234KZx.TRACKING_URL;
        private boolean ZZv = false;

        public pA(String str, float f) {
            this.pA = str;
            this.Og = f;
        }

        public Og pA() {
            return new Og(this.Og, this.pA, this.KZx, Boolean.valueOf(this.ZZv));
        }
    }

    public JSONObject Og() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", KZx());
        jSONObject.put("trackingFraction", this.pA);
        return jSONObject;
    }
}
