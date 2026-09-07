package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.pubnative.lite.sdk.models.Protocol;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BSW {
    private static final AtomicInteger pA = new AtomicInteger(0);
    private static final AtomicBoolean Og = new AtomicBoolean(false);

    public static void pA(String str) {
        AtomicBoolean atomicBoolean = Og;
        if (atomicBoolean.compareAndSet(false, true)) {
            if (!com.bytedance.sdk.component.utils.DX.omh(aBv.pA())) {
                atomicBoolean.set(false);
            } else {
                pA.pA();
                KZx(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void KZx(final String str) {
        com.bytedance.sdk.openadsdk.utils.xy.KZx(new com.bytedance.sdk.component.omh.omh("ipv6") { // from class: com.bytedance.sdk.openadsdk.core.BSW.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectPA;
                final String strTZW = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().tZW();
                com.bytedance.sdk.openadsdk.Sn.KZx.pA(0, strTZW);
                if (TextUtils.isEmpty(strTZW)) {
                    com.bytedance.sdk.openadsdk.Sn.KZx.pA(-1, strTZW, -1, "url is null");
                    return;
                }
                com.bytedance.sdk.component.SD.Og.ZZv zZvOg = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().Og();
                try {
                    zZvOg.Og(strTZW);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("connect_type", com.bytedance.sdk.component.utils.BF.pA(aBv.pA(), 0L));
                    jSONObject.put("device_id", Long.parseLong(str));
                    jSONObject.put("header", com.bytedance.sdk.openadsdk.ZZv.pA.KZx.pA().Og());
                    if (com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA(PangleEncryptConstant.CryptDataScene.APP_LOG)) {
                        jSONObjectPA = PangleEncryptManager.encryptType4(jSONObject, new TX(PangleEncryptConstant.CryptDataScene.DUAL_EVENT));
                        if (jSONObjectPA != null && jSONObjectPA.optInt("cypher") == 4) {
                            BF.Og(true);
                            zZvOg.Og("x-pgli18n", Protocol.VAST_1_0_WRAPPER);
                            zZvOg.Og("Content-Type", "application/json; charset=utf-8");
                        } else {
                            BF.Og(false);
                        }
                    } else {
                        jSONObjectPA = com.bytedance.sdk.component.utils.pA.pA(jSONObject);
                        if (BSW.Og(jSONObjectPA)) {
                            zZvOg.Og("Content-Encoding", "union_sdk_encode");
                        }
                    }
                    if (BSW.Og(jSONObjectPA)) {
                        jSONObject = jSONObjectPA;
                    }
                    zZvOg.Og("Content-Type", "application/json; charset=utf-8");
                    zZvOg.Og("User-Agent", gbA.KZx());
                    zZvOg.pA(jSONObject);
                    zZvOg.pA(6);
                    zZvOg.pA("send_i_p_v6");
                    zZvOg.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.core.BSW.1.1
                        @Override // com.bytedance.sdk.component.SD.pA.pA
                        public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) {
                            if (og.JG()) {
                                com.bytedance.sdk.openadsdk.Sn.KZx.pA(1, strTZW);
                            } else {
                                com.bytedance.sdk.openadsdk.Sn.KZx.pA(-1, strTZW, og.pA(), og.Og());
                                BSW.ZZv();
                            }
                        }

                        @Override // com.bytedance.sdk.component.SD.pA.pA
                        public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                            if (iOException != null) {
                                com.bytedance.sdk.openadsdk.Sn.KZx.pA(-1, strTZW, 1, iOException.getMessage());
                            }
                            BSW.ZZv();
                        }
                    });
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.Sn.KZx.pA(-1, strTZW, -2, e.getMessage());
                    com.bytedance.sdk.component.utils.WV.Og("build ipv6 request failed:" + e.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Og(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void KZx() {
        pA.set(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ZZv() {
        if (pA.getAndIncrement() <= 0) {
            com.bytedance.sdk.openadsdk.utils.xy.pA().schedule(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.BSW.2
                @Override // java.lang.Runnable
                public void run() {
                    BSW.KZx(WV.pA(aBv.pA()));
                }
            }, 10000L, TimeUnit.MILLISECONDS);
        }
    }

    private static class pA implements com.bytedance.sdk.component.utils.BF.pA {
        private static final AtomicBoolean pA = new AtomicBoolean(false);
        private static volatile long Og = -1;

        private pA() {
        }

        public static void pA() {
            if (pA.compareAndSet(false, true)) {
                Og = System.currentTimeMillis();
                com.bytedance.sdk.component.utils.BF.pA(new pA(), aBv.pA());
            }
        }

        public void Og() {
            com.bytedance.sdk.component.utils.BF.pA(this);
        }

        @Override // com.bytedance.sdk.component.utils.BF.pA
        public void pA(Context context, Intent intent, boolean z, int i) {
            if (System.currentTimeMillis() - Og >= 2000 && i != 0) {
                BSW.KZx();
                BSW.KZx(WV.pA(aBv.pA()));
                Og();
            }
        }
    }
}
