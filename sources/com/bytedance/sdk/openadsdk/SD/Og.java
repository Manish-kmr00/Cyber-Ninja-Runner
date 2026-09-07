package com.bytedance.sdk.openadsdk.SD;

import android.text.TextUtils;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.GeckoHubImp;
import com.bykv.vk.openvk.preload.geckox.IThreadPoolCallback;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.Sn.KZx;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Og {
    private static final String[] pA = {"gecko-pangle-sg.byteoversea.com"};

    private static class pA {
        private static final Og pA = new Og();
    }

    public static Og pA() {
        return pA.pA;
    }

    public ILoader Og() {
        try {
            return GeckoHubImp.inst(aBv.pA()).getGeckoResLoader();
        } catch (Throwable th) {
            WV.pA("GeckoHub", "getGeckoResLoader error", th);
            return null;
        }
    }

    private Og() {
        try {
            GeckoHubImp.inst(aBv.pA());
        } catch (Throwable th) {
            WV.pA("GeckoHub", "GeckoHubImp init error", th);
        }
    }

    private static String ZZv() {
        String[] strArrVA = aBv.ZZv().vA();
        if (strArrVA != null) {
            int length = strArrVA.length;
        }
        if (strArrVA == null) {
            strArrVA = pA;
        }
        String str = strArrVA[new SecureRandom().nextInt(strArrVA.length)];
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        SecureRandom secureRandom = new SecureRandom();
        String[] strArr = pA;
        return strArr[secureRandom.nextInt(strArr.length)];
    }

    public void pA(final Map<String, yFO> map) {
        try {
            String strPA = com.bytedance.sdk.openadsdk.core.WV.pA(aBv.pA());
            if (TextUtils.isEmpty(strPA)) {
                return;
            }
            Iterator<yFO> it = map.values().iterator();
            while (it.hasNext()) {
                KZx.Og(it.next());
            }
            GeckoHubImp.setRandomHost(ZZv());
            GeckoHubImp.inst(aBv.pA()).preload(strPA, new IStatisticMonitor() { // from class: com.bytedance.sdk.openadsdk.SD.Og.1
                @Override // com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor
                public void upload(String str, JSONObject jSONObject) {
                    if ("geckosdk_update_stats".equals(str)) {
                        yFO yfo = (yFO) map.get(jSONObject.optString("channel"));
                        if (yfo != null) {
                            com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(str, jSONObject, yfo);
                            return;
                        }
                        return;
                    }
                    if ("download_gecko_end".equals(str)) {
                        Og.Og(map, jSONObject, "");
                    }
                }
            }, map.keySet(), new com.bytedance.sdk.openadsdk.SD.pA());
        } catch (Throwable th) {
            Og(map, null, th.toString());
            WV.pA("GeckoHub", "releaseGeckoResLoader error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og(Map<String, yFO> map, JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                jSONObject2.put("success", false);
                jSONObject2.put("msg", str);
                jSONObject2.put("code", 1);
                jSONObject = jSONObject2;
            }
            Iterator<yFO> it = map.values().iterator();
            while (it.hasNext()) {
                KZx.pA(it.next(), jSONObject);
            }
        } catch (Throwable th) {
            WV.pA("GeckoHub", "upLoadStateEvent error", th);
        }
    }

    public void pA(ILoader iLoader) {
        if (iLoader != null) {
            try {
                GeckoHubImp.inst(aBv.pA()).releaseGeckoResLoader(iLoader);
            } catch (Throwable th) {
                WV.pA("GeckoHub", "releaseGeckoResLoader error", th);
            }
        }
    }

    public WebResourceResponseModel pA(ILoader iLoader, String str, String str2) {
        if (iLoader == null) {
            return null;
        }
        try {
            return GeckoHubImp.inst(aBv.pA()).findResAndMsg(iLoader, str, str2);
        } catch (Throwable th) {
            WV.pA("GeckoHub", "findRes error", th);
            return null;
        }
    }

    public int pA(ILoader iLoader, String str) {
        try {
            return GeckoHubImp.inst(aBv.pA()).getResCount(iLoader, str);
        } catch (Throwable th) {
            WV.pA("GeckoHub", "getResCount error", th);
            return 0;
        }
    }

    public static void KZx() {
        try {
            GeckoHubImp.setThreadPoolExecutorCallback(new IThreadPoolCallback() { // from class: com.bytedance.sdk.openadsdk.SD.Og.2
                @Override // com.bykv.vk.openvk.preload.geckox.IThreadPoolCallback
                public ExecutorService getThreadPool() {
                    return xy.ZZv();
                }
            });
        } catch (Throwable th) {
            WV.pA("GeckoHub", "setThreadPoolExecutor error", th);
        }
    }
}
