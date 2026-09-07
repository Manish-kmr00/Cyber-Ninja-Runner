package com.bytedance.sdk.openadsdk.utils;

import android.os.Looper;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class xy {
    private static volatile com.bytedance.sdk.component.omh.KZx.JG Bzk;
    private static volatile com.bytedance.sdk.component.omh.KZx.JG JG;
    private static volatile com.bytedance.sdk.component.omh.KZx.JG KZx;
    private static volatile com.bytedance.sdk.component.omh.KZx.JG ML;
    private static volatile boolean Og;
    private static volatile com.bytedance.sdk.component.omh.KZx.JG SD;
    private static volatile com.bytedance.sdk.component.omh.KZx.JG SGo;
    private static volatile com.bytedance.sdk.component.omh.KZx.JG ZZv;
    private static volatile com.bytedance.sdk.component.omh.KZx.JG omh;
    private static volatile ThreadPoolExecutor pA;

    static {
        com.bytedance.sdk.component.omh.KZx.KZx.pA(new com.bytedance.sdk.component.omh.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.utils.xy.1
            @Override // com.bytedance.sdk.component.omh.KZx.pA
            public void pA(com.bytedance.sdk.component.omh.KZx.JG jg, com.bytedance.sdk.component.omh.KZx.Og og) {
                og.Og();
                new RuntimeException();
            }
        });
        com.bytedance.sdk.component.omh.KZx.KZx.pA(new com.bytedance.sdk.component.omh.KZx.ML() { // from class: com.bytedance.sdk.openadsdk.utils.xy.3
            @Override // com.bytedance.sdk.component.omh.KZx.ML
            public void pA(final com.bytedance.sdk.component.omh.KZx.JG jg) {
                if (IG.pA || jg == null) {
                    return;
                }
                try {
                    LinkedHashMap<String, com.bytedance.sdk.component.omh.KZx.pA.pA> linkedHashMapPA = jg.pA();
                    if (linkedHashMapPA == null || linkedHashMapPA.size() <= 0) {
                        return;
                    }
                    Iterator<Map.Entry<String, com.bytedance.sdk.component.omh.KZx.pA.pA>> it = linkedHashMapPA.entrySet().iterator();
                    while (it.hasNext()) {
                        final com.bytedance.sdk.component.omh.KZx.pA.pA value = it.next().getValue();
                        if (value != null) {
                            com.bytedance.sdk.openadsdk.Sn.KZx.pA();
                            com.bytedance.sdk.openadsdk.Sn.KZx.pA("pag_thread_pool_state", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.utils.xy.3.1
                                @Override // com.bytedance.sdk.openadsdk.Sn.Og
                                public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("name", value.pA());
                                        jSONObject.put("times", value.Og());
                                        jSONObject.put("runMaxTime", value.JG());
                                        jSONObject.put("waitMaxTime", value.ML());
                                        long jOg = value.Og() == 0 ? 1 : value.Og();
                                        jSONObject.put("avgRunTime", value.ZZv() / jOg);
                                        jSONObject.put("avgWaitTime", value.KZx() / jOg);
                                        jSONObject.put("poolType", jg.Og());
                                    } catch (Exception e) {
                                        com.bytedance.sdk.component.utils.WV.pA("ThreadUtils", "run: ", e);
                                    }
                                    return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("pag_thread_pool_state").Og(jSONObject.toString());
                                }
                            });
                        }
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        });
        pA = null;
        Og = false;
    }

    public static ScheduledExecutorService pA() {
        return com.bytedance.sdk.component.omh.JG.JG();
    }

    public static ExecutorService Og() {
        if (BSW()) {
            return oX();
        }
        return com.bytedance.sdk.component.omh.JG.SGo();
    }

    public static ExecutorService KZx() {
        if (BSW()) {
            return Sn();
        }
        return com.bytedance.sdk.component.omh.JG.ZZv();
    }

    public static ExecutorService ZZv() {
        if (BSW()) {
            return omh();
        }
        return com.bytedance.sdk.component.omh.JG.Og();
    }

    public static boolean ML() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean JG() {
        String str;
        if (BSW()) {
            str = "pag_log";
        } else {
            str = "csj_log";
        }
        String name = Thread.currentThread().getName();
        if (TextUtils.isEmpty(name)) {
            return false;
        }
        return name.startsWith(str);
    }

    public static void pA(Runnable runnable) {
        if (runnable == null || IG.pA) {
            return;
        }
        if (ML()) {
            runnable.run();
        } else {
            com.bytedance.sdk.openadsdk.core.Sn.KZx().post(runnable);
        }
    }

    public static void Og(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.Sn.KZx().removeCallbacks(runnable);
    }

    public static void pA(final com.bytedance.sdk.component.omh.omh omhVar) {
        if (IG.pA) {
            return;
        }
        if (BSW()) {
            omh().execute(new com.bytedance.sdk.component.omh.KZx.Og(omhVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.xy.4
                @Override // java.lang.Runnable
                public void run() {
                    omhVar.run();
                }
            });
        } else {
            com.bytedance.sdk.component.omh.JG.pA(omhVar);
        }
    }

    public static ExecutorService SD() {
        if (BSW()) {
            return aBv();
        }
        return com.bytedance.sdk.component.omh.JG.KZx();
    }

    public static void Og(final com.bytedance.sdk.component.omh.omh omhVar) {
        if (IG.pA) {
            return;
        }
        if (BSW()) {
            aBv().execute(new com.bytedance.sdk.component.omh.KZx.Og(omhVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.xy.5
                @Override // java.lang.Runnable
                public void run() {
                    omhVar.run();
                }
            });
        } else {
            com.bytedance.sdk.component.omh.JG.Og(omhVar);
        }
    }

    public static void pA(final com.bytedance.sdk.component.omh.omh omhVar, int i) {
        if (omhVar == null || IG.pA) {
            return;
        }
        if (BSW()) {
            com.bytedance.sdk.component.omh.KZx.Og og = new com.bytedance.sdk.component.omh.KZx.Og(omhVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.xy.6
                @Override // java.lang.Runnable
                public void run() {
                    omhVar.run();
                }
            };
            og.pA(i);
            aBv().execute(og);
            return;
        }
        com.bytedance.sdk.component.omh.JG.pA(omhVar, 5, i);
    }

    public static void KZx(final com.bytedance.sdk.component.omh.omh omhVar) {
        if (omhVar == null || IG.pA) {
            return;
        }
        if (BSW()) {
            Sn().execute(new com.bytedance.sdk.component.omh.KZx.Og(omhVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.xy.7
                @Override // java.lang.Runnable
                public void run() {
                    omhVar.run();
                }
            });
        } else {
            com.bytedance.sdk.component.omh.JG.KZx(omhVar);
        }
    }

    public static void Og(final com.bytedance.sdk.component.omh.omh omhVar, int i) {
        if (omhVar == null || IG.pA) {
            return;
        }
        if (BSW()) {
            com.bytedance.sdk.component.omh.KZx.Og og = new com.bytedance.sdk.component.omh.KZx.Og(omhVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.xy.8
                @Override // java.lang.Runnable
                public void run() {
                    omhVar.run();
                }
            };
            og.pA(i);
            Sn().execute(og);
            return;
        }
        com.bytedance.sdk.component.omh.JG.Og(omhVar, i);
    }

    public static void ZZv(final com.bytedance.sdk.component.omh.omh omhVar) {
        if (omhVar == null || IG.pA) {
            return;
        }
        if (BSW()) {
            Wx().execute(new com.bytedance.sdk.component.omh.KZx.Og(omhVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.xy.9
                @Override // java.lang.Runnable
                public void run() {
                    omhVar.run();
                }
            });
        } else {
            com.bytedance.sdk.component.omh.JG.ML(omhVar);
        }
    }

    public static void KZx(final com.bytedance.sdk.component.omh.omh omhVar, int i) {
        if (omhVar == null || IG.pA) {
            return;
        }
        if (BSW()) {
            DX().execute(new com.bytedance.sdk.component.omh.KZx.Og(omhVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.xy.10
                @Override // java.lang.Runnable
                public void run() {
                    omhVar.run();
                }
            });
        } else {
            com.bytedance.sdk.component.omh.JG.KZx(omhVar, i);
        }
    }

    public static void ML(final com.bytedance.sdk.component.omh.omh omhVar) {
        if (IG.pA) {
            return;
        }
        if (BSW()) {
            Wx().execute(new com.bytedance.sdk.component.omh.KZx.Og(omhVar.getName(), omhVar) { // from class: com.bytedance.sdk.openadsdk.utils.xy.2
                @Override // java.lang.Runnable
                public void run() {
                    omhVar.run();
                }
            });
            return;
        }
        ThreadPoolExecutor threadPoolExecutorWV = WV();
        threadPoolExecutorWV.execute(omhVar);
        if (Og || !com.bytedance.sdk.openadsdk.core.settings.oX.ka()) {
            return;
        }
        Og = true;
        threadPoolExecutorWV.setCorePoolSize(com.bytedance.sdk.openadsdk.core.settings.oX.vkV().QI());
    }

    public static void pA(com.bytedance.sdk.component.omh.KZx.Og og) {
        SGo().execute(og);
    }

    private static ThreadPoolExecutor WV() {
        int iQI;
        if (pA == null) {
            synchronized (xy.class) {
                if (pA == null) {
                    if (com.bytedance.sdk.openadsdk.core.settings.oX.ka()) {
                        iQI = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().QI();
                        Og = true;
                    } else {
                        iQI = 4;
                    }
                    pA = new ThreadPoolExecutor(iQI, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    new Object[]{"token_thread_count=", Integer.valueOf(iQI)};
                }
            }
        }
        return pA;
    }

    private static ThreadPoolExecutor Wx() {
        com.bytedance.sdk.component.omh.KZx.JG jg;
        com.bytedance.sdk.component.omh.KZx.JG jg2 = KZx;
        if (!pA(jg2)) {
            return jg2;
        }
        synchronized (xy.class) {
            if (pA(KZx)) {
                try {
                    KZx = pA(Reporting.Key.CLICK_SOURCE_TYPE_AD, KZx);
                } catch (Throwable th) {
                    th.getMessage();
                }
                jg = KZx;
            } else {
                jg = KZx;
            }
            throw th;
        }
        return jg;
    }

    public static com.bytedance.sdk.component.omh.KZx.JG omh() {
        com.bytedance.sdk.component.omh.KZx.JG jg;
        com.bytedance.sdk.component.omh.KZx.JG jg2 = JG;
        if (!pA(jg2)) {
            return jg2;
        }
        synchronized (xy.class) {
            if (pA(JG)) {
                try {
                    JG = pA(Reporting.EventType.CACHE, JG);
                } catch (Throwable th) {
                    th.getMessage();
                }
                jg = JG;
            } else {
                jg = JG;
            }
            throw th;
        }
        return jg;
    }

    private static com.bytedance.sdk.component.omh.KZx.JG Sn() {
        com.bytedance.sdk.component.omh.KZx.JG jg;
        com.bytedance.sdk.component.omh.KZx.JG jg2 = ZZv;
        if (!pA(jg2)) {
            return jg2;
        }
        synchronized (xy.class) {
            if (pA(ZZv)) {
                try {
                    ZZv = pA(CreativeInfo.f, ZZv);
                } catch (Throwable th) {
                    th.getMessage();
                }
                jg = ZZv;
            } else {
                jg = ZZv;
            }
            throw th;
        }
        return jg;
    }

    private static com.bytedance.sdk.component.omh.KZx.JG DX() {
        com.bytedance.sdk.component.omh.KZx.JG jg;
        com.bytedance.sdk.component.omh.KZx.JG jg2 = ML;
        if (!pA(jg2)) {
            return jg2;
        }
        synchronized (xy.class) {
            if (pA(ML)) {
                try {
                    ML = pA("aidl", ML);
                } catch (Throwable th) {
                    th.getMessage();
                }
                jg = ML;
            } else {
                jg = ML;
            }
            throw th;
        }
        return jg;
    }

    private static com.bytedance.sdk.component.omh.KZx.JG oX() {
        com.bytedance.sdk.component.omh.KZx.JG jg;
        com.bytedance.sdk.component.omh.KZx.JG jg2 = omh;
        if (!pA(jg2)) {
            return jg2;
        }
        synchronized (xy.class) {
            if (pA(omh)) {
                try {
                    omh = pA("image", omh);
                } catch (Throwable th) {
                    th.getMessage();
                }
                jg = omh;
            } else {
                jg = omh;
            }
            throw th;
        }
        return jg;
    }

    public static com.bytedance.sdk.component.omh.KZx.JG Bzk() {
        com.bytedance.sdk.component.omh.KZx.JG jg;
        com.bytedance.sdk.component.omh.KZx.JG jg2 = Bzk;
        if (!pA(jg2)) {
            return jg2;
        }
        synchronized (xy.class) {
            if (pA(Bzk)) {
                try {
                    Bzk = pA("express", Bzk);
                } catch (Throwable th) {
                    th.getMessage();
                }
                jg = Bzk;
            } else {
                jg = Bzk;
            }
            throw th;
        }
        return jg;
    }

    private static com.bytedance.sdk.component.omh.KZx.JG aBv() {
        com.bytedance.sdk.component.omh.KZx.JG jg;
        com.bytedance.sdk.component.omh.KZx.JG jg2 = SD;
        if (!pA(jg2)) {
            return jg2;
        }
        synchronized (xy.class) {
            if (pA(SD)) {
                try {
                    SD = pA("io", SD);
                } catch (Throwable th) {
                    th.getMessage();
                }
                jg = SD;
            } else {
                jg = SD;
            }
            throw th;
        }
        return jg;
    }

    public static com.bytedance.sdk.component.omh.KZx.JG SGo() {
        com.bytedance.sdk.component.omh.KZx.JG jg;
        com.bytedance.sdk.component.omh.KZx.JG jg2 = SGo;
        if (!pA(jg2)) {
            return jg2;
        }
        synchronized (xy.class) {
            if (pA(SGo)) {
                try {
                    SGo = pA("net", SGo);
                } catch (Throwable th) {
                    th.getMessage();
                }
                jg = SGo;
            } else {
                jg = SGo;
            }
            throw th;
        }
        return jg;
    }

    private static boolean pA(com.bytedance.sdk.component.omh.KZx.JG jg) {
        if (jg != null) {
            return !jg.KZx() && com.bytedance.sdk.openadsdk.core.settings.oX.ka();
        }
        return true;
    }

    public static boolean BSW() {
        if (com.bytedance.sdk.openadsdk.core.settings.oX.ka()) {
            return com.bytedance.sdk.openadsdk.core.settings.oX.vkV().sk();
        }
        return true;
    }

    private static com.bytedance.sdk.component.omh.KZx.JG pA(String str, com.bytedance.sdk.component.omh.KZx.JG jg) {
        com.bytedance.sdk.component.omh.KZx.JG.pA pAVarPA = pA(str);
        if (jg == null) {
            return pAVarPA.pA();
        }
        jg.pA(pAVarPA);
        return jg;
    }

    private static com.bytedance.sdk.component.omh.KZx.JG.pA pA(String str) {
        com.bytedance.sdk.component.omh.KZx.JG.pA pAVarOg = Og(str);
        try {
            if (com.bytedance.sdk.openadsdk.core.settings.oX.ka()) {
                pAVarOg.Og(true);
                JSONObject jSONObjectUz = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().Uz();
                JSONObject jSONObjectOptJSONObject = jSONObjectUz != null ? jSONObjectUz.optJSONObject(str) : null;
                if (jSONObjectOptJSONObject != null) {
                    pAVarOg.Og(true);
                    if (jSONObjectOptJSONObject.has("coreSize")) {
                        pAVarOg.pA(jSONObjectOptJSONObject.optInt("coreSize"));
                    }
                    if (jSONObjectOptJSONObject.has(SDKConstants.PARAM_CONTEXT_MAX_SIZE)) {
                        pAVarOg.Og(jSONObjectOptJSONObject.optInt(SDKConstants.PARAM_CONTEXT_MAX_SIZE));
                    }
                    if (jSONObjectOptJSONObject.has("createSize")) {
                        pAVarOg.KZx(jSONObjectOptJSONObject.optInt("createSize"));
                    }
                    if (jSONObjectOptJSONObject.has("keepAlive")) {
                        pAVarOg.pA(jSONObjectOptJSONObject.optInt("keepAlive"));
                    }
                    if (jSONObjectOptJSONObject.has("allowCoreTimeOut")) {
                        pAVarOg.pA(jSONObjectOptJSONObject.optBoolean("allowCoreTimeOut"));
                    }
                    if (jSONObjectOptJSONObject.has("reportLogThreshold")) {
                        pAVarOg.ML(jSONObjectOptJSONObject.optInt("reportLogThreshold"));
                    }
                    if (jSONObjectOptJSONObject.has("logTaskCount")) {
                        pAVarOg.ZZv(jSONObjectOptJSONObject.optInt("logTaskCount"));
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return pAVarOg;
    }

    private static com.bytedance.sdk.component.omh.KZx.JG.pA Og(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        com.bytedance.sdk.component.omh.KZx.JG.pA pAVar = new com.bytedance.sdk.component.omh.KZx.JG.pA();
        str.hashCode();
        switch (str) {
            case "express":
                return pAVar.pA(str).pA(2).Og(4).KZx(0).pA(10000L).pA(true).ML(-1).ZZv(10).Og(false);
            case "ad":
                return pAVar.pA(str).pA(4).Og(4).KZx(0).pA(20000L).pA(true).ML(-1).ZZv(10).Og(false);
            case "io":
                return pAVar.pA(str).pA(4).Og(10).KZx(0).pA(20000L).pA(true).ML(-1).ZZv(10).Og(false);
            case "log":
                return pAVar.pA(str).pA(4).Og(6).KZx(2).pA(20000L).pA(true).ML(-1).ZZv(10).Og(false);
            case "net":
                return pAVar.pA(str).pA(10).Og(10).KZx(0).pA(10000L).pA(true).ML(-1).ZZv(10).Og(false);
            case "aidl":
                return pAVar.pA(str).pA(2).Og(4).KZx(0).pA(10000L).pA(true).ML(-1).ZZv(10).Og(false);
            case "cache":
                return pAVar.pA(str).pA(0).Og(0).KZx(0).pA(5000L).pA(true).ML(-1).ZZv(20).Og(false);
            case "image":
                return pAVar.pA(str).pA(3).Og(3).KZx(0).pA(20000L).pA(true).ML(-1).ZZv(10).Og(false);
            case "monitor":
                return pAVar.pA(str).pA(2).Og(2).KZx(0).pA(10000L).pA(true).ML(-1).ZZv(10).Og(false);
            default:
                return pAVar.pA(str).pA(8).Og(16).KZx(2).pA(20000L).pA(true).ML(-1).ZZv(10).Og(false);
        }
    }
}
