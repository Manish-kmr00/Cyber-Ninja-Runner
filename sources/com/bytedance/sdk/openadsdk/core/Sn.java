package com.bytedance.sdk.openadsdk.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class Sn {
    public static long ML;
    private static volatile HandlerThread SD;
    public static volatile boolean pA;
    public static AtomicBoolean Og = new AtomicBoolean(false);
    public static long KZx = 0;
    private static volatile int JG = 0;
    public static float ZZv = 1.0f;
    private static volatile Handler omh = null;

    static {
        HandlerThread handlerThread = new HandlerThread("csj_init_handle", 10);
        SD = handlerThread;
        handlerThread.start();
        ML = System.currentTimeMillis();
    }

    public static void pA(long j) {
        ML = j;
    }

    public static long pA() {
        return ML;
    }

    public static Handler Og() {
        if (SD == null || !SD.isAlive()) {
            synchronized (Sn.class) {
                if (SD == null || !SD.isAlive()) {
                    HandlerThread handlerThread = new HandlerThread("csj_init_handle", -1);
                    SD = handlerThread;
                    handlerThread.start();
                    omh = new Handler(SD.getLooper());
                }
            }
        } else if (omh == null) {
            synchronized (Sn.class) {
                if (omh == null) {
                    omh = new Handler(SD.getLooper());
                }
            }
        }
        return omh;
    }

    public static Handler KZx() {
        return new Handler(Looper.getMainLooper());
    }

    public static int ZZv() {
        return JG;
    }

    public static void pA(int i) {
        JG = i;
    }

    public static boolean ML() {
        return ZZv() == 1;
    }

    public static void JG() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - KZx <= 10000) {
            return;
        }
        KZx = jElapsedRealtime;
        com.bytedance.sdk.openadsdk.utils.xy.pA(new com.bytedance.sdk.component.omh.omh("onSharedPreferenceChanged") { // from class: com.bytedance.sdk.openadsdk.core.Sn.1
            @Override // java.lang.Runnable
            public void run() {
                String strKZx = com.bytedance.sdk.openadsdk.core.settings.oX.KZx(aBv.pA());
                if (TextUtils.equals(strKZx, com.bytedance.sdk.openadsdk.core.settings.oX.ZZv)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA(6, true);
                com.bytedance.sdk.openadsdk.core.settings.oX.ZZv = strKZx;
            }
        });
    }

    public static void SD() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - KZx <= 10000) {
            return;
        }
        synchronized (Sn.class) {
            if (jElapsedRealtime - KZx <= 10000) {
                return;
            }
            KZx = jElapsedRealtime;
            com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Sn.2
                @Override // java.lang.Runnable
                public void run() {
                    String strKZx = com.bytedance.sdk.openadsdk.core.settings.oX.KZx(aBv.pA());
                    if (TextUtils.equals(strKZx, com.bytedance.sdk.openadsdk.core.settings.oX.ZZv)) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA(6, true);
                    com.bytedance.sdk.openadsdk.core.settings.oX.ZZv = strKZx;
                }
            });
        }
    }

    public static void pA(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if ("mediation".equals(jSONObject.optString("name", ""))) {
                    Bzk.Og().Og(jSONObject.optString("value", ""));
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("InitHelper", th.getMessage());
        }
    }

    public static void omh() {
        Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Sn.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.oX.KZx.pA(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.Sn.3.1
                        @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                        public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                            com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                            pAVar.Og("init");
                            return pAVar;
                        }
                    });
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.pA("InitHelper", th.getMessage());
                }
            }
        });
    }
}
