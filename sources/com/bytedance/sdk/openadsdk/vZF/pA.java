package com.bytedance.sdk.openadsdk.vZF;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.BF;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.oX.ZZv;
import com.bytedance.sdk.openadsdk.p002Sd.JG;
import com.bytedance.sdk.openadsdk.p002Sd.KZx;
import com.bytedance.sdk.openadsdk.p002Sd.ML;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.json.mediationsdk.metadata.a;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class pA {
    private static volatile ML Og;
    public static final ConcurrentHashMap<String, Object> pA = new ConcurrentHashMap<>();

    public static ML pA(final Context context, final String str) {
        if (Og == null) {
            synchronized (pA.class) {
                if (Og == null) {
                    try {
                        ML ml = new ML(new JG() { // from class: com.bytedance.sdk.openadsdk.vZF.pA.1
                            @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
                            public ExecutorService pA() {
                                return xy.ZZv();
                            }

                            @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
                            public Context Og() {
                                Context context2 = context;
                                return context2 != null ? context2 : aBv.pA();
                            }

                            @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
                            public String KZx() {
                                return "pag_adn_strategy_center";
                            }

                            @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
                            public Handler ZZv() {
                                return Sn.Og();
                            }

                            @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
                            public String ML() {
                                return gbA.ZZv("/api/ad/union/sdk/strategies/adn");
                            }

                            @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
                            public JSONObject JG() {
                                try {
                                    JSONObject jSONObjectPA = com.bytedance.sdk.openadsdk.core.settings.Sn.pA(BF.pA(aBv.pA(), 0L));
                                    if (!jSONObjectPA.has("app_id")) {
                                        if (!TextUtils.isEmpty(str)) {
                                            jSONObjectPA.put("app_id", str);
                                        } else {
                                            if (TextUtils.isEmpty(Bzk.Og().ZZv())) {
                                                return null;
                                            }
                                            jSONObjectPA.put("app_id", Bzk.Og().ZZv());
                                        }
                                    }
                                    return com.bytedance.sdk.component.utils.pA.pA(jSONObjectPA);
                                } catch (Throwable th) {
                                    WV.pA("StrategyUtils", th.getMessage());
                                    return null;
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
                            public Map<String, String> SD() {
                                HashMap map = new HashMap();
                                map.put("User-Agent", gbA.KZx());
                                return map;
                            }

                            @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
                            public JSONObject pA(JSONObject jSONObject) {
                                int iOptInt = jSONObject.optInt("cypher", -1);
                                if (iOptInt == -1 || iOptInt != 3) {
                                    return jSONObject;
                                }
                                String strKZx = com.bytedance.sdk.component.utils.pA.KZx(jSONObject.optString("message"));
                                if (TextUtils.isEmpty(strKZx)) {
                                    return jSONObject;
                                }
                                try {
                                    return PangleNetworkBridge.jsonObjectInit(strKZx);
                                } catch (Throwable unused) {
                                    return jSONObject;
                                }
                            }
                        });
                        Og = ml;
                        ml.pA(new KZx() { // from class: com.bytedance.sdk.openadsdk.vZF.pA.2
                            @Override // com.bytedance.sdk.openadsdk.p002Sd.KZx
                            public void pA() {
                                com.bytedance.sdk.openadsdk.oX.KZx.pA(new ZZv() { // from class: com.bytedance.sdk.openadsdk.vZF.pA.2.1
                                    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                        com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                        pAVar.Og("strategy_fetch");
                                        return pAVar;
                                    }
                                });
                            }

                            @Override // com.bytedance.sdk.openadsdk.p002Sd.KZx
                            public void Og() {
                                com.bytedance.sdk.openadsdk.oX.KZx.Og(new ZZv() { // from class: com.bytedance.sdk.openadsdk.vZF.pA.2.2
                                    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                        com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                        pAVar.Og("strategy_fetch");
                                        return pAVar;
                                    }
                                });
                                com.bytedance.sdk.openadsdk.JG.pA.pA().Og();
                                com.bytedance.sdk.openadsdk.yFO.pA.KZx.pA().Og();
                                com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv.KZx(!com.bytedance.sdk.openadsdk.core.Wx.ML.pA.pA());
                            }

                            @Override // com.bytedance.sdk.openadsdk.p002Sd.KZx
                            public void pA(int i, String str2) {
                                com.bytedance.sdk.openadsdk.oX.KZx.KZx(new ZZv() { // from class: com.bytedance.sdk.openadsdk.vZF.pA.2.3
                                    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                        com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                        pAVar.Og("strategy_fetch");
                                        return pAVar;
                                    }
                                });
                            }
                        });
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
            }
        }
        return Og;
    }

    private static ML SD() {
        return pA(aBv.pA(), Bzk.Og().ZZv());
    }

    public static int pA(String str, int i) {
        ML mlSD = SD();
        return mlSD != null ? mlSD.pA(str, i) : i;
    }

    public static boolean pA(String str, boolean z) {
        ML mlSD = SD();
        return mlSD != null ? mlSD.pA(str, z) : z;
    }

    public static String pA(String str, String str2) {
        ML mlSD = SD();
        return mlSD != null ? mlSD.pA(str, str2) : str2;
    }

    public static int pA(String str, String str2, int i) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str + "_" + str2;
            ConcurrentHashMap<String, Object> concurrentHashMap = pA;
            Object obj = concurrentHashMap.get(str3);
            if (obj != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
            try {
                String strPA = SD().pA(str, "");
                if (TextUtils.isEmpty(strPA)) {
                    return i;
                }
                int iOptInt = PangleNetworkBridge.jsonObjectInit(strPA).optInt(str2, i);
                concurrentHashMap.put(str3, Integer.valueOf(iOptInt));
                return iOptInt;
            } catch (Throwable th) {
                WV.pA("StrategyUtils", th.getMessage());
            }
        }
        return i;
    }

    public static String pA(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str4 = str + "_" + str2;
            ConcurrentHashMap<String, Object> concurrentHashMap = pA;
            Object obj = concurrentHashMap.get(str4);
            if (obj != null && (obj instanceof String)) {
                return (String) obj;
            }
            try {
                String strPA = SD().pA(str, "");
                if (TextUtils.isEmpty(strPA)) {
                    return str3;
                }
                String strOptString = PangleNetworkBridge.jsonObjectInit(strPA).optString(str2, str3);
                concurrentHashMap.put(str4, strOptString);
                return strOptString;
            } catch (Throwable th) {
                WV.pA("StrategyUtils", th.getMessage());
            }
        }
        return str3;
    }

    public static void pA() {
        ML mlSD = SD();
        if (mlSD != null) {
            mlSD.pA();
        }
    }

    public static boolean Og() {
        return pA("ad_load_and_render_opt", a.j, 0) == 1;
    }

    public static boolean KZx() {
        return Og() && pA("ad_load_and_render_opt", "thread_switch_opt", 0) == 1;
    }

    public static boolean ZZv() {
        return Og() && pA("ad_load_and_render_opt", "sync_barrier_switch_opt", 0) == 1;
    }

    public static int ML() {
        if (Og()) {
            return pA("ad_load_and_render_opt", "webview_preload_cache", 0);
        }
        return 0;
    }

    public static int JG() {
        if (Og()) {
            return pA("ad_load_and_render_opt", "webview_preload_cache_v3", 0);
        }
        return 0;
    }
}
