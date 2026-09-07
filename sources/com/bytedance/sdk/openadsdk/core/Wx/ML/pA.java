package com.bytedance.sdk.openadsdk.core.Wx.ML;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.pA.pA.pA.KZx.KZx;
import com.bytedance.sdk.component.Og.pA.SD;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.BSW;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.Bzk;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.SGo;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.WV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class pA {
    public static final com.bykv.vk.openvk.pA.pA.pA.ML.pA pA = new com.bykv.vk.openvk.pA.pA.Og.pA.Og.pA();

    private static boolean pA(KZx kZx) {
        return true;
    }

    public static void pA(final KZx kZx, final com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA interfaceC0159pA) {
        yFO yfo;
        AdSlot adSlot;
        if ((kZx.KZx() > 0 || kZx.SGo()) && kZx.DX() != -2) {
            if (kZx.DX() != 1) {
                kZx.ZZv(6000);
                kZx.ML(6000);
                kZx.JG(6000);
                boolean z = kZx.ML("material_meta") != null && (kZx.ML("material_meta") instanceof yFO);
                boolean z2 = kZx.ML("ad_slot") != null && (kZx.ML("ad_slot") instanceof AdSlot);
                if (z && z2) {
                    yfo = (yFO) kZx.ML("material_meta");
                    AdSlot adSlot2 = (AdSlot) kZx.ML("ad_slot");
                    Og(kZx, yfo, adSlot2);
                    adSlot = adSlot2;
                } else {
                    yfo = null;
                    adSlot = null;
                }
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                final yFO yfo2 = yfo;
                final AdSlot adSlot3 = adSlot;
                final com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA interfaceC0159pA2 = new com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA() { // from class: com.bytedance.sdk.openadsdk.core.Wx.ML.pA.1
                    @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                    public void pA(KZx kZx2, int i) {
                        com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA interfaceC0159pA3 = interfaceC0159pA;
                        if (interfaceC0159pA3 != null) {
                            interfaceC0159pA3.pA(kZx2, i);
                        }
                        if (yfo2 == null || adSlot3 == null) {
                            return;
                        }
                        pA.Og(kZx, yfo2, adSlot3, SystemClock.elapsedRealtime() - jElapsedRealtime);
                    }

                    @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                    public void pA(KZx kZx2, int i, String str) {
                        com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA interfaceC0159pA3 = interfaceC0159pA;
                        if (interfaceC0159pA3 != null) {
                            interfaceC0159pA3.pA(kZx2, i, str);
                        }
                        if (yfo2 == null || adSlot3 == null) {
                            return;
                        }
                        pA.Og(kZx, yfo2, adSlot3, SystemClock.elapsedRealtime() - jElapsedRealtime, i, str);
                    }

                    @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                    public void Og(KZx kZx2, int i) {
                        AdSlot adSlot4;
                        com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA interfaceC0159pA3 = interfaceC0159pA;
                        if (interfaceC0159pA3 != null) {
                            interfaceC0159pA3.pA(kZx2, i);
                        }
                        yFO yfo3 = yfo2;
                        if (yfo3 != null && (adSlot4 = adSlot3) != null) {
                            pA.KZx(kZx, yfo3, adSlot4);
                        }
                        new Object[]{"cancel: ", kZx.Sn()};
                    }
                };
                if (!pA(kZx.Wx())) {
                    if (interfaceC0159pA != null) {
                        interfaceC0159pA.pA(kZx, 404, "unexpected url: " + kZx.Wx());
                    }
                    Og(kZx, yfo, adSlot, SystemClock.elapsedRealtime() - jElapsedRealtime, -1, "video url is invalid");
                    return;
                } else {
                    omh omhVar = new omh("VideoPreload") { // from class: com.bytedance.sdk.openadsdk.core.Wx.ML.pA.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                pA.pA.pA(aBv.pA(), kZx, interfaceC0159pA2);
                            } catch (Throwable th) {
                                th.getMessage();
                            }
                        }
                    };
                    if (xy.ML()) {
                        xy.Og(omhVar);
                        return;
                    } else {
                        omhVar.run();
                        return;
                    }
                }
            }
        }
        if (interfaceC0159pA != null) {
            interfaceC0159pA.pA(kZx, 100);
        }
    }

    private static void Og(KZx kZx, yFO yfo, AdSlot adSlot) {
        if (pA(kZx)) {
            com.bytedance.sdk.openadsdk.Sn.KZx.pA("load_video_start", new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfo, gbA.KZx(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(yfo, (String) null, -1, kZx), new BSW(kZx.Wx(), kZx.SGo() ? kZx.Bzk() : kZx.KZx())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og(KZx kZx, yFO yfo, AdSlot adSlot, long j, int i, String str) {
        if (pA(kZx)) {
            String strKZx = gbA.KZx(adSlot.getDurationSlotType());
            JSONObject jSONObjectPA = com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(yfo, (String) null, -1, kZx);
            SGo sGo = new SGo();
            sGo.pA(kZx.Wx());
            sGo.pA(kZx.KZx());
            sGo.Og(j);
            sGo.pA(i);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sGo.Og(str);
            sGo.KZx("");
            com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA((com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA<SGo>) new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfo, strKZx, jSONObjectPA, sGo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og(KZx kZx, yFO yfo, AdSlot adSlot, long j) {
        if (pA(kZx)) {
            String strKZx = gbA.KZx(adSlot.getDurationSlotType());
            JSONObject jSONObjectPA = com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(yfo, (String) null, -1, kZx);
            WV wv = new WV();
            wv.pA(kZx.Wx());
            wv.pA(kZx.KZx());
            wv.Og(j);
            if (kZx.yFO() == 1) {
                wv.KZx(1L);
            } else {
                wv.KZx(0L);
            }
            com.bytedance.sdk.openadsdk.Sn.KZx.pA("load_video_success", new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfo, strKZx, jSONObjectPA, wv));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void KZx(KZx kZx, yFO yfo, AdSlot adSlot) {
        if (pA(kZx)) {
            com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.Og((com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA<Bzk>) new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfo, gbA.KZx(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(yfo, (String) null, -1, kZx), new Bzk(kZx.Wx(), kZx.KZx())));
        }
    }

    public static boolean pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.regionMatches(true, 0, "ws:", 0, 3)) {
            str = "http:" + str.substring(3);
        } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
            str = "https:" + str.substring(4);
        }
        return SD.KZx(str) != null;
    }

    public static boolean pA() {
        return com.bytedance.sdk.openadsdk.vZF.pA.pA("video_lower_support_discard", 0) == 0;
    }
}
