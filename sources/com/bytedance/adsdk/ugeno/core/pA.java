package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class pA {
    private String JG;
    private List<C0178pA> KZx;
    private long ML;
    private float Og;
    private long ZZv;
    private String pA;

    public String pA() {
        return this.pA;
    }

    public void pA(String str) {
        this.pA = str;
    }

    public void pA(float f) {
        this.Og = f;
    }

    public float Og() {
        return this.Og;
    }

    public List<C0178pA> KZx() {
        return this.KZx;
    }

    public void pA(List<C0178pA> list) {
        this.KZx = list;
    }

    public long ZZv() {
        return this.ZZv;
    }

    public void pA(long j) {
        this.ZZv = j;
    }

    public long ML() {
        return this.ML;
    }

    public void Og(long j) {
        this.ML = j;
    }

    public String JG() {
        return this.JG;
    }

    public void Og(String str) {
        this.JG = str;
    }

    public static pA pA(String str, com.bytedance.adsdk.ugeno.Og.KZx kZx) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return pA(new JSONObject(str), kZx);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static pA pA(JSONObject jSONObject, com.bytedance.adsdk.ugeno.Og.KZx kZx) {
        return pA(jSONObject, null, kZx);
    }

    public static pA pA(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.adsdk.ugeno.Og.KZx kZx) {
        if (jSONObject == null) {
            return null;
        }
        pA pAVar = new pA();
        pAVar.pA(jSONObject.optString("ordering"));
        String strOptString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", strOptString)) {
            pAVar.pA(-1.0f);
        } else {
            try {
                pAVar.pA(Float.parseFloat(strOptString));
            } catch (NumberFormatException unused) {
                pAVar.pA(0.0f);
            }
        }
        pAVar.pA(jSONObject.optLong("duration", 0L));
        pAVar.Og(com.bytedance.adsdk.ugeno.SD.KZx.pA(com.bytedance.adsdk.ugeno.KZx.Og.pA(jSONObject.optString("startDelay"), kZx.SGo()), 0L));
        pAVar.Og(jSONObject.optString("loopMode"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animators");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObject2 != null) {
                    com.bytedance.adsdk.ugeno.SD.Og.pA(jSONObject2, jSONObjectOptJSONObject);
                }
                arrayList.add(C0178pA.pA(jSONObjectOptJSONObject, kZx));
            }
            pAVar.pA(arrayList);
        }
        return pAVar;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.core.pA$pA, reason: collision with other inner class name */
    public static class C0178pA {
        private String Bzk;
        private float JG;
        private String KZx;
        private String ML;
        private float Og;
        private float SD;
        private String SGo;
        private long ZZv;
        private float[] omh;
        private long pA;

        public long pA() {
            return this.pA;
        }

        public void pA(long j) {
            this.pA = j;
        }

        public float Og() {
            return this.Og;
        }

        public void pA(float f) {
            this.Og = f;
        }

        public String KZx() {
            return this.KZx;
        }

        public void pA(String str) {
            this.KZx = str;
        }

        public long ZZv() {
            return this.ZZv;
        }

        public void Og(long j) {
            this.ZZv = j;
        }

        public String ML() {
            return this.ML;
        }

        public void Og(String str) {
            this.ML = str;
        }

        public float JG() {
            return this.JG;
        }

        public void Og(float f) {
            this.JG = f;
        }

        public float SD() {
            return this.SD;
        }

        public void KZx(float f) {
            this.SD = f;
        }

        public float[] omh() {
            return this.omh;
        }

        public void pA(float[] fArr) {
            this.omh = fArr;
        }

        public String Bzk() {
            return this.Bzk;
        }

        public String SGo() {
            return this.SGo;
        }

        public void KZx(String str) {
            this.SGo = str;
        }

        public void ZZv(String str) {
            this.Bzk = str;
        }

        public static C0178pA pA(JSONObject jSONObject, com.bytedance.adsdk.ugeno.Og.KZx kZx) {
            if (jSONObject == null) {
                return null;
            }
            C0178pA c0178pA = new C0178pA();
            c0178pA.pA(jSONObject.optLong("duration"));
            String strOptString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", strOptString)) {
                c0178pA.pA(-1.0f);
            } else {
                try {
                    c0178pA.pA(Float.parseFloat(strOptString));
                } catch (NumberFormatException unused) {
                    c0178pA.pA(0.0f);
                }
            }
            c0178pA.pA(jSONObject.optString("loopMode"));
            c0178pA.Og(jSONObject.optString("type"));
            if (TextUtils.equals(c0178pA.ML(), "ripple")) {
                c0178pA.KZx(jSONObject.optString("rippleColor"));
            }
            View viewBzk = kZx.Bzk();
            Context context = viewBzk != null ? viewBzk.getContext() : null;
            if (TextUtils.equals(c0178pA.ML(), "backgroundColor")) {
                String strPA = com.bytedance.adsdk.ugeno.KZx.Og.pA(jSONObject.optString("valueTo"), kZx.SGo());
                int iPA = com.bytedance.adsdk.ugeno.SD.pA.pA(jSONObject.optString("valueFrom"));
                int iPA2 = com.bytedance.adsdk.ugeno.SD.pA.pA(strPA);
                c0178pA.Og(iPA);
                c0178pA.KZx(iPA2);
            } else if ((TextUtils.equals(c0178pA.ML(), "translateX") || TextUtils.equals(c0178pA.ML(), "translateY")) && context != null) {
                try {
                    float fPA = com.bytedance.adsdk.ugeno.SD.omh.pA(context, (float) jSONObject.optDouble("valueFrom"));
                    float fPA2 = com.bytedance.adsdk.ugeno.SD.omh.pA(context, (float) jSONObject.optDouble("valueTo"));
                    c0178pA.Og(fPA);
                    c0178pA.KZx(fPA2);
                } catch (Exception unused2) {
                    Log.e("animation", "animation ");
                }
            } else {
                c0178pA.Og((float) jSONObject.optDouble("valueFrom"));
                c0178pA.KZx((float) jSONObject.optDouble("valueTo"));
            }
            c0178pA.ZZv(jSONObject.optString("interpolator"));
            String strPA2 = com.bytedance.adsdk.ugeno.KZx.Og.pA(jSONObject.optString("startDelay"), kZx.SGo());
            Log.d("TAG", "createAnimationModel: ");
            c0178pA.Og(com.bytedance.adsdk.ugeno.SD.KZx.pA(strPA2, 0L));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                float[] fArr = new float[jSONArrayOptJSONArray.length()];
                int i = 0;
                if ((TextUtils.equals(c0178pA.ML(), "translateX") || TextUtils.equals(c0178pA.ML(), "translateY")) && context != null) {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = com.bytedance.adsdk.ugeno.SD.omh.pA(context, (float) pA.pA(jSONArrayOptJSONArray.optString(i), kZx.SGo()));
                        i++;
                    }
                } else {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = (float) pA.pA(jSONArrayOptJSONArray.optString(i), kZx.SGo());
                        i++;
                    }
                }
                c0178pA.pA(fArr);
            }
            return c0178pA;
        }
    }

    public static double pA(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.bytedance.adsdk.ugeno.SD.KZx.pA(com.bytedance.adsdk.ugeno.KZx.Og.pA((String) obj, jSONObject), 0.0d);
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Long) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Integer) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }
}
