package com.bytedance.sdk.openadsdk.core.WV.Og;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.BF;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class KZx {
    private boolean KZx;
    private EnumC0234KZx Og;
    private boolean ZZv;
    private final String pA;
    private static final Map<String, Og> ML = new ConcurrentHashMap();
    private static final AtomicBoolean JG = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.WV.Og.KZx$KZx, reason: collision with other inner class name */
    enum EnumC0234KZx {
        TRACKING_URL,
        QUARTILE_EVENT
    }

    static {
        BF.pA(new BF.pA() { // from class: com.bytedance.sdk.openadsdk.core.WV.Og.KZx.1
            @Override // com.bytedance.sdk.component.utils.BF.pA
            public void pA(Context context, Intent intent, boolean z, int i) {
                if (i == 0 || KZx.ML.size() <= 0) {
                    return;
                }
                KZx.Og();
            }
        }, aBv.pA());
    }

    protected KZx(String str, EnumC0234KZx enumC0234KZx, Boolean bool) {
        this.pA = str;
        this.Og = enumC0234KZx;
        this.KZx = bool.booleanValue();
    }

    public String KZx() {
        return this.pA;
    }

    public boolean ZZv() {
        return this.KZx;
    }

    public void j_() {
        this.ZZv = true;
    }

    public static class pA {
        private final String pA;
        private EnumC0234KZx Og = EnumC0234KZx.TRACKING_URL;
        private boolean KZx = false;

        public pA(String str) {
            this.pA = str;
        }

        public pA pA(boolean z) {
            this.KZx = z;
            return this;
        }

        public KZx pA() {
            return new KZx(this.pA, this.Og, Boolean.valueOf(this.KZx));
        }
    }

    public boolean ML() {
        return this.ZZv;
    }

    public static List<String> pA(List<KZx> list, com.bytedance.sdk.openadsdk.core.WV.pA.pA pAVar, long j, String str) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (KZx kZx : list) {
            if (kZx != null && (!kZx.ML() || kZx.ZZv())) {
                arrayList.add(kZx.KZx());
                kZx.j_();
            }
        }
        return new com.bytedance.sdk.openadsdk.core.WV.KZx.KZx(arrayList).pA(pAVar).pA(j).pA(str).pA();
    }

    public static void pA(List<KZx> list, com.bytedance.sdk.openadsdk.core.WV.pA.pA pAVar, long j, String str, Og og) {
        pA(pA(list, pAVar, j, str), og);
    }

    public static void Og(List<KZx> list, com.bytedance.sdk.openadsdk.core.WV.pA.pA pAVar, long j, String str) {
        pA(list, pAVar, j, str, null);
    }

    public static void pA(List<String> list, Og og) {
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (!TextUtils.isEmpty(str)) {
                pA(str, og, false);
            }
        }
    }

    private static void pA(final String str, final Og og, final boolean z) {
        com.bytedance.sdk.component.SD.Og.Og ogKZx = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().KZx();
        if (ogKZx == null) {
            return;
        }
        ogKZx.pA(true);
        ogKZx.Og(str);
        ogKZx.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.core.WV.Og.KZx.2
            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og2) {
                boolean z2;
                Og og3 = og;
                if (og3 == null || og3.Og == null) {
                    return;
                }
                String str2 = null;
                if (og2 == null || !og2.JG()) {
                    z2 = false;
                    if (og2 != null) {
                        str2 = og2.pA() + ":" + og2.Og();
                        if (!z && (og2.pA() <= 300 || og2.pA() >= 400)) {
                            KZx.ML.put(str, og);
                        }
                    }
                } else {
                    z2 = true;
                }
                KZx.Og(z2, str2, gbA.KZx(og.Og.PKZ()), og, str, z);
                if (og2 == null || og2.pA() != 200 || KZx.ML.size() <= 0) {
                    return;
                }
                KZx.Og();
            }

            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                Og og2 = og;
                if (og2 != null && og2.Og != null) {
                    KZx.Og(false, iOException != null ? iOException.getMessage() : null, gbA.KZx(og.Og.PKZ()), og, str, z);
                }
                if (z || og == null) {
                    return;
                }
                KZx.ML.put(str, og);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og() {
        if (JG.compareAndSet(false, true)) {
            Map<String, Og> map = ML;
            HashSet<Map.Entry> hashSet = new HashSet(map.entrySet());
            map.clear();
            for (Map.Entry entry : hashSet) {
                if (entry != null) {
                    pA((String) entry.getKey(), (Og) entry.getValue(), true);
                }
            }
            JG.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og(final boolean z, final String str, final String str2, final Og og, final String str3, final boolean z2) {
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(new omh("dsp_track_link_result") { // from class: com.bytedance.sdk.openadsdk.core.WV.Og.KZx.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", og.pA);
                    jSONObject.put("success", z);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("description", str);
                    }
                    jSONObject.put("url", str3);
                    if (og.KZx >= 0.0f) {
                        jSONObject.put("progress", ((double) Math.round(og.KZx * 100.0f)) / 100.0d);
                    }
                    if (z2) {
                        jSONObject.put("retry", true);
                    }
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(og.Og, str2, "dsp_track_link_result", jSONObject);
            }
        });
    }

    public static JSONArray pA(List<KZx> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(list.get(i).KZx());
        }
        return jSONArray;
    }

    public static List<KZx> pA(JSONArray jSONArray) {
        return pA(jSONArray, false);
    }

    public static List<KZx> pA(JSONArray jSONArray, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String strOptString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(new pA(strOptString).pA(z).pA());
                }
            }
        }
        return arrayList;
    }

    public static List<com.bytedance.sdk.openadsdk.core.WV.Og.Og> Og(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new com.bytedance.sdk.openadsdk.core.WV.Og.Og.pA(jSONObjectOptJSONObject.optString("content"), (float) jSONObjectOptJSONObject.optDouble("trackingFraction", 0.0d)).pA());
                }
            }
        }
        return arrayList;
    }

    public static List<com.bytedance.sdk.openadsdk.core.WV.Og.pA> KZx(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new com.bytedance.sdk.openadsdk.core.WV.Og.pA.C0235pA(jSONObjectOptJSONObject.optString("content"), jSONObjectOptJSONObject.optLong("trackingMilliseconds", 0L)).pA());
                }
            }
        }
        return arrayList;
    }

    public static class Og {
        float KZx;
        yFO Og;
        String pA;

        public Og(String str, yFO yfo) {
            this(str, yfo, -1.0f);
        }

        public Og(String str, yFO yfo, float f) {
            this.pA = str;
            this.Og = yfo;
            this.KZx = f;
        }
    }
}
