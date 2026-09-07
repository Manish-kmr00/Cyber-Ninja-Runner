package com.bytedance.sdk.openadsdk.oX;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.json.mediationsdk.metadata.a;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class KZx {
    private static volatile HandlerThread KZx;
    private static Boolean Og;
    private static volatile Handler ZZv;
    private static volatile pA pA;

    static {
        HandlerThread handlerThread = new HandlerThread("pag__bus_monitor", 0);
        KZx = handlerThread;
        handlerThread.start();
    }

    public static pA pA() {
        if (pA == null) {
            synchronized (KZx.class) {
                if (pA == null) {
                    pA = pA.pA(new Og() { // from class: com.bytedance.sdk.openadsdk.oX.KZx.1
                        @Override // com.bytedance.sdk.openadsdk.oX.Og
                        public Context getContext() {
                            return aBv.pA();
                        }

                        @Override // com.bytedance.sdk.openadsdk.oX.Og
                        public Handler getHandler() {
                            return KZx.ML();
                        }

                        @Override // com.bytedance.sdk.openadsdk.oX.Og
                        public int getUploadIntervalTime() {
                            int iPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("bus_monitor_config", "interval", 43200000);
                            return iPA < 3600000 ? BrandSafetyUtils.g : iPA;
                        }

                        @Override // com.bytedance.sdk.openadsdk.oX.Og
                        public boolean isMonitorOpen() {
                            if (KZx.Og != null) {
                                return KZx.Og.booleanValue();
                            }
                            Boolean unused = KZx.Og = Boolean.valueOf(com.bytedance.sdk.openadsdk.vZF.pA.pA("bus_monitor_config", a.j, 0) == 1);
                            return KZx.Og.booleanValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.oX.Og
                        public void onMonitorUpload(List<com.bytedance.sdk.openadsdk.oX.Og.pA> list) {
                            if (list == null || list.isEmpty()) {
                                return;
                            }
                            for (final com.bytedance.sdk.openadsdk.oX.Og.pA pAVar : list) {
                                com.bytedance.sdk.openadsdk.Sn.KZx.pA();
                                com.bytedance.sdk.openadsdk.Sn.KZx.pA("bus_monitor", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.oX.KZx.1.1
                                    @Override // com.bytedance.sdk.openadsdk.Sn.Og
                                    public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put("sdk_version", pAVar.Og());
                                            jSONObject.put("scene", pAVar.KZx());
                                            jSONObject.put("start_count", pAVar.ZZv());
                                            jSONObject.put("success_count", pAVar.ML());
                                            jSONObject.put("fail_count", pAVar.JG());
                                            jSONObject.put("rit", pAVar.SD());
                                            jSONObject.put("tag", pAVar.omh());
                                            jSONObject.put("label", pAVar.Bzk());
                                            jSONObject.put("mediation", pAVar.BSW());
                                            jSONObject.put("is_init", pAVar.WV());
                                            jSONObject.put("extra", pAVar.Wx());
                                            String string = jSONObject.toString();
                                            new Object[]{"logStr = ", string};
                                            return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("bus_monitor").Og(string);
                                        } catch (Exception e) {
                                            WV.pA("BusMonitorUtils", "onMonitorUpload: ", e);
                                            return null;
                                        }
                                    }
                                });
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.oX.Og
                        public int getOnceLogCount() {
                            int iPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("bus_monitor_config", "once_count", 10);
                            if (iPA > 100 || iPA < 5) {
                                return 10;
                            }
                            return iPA;
                        }

                        @Override // com.bytedance.sdk.openadsdk.oX.Og
                        public int getOnceLogInterval() {
                            int iPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("bus_monitor_config", "once_interval", 10000);
                            if (iPA < 10000) {
                                return 10000;
                            }
                            return iPA;
                        }
                    });
                }
            }
        }
        return pA;
    }

    public static void pA(ZZv zZv) {
        pA().pA(new ML(zZv, 1, 0, 0));
    }

    public static void Og(ZZv zZv) {
        pA().pA(new ML(zZv, 0, 1, 0));
    }

    public static void KZx(ZZv zZv) {
        pA().pA(new ML(zZv, 0, 0, 1));
    }

    public static void Og() {
        pA().pA(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Handler ML() {
        if (KZx == null || !KZx.isAlive()) {
            synchronized (Sn.class) {
                if (KZx == null || !KZx.isAlive()) {
                    HandlerThread handlerThread = new HandlerThread("csj_init_handle", -1);
                    KZx = handlerThread;
                    handlerThread.start();
                    ZZv = new Handler(KZx.getLooper());
                }
            }
        } else if (ZZv == null) {
            synchronized (Sn.class) {
                if (ZZv == null) {
                    ZZv = new Handler(KZx.getLooper());
                }
            }
        }
        return ZZv;
    }
}
