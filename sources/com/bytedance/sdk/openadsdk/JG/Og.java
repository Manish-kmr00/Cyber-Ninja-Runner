package com.bytedance.sdk.openadsdk.JG;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.Sn.pA.ZZv;
import com.bytedance.sdk.openadsdk.core.KZx;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.IG;
import com.json.m5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class Og {
    private static volatile Og pA;
    private final ConcurrentHashMap<String, com.bytedance.sdk.openadsdk.DX.pA> Og = new ConcurrentHashMap<>();
    private com.bytedance.sdk.openadsdk.DX.pA KZx = null;
    private volatile boolean ZZv = false;
    private volatile HandlerThread ML = null;
    private volatile Handler JG = null;
    private String SD = "";
    private int omh = 0;
    private volatile long Bzk = 0;
    private final Runnable SGo = new Runnable() { // from class: com.bytedance.sdk.openadsdk.JG.Og.6
        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (pA.pA().ML()) {
                        Set<String> setKeySet = Og.this.Og.keySet();
                        if (setKeySet.size() > Og.this.omh) {
                            Og.this.omh = setKeySet.size();
                        }
                        HashSet hashSet = new HashSet(5);
                        ArrayList arrayList = new ArrayList(setKeySet.size());
                        arrayList.addAll(Og.this.Og.values());
                        Collections.sort(arrayList);
                        for (int i = 0; i < arrayList.size() && i < 5; i++) {
                            hashSet.add(((com.bytedance.sdk.openadsdk.DX.pA) arrayList.get(i)).Og());
                        }
                        try {
                            for (String str : setKeySet) {
                                com.bytedance.sdk.openadsdk.DX.pA pAVar = (com.bytedance.sdk.openadsdk.DX.pA) Og.this.Og.get(str);
                                if (pAVar != null) {
                                    JSONObject jSONObjectPA = pAVar.pA(jSONObject2);
                                    if (hashSet.contains(str)) {
                                        jSONObject.put(str, jSONObjectPA);
                                    }
                                }
                            }
                            jSONObject.put("common", jSONObject2);
                        } catch (JSONException e) {
                            WV.Og(e.getMessage());
                        }
                    } else {
                        try {
                            if (Og.this.KZx != null) {
                                jSONObject.put("common", Og.this.KZx.pA(jSONObject2));
                            }
                        } catch (JSONException e2) {
                            WV.Og(e2.getMessage());
                        }
                    }
                } catch (Throwable th) {
                    WV.Og(th.getMessage());
                }
                Og.this.SD = jSONObject.toString();
                Og og = Og.this;
                og.pA(og.SGo, pA.pA().ZZv());
            } catch (OutOfMemoryError e3) {
                WV.Og(e3.getMessage());
            }
        }
    };

    private Handler KZx() {
        if (this.ML == null || !this.ML.isAlive()) {
            synchronized (Sn.class) {
                if (this.ML == null || !this.ML.isAlive()) {
                    this.ML = new HandlerThread("csj_feature", -1);
                    this.ML.start();
                    this.JG = new Handler(this.ML.getLooper());
                }
            }
        } else if (this.JG == null) {
            synchronized (Sn.class) {
                if (this.JG == null) {
                    this.JG = new Handler(this.ML.getLooper());
                }
            }
        }
        return this.JG;
    }

    private void pA(Runnable runnable) {
        if (IG.pA || runnable == null) {
            return;
        }
        try {
            KZx().post(runnable);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(Runnable runnable, long j) {
        if (IG.pA || runnable == null) {
            return;
        }
        try {
            KZx().postDelayed(runnable, j);
        } catch (Throwable unused) {
        }
    }

    private Og() {
    }

    public static Og pA() {
        if (pA == null) {
            synchronized (KZx.class) {
                if (pA == null) {
                    pA = new Og();
                }
            }
        }
        return pA;
    }

    public void pA(JSONObject jSONObject) {
        if (pA.pA().KZx()) {
            try {
                jSONObject.put("feature_data", this.SD);
                ZZv();
            } catch (JSONException e) {
                WV.Og(e.getMessage());
            }
        }
    }

    private void ZZv() {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.Bzk > 10000) {
            com.bytedance.sdk.openadsdk.Sn.KZx.pA("track_feature_result", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.JG.Og.1
                @Override // com.bytedance.sdk.openadsdk.Sn.Og
                public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                    Og.this.Bzk = jElapsedRealtime;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("msg", String.valueOf(Og.this.omh));
                    return ZZv.Og().pA("track_feature_result").Og(jSONObject.toString());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && pA.pA().KZx()) {
                ML();
                if (pA.pA().ML()) {
                    com.bytedance.sdk.openadsdk.DX.pA pAVar = this.Og.get(str2);
                    if (pAVar == null) {
                        pAVar = new com.bytedance.sdk.openadsdk.DX.pA(str2);
                    }
                    pAVar.pA(str, str3);
                    this.Og.put(str2, pAVar);
                    return;
                }
                if (this.KZx == null) {
                    this.KZx = new com.bytedance.sdk.openadsdk.DX.pA(str2);
                }
                this.KZx.pA(str, str3);
            }
        } catch (OutOfMemoryError e) {
            WV.Og(e.getMessage());
        }
    }

    public void pA(final String str, final String str2, final String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !pA.pA().KZx()) {
            return;
        }
        if (m5.v.equals(str) || "click".equals(str) || "dislike".equals(str)) {
            pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.JG.Og.2
                @Override // java.lang.Runnable
                public void run() {
                    Og.this.pA(str, str2, str3);
                }
            });
            return;
        }
        if (pA.pA().XT()) {
            if (TextUtils.isEmpty(str4)) {
                return;
            }
            if (!"rewarded_video".equals(str4) && !"fullscreen_interstitial_ad".equals(str4) && !"open_ad".equals(str4)) {
                return;
            }
        }
        if ("feed_play".equals(str) || "feed_pause".equals(str) || "feed_continue".equals(str) || "feed_over".equals(str) || "feed_break".equals(str) || "play_error".equals(str)) {
            pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.JG.Og.3
                @Override // java.lang.Runnable
                public void run() {
                    Og.this.pA(str, str2, str3);
                }
            });
        }
    }

    public void pA(final String str, final yFO yfo) {
        if (!TextUtils.isEmpty(str) && pA.pA().KZx() && yFO.ML(yfo)) {
            if (!pA.pA().XT() || yfo.FHA() == 8 || yfo.FHA() == 7 || yfo.FHA() == 3) {
                if ("videoPercent30".equals(str) || "videoForceBreak".equals(str)) {
                    pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.JG.Og.4
                        @Override // java.lang.Runnable
                        public void run() {
                            String strZQ = yfo.ZQ();
                            String strIj = yfo.Ij();
                            if (TextUtils.isEmpty(strZQ)) {
                                return;
                            }
                            Og.this.pA(str, strZQ, strIj);
                        }
                    });
                }
            }
        }
    }

    public void pA(final String str, final yFO yfo, final String str2) {
        if (TextUtils.isEmpty(str) || !pA.pA().KZx()) {
            return;
        }
        if ("landingStart".equals(str) || "landingFinish".equals(str) || "landingContinue".equals(str) || "landingPause".equals(str)) {
            pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.JG.Og.5
                @Override // java.lang.Runnable
                public void run() {
                    yFO yfo2 = yfo;
                    if (yfo2 == null || TextUtils.isEmpty(yfo2.ZQ())) {
                        return;
                    }
                    Og.this.pA(str, yfo.ZQ(), yfo.Ij() + str2);
                }
            });
        }
    }

    private void ML() {
        if (this.ZZv) {
            return;
        }
        this.ZZv = true;
        pA(this.SGo, pA.pA().ZZv());
    }

    public void Og() {
        try {
            if (pA.pA().KZx()) {
                pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.JG.Og.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (pA.pA().ML()) {
                            Iterator it = Og.this.Og.keySet().iterator();
                            while (it.hasNext()) {
                                com.bytedance.sdk.openadsdk.DX.pA pAVar = (com.bytedance.sdk.openadsdk.DX.pA) Og.this.Og.get((String) it.next());
                                if (pAVar != null) {
                                    pAVar.pA();
                                }
                            }
                            return;
                        }
                        if (Og.this.KZx != null) {
                            Og.this.KZx.pA();
                        }
                    }
                });
            }
        } catch (OutOfMemoryError e) {
            WV.Og(e.getMessage());
        }
    }
}
