package com.bytedance.sdk.openadsdk.ZZv.pA;

import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.concurrent.atomic.AtomicInteger;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class JG {
    public static AtomicInteger pA = new AtomicInteger(0);
    public static AtomicInteger Og = new AtomicInteger(0);
    public static AtomicInteger KZx = new AtomicInteger(0);
    public static AtomicInteger ZZv = new AtomicInteger(0);
    public static AtomicInteger ML = new AtomicInteger(0);
    public static AtomicInteger JG = new AtomicInteger(0);
    public static AtomicInteger SD = new AtomicInteger(0);
    public static AtomicInteger omh = new AtomicInteger(0);
    public static AtomicInteger Bzk = new AtomicInteger(0);

    public static void pA() {
        try {
            long jPA = com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_get_ad", "get_ad_event_time_key", 0L);
            if (jPA > 0 && System.currentTimeMillis() - jPA >= 86400000) {
                Og();
                com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_get_ad", "get_ad_event_time_key", Long.valueOf(System.currentTimeMillis()));
                return;
            }
            if (jPA <= 0 || jPA > System.currentTimeMillis()) {
                com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_get_ad", "get_ad_event_time_key", Long.valueOf(System.currentTimeMillis()));
            }
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(com.bytedance.sdk.openadsdk.multipro.ZZv.pA.Og("tt_sdk_event_get_ad", "get_ad_event_key", ""));
            int iOptInt = jSONObjectJsonObjectInit.optInt("load_get_ad_version", 0);
            if (iOptInt >= 5702 && (iOptInt < 5800 || iOptInt >= 5802)) {
                pA.addAndGet(jSONObjectJsonObjectInit.optInt("load_times"));
                Og.addAndGet(jSONObjectJsonObjectInit.optInt("load_success"));
                KZx.addAndGet(jSONObjectJsonObjectInit.optInt(Reporting.EventType.LOAD_FAIL));
                ZZv.addAndGet(jSONObjectJsonObjectInit.optInt("load_success_and_parse_success"));
                ML.addAndGet(jSONObjectJsonObjectInit.optInt("load_success_and_parse_fail"));
                JG.addAndGet(jSONObjectJsonObjectInit.optInt("load_success_and_no_ad"));
                SD.addAndGet(jSONObjectJsonObjectInit.optInt("load_fail_by_no_net"));
                omh.addAndGet(jSONObjectJsonObjectInit.optInt("load_fail_by_io"));
                Bzk.addAndGet(jSONObjectJsonObjectInit.optInt("load_fail_in_background"));
                return;
            }
            com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_get_ad");
        } catch (Throwable unused) {
        }
    }

    public static void Og() {
        try {
            com.bytedance.sdk.openadsdk.Sn.KZx.pA().pA("pangle_sdk_get_ad_track", com.bytedance.sdk.openadsdk.multipro.ZZv.pA.Og("tt_sdk_event_get_ad", "get_ad_event_key", ""));
            com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_get_ad");
        } catch (Throwable unused) {
        }
    }

    public static void KZx() {
        try {
            com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_get_ad", "get_ad_event_key", ZZv().toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONObject ZZv() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("load_times", pA.get());
            jSONObject.put("load_success", Og.get());
            jSONObject.put(Reporting.EventType.LOAD_FAIL, KZx.get());
            jSONObject.put("load_fail_in_background", Bzk.get());
            jSONObject.put("load_success_and_parse_success", ZZv.get());
            jSONObject.put("load_success_and_parse_fail", ML.get());
            jSONObject.put("load_success_and_no_ad", JG.get());
            jSONObject.put("load_fail_by_no_net", SD.get());
            jSONObject.put("load_fail_by_io", omh.get());
            jSONObject.put("load_get_ad_version", BuildConfig.VERSION_CODE);
            return jSONObject;
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void pA(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("msg", str);
            com.bytedance.sdk.openadsdk.Sn.KZx.pA().pA("pangle_sdk_client_load_error", jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void ML() {
        try {
            if (DeviceUtils.Og()) {
                return;
            }
            Bzk.incrementAndGet();
        } catch (Throwable unused) {
        }
    }
}
