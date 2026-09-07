package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.apm.insight.AttachUserData;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.MonitorCrash;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.openadsdk.ZZv.KZx;
import com.bytedance.sdk.openadsdk.core.WV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.settings.JG;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.json.yk;
import com.smaato.sdk.video.vast.model.Ad;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class ApmHelper {
    private static Og JG;
    private static String KZx;
    private static pA SD;
    private static boolean ZZv;
    private static volatile boolean pA;
    private static final AtomicBoolean Og = new AtomicBoolean(false);
    private static boolean ML = false;

    private interface Og {
        void pA(String str, String str2, Throwable th);
    }

    public static void initApm(final Context context, final InitConfig initConfig) {
        if (Og.compareAndSet(false, true) && !pA) {
            xy.pA(new omh("init-apm") { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!ApmHelper.pA) {
                        JG jgZZv = aBv.ZZv();
                        boolean unused = ApmHelper.ZZv = jgZZv.HSv();
                        if (ApmHelper.ZZv && !TextUtils.isEmpty(jgZZv.xy())) {
                            String unused2 = ApmHelper.KZx = initConfig.getAppId();
                            String[] strArr = {"com.bytedance.sdk.component", "com.bytedance.sdk.mediation", BuildConfig.LIBRARY_PACKAGE_NAME, "com.com.bytedance.overseas.sdk", "com.pgl.ssdk", "com.bykv.vk", "com.iab.omid.library.bytedance2", "com.bytedance.adsdk"};
                            String strPA = WV.pA(context);
                            String strXy = jgZZv.xy();
                            try {
                                final MonitorCrash monitorCrashInitSDK = MonitorCrash.initSDK(context, "10000001", 6508L, BuildConfig.VERSION_NAME, strArr);
                                monitorCrashInitSDK.setCustomDataCallback(new AttachUserData() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.1
                                    @Override // com.apm.insight.AttachUserData
                                    public Map<? extends String, ? extends String> getUserData(CrashType crashType) {
                                        Map<? extends String, ? extends String> mapBzk = ApmHelper.Bzk();
                                        if (mapBzk.containsKey("render_type")) {
                                            monitorCrashInitSDK.addTags("render_type", mapBzk.get("render_type"));
                                        } else {
                                            monitorCrashInitSDK.addTags("render_type", "-2");
                                        }
                                        return mapBzk;
                                    }
                                });
                                if (jgZZv.gy()) {
                                    monitorCrashInitSDK.config().setSoList(new String[]{"libnms.so", "libtobEmbedPagEncrypt.so", "tt_ugen_layout.so"});
                                }
                                monitorCrashInitSDK.config().setDeviceId(strPA);
                                monitorCrashInitSDK.setReportUrl(strXy);
                                monitorCrashInitSDK.addTags("host_appid", ApmHelper.KZx);
                                monitorCrashInitSDK.addTags("sdk_version", BuildConfig.VERSION_NAME);
                                Og unused3 = ApmHelper.JG = new Og() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.2
                                    @Override // com.bytedance.sdk.openadsdk.ApmHelper.Og
                                    public void pA(String str, String str2, Throwable th) {
                                        monitorCrashInitSDK.reportCustomErr(str, str2, th);
                                    }
                                };
                                boolean unused4 = ApmHelper.pA = true;
                                ApmHelper.KZx(strPA, strXy);
                                monitorCrashInitSDK.registerCrashCallback(new ICrashCallback() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.3
                                    @Override // com.apm.insight.ICrashCallback
                                    public void onCrash(CrashType crashType, String str, Thread thread) {
                                        if (!ApmHelper.ML) {
                                            ApmHelper.ZZv(crashType.getName());
                                        }
                                        boolean unused5 = ApmHelper.ML = true;
                                    }
                                }, CrashType.ALL);
                                pA pAVar = ApmHelper.SD;
                                pA unused5 = ApmHelper.SD = null;
                                if (pAVar != null) {
                                    ApmHelper.JG.pA(pAVar.pA, pAVar.Og, pAVar.KZx);
                                }
                            } catch (Throwable unused6) {
                                boolean unused7 = ApmHelper.pA = false;
                            }
                        }
                    }
                    ApmHelper.Og.set(false);
                }
            });
        }
    }

    public static void reportCustomError(String str, String str2, Throwable th) {
        Og og = JG;
        if (og != null) {
            og.pA(str, str2, th);
        } else {
            SD = new pA(str, str2, th);
        }
    }

    private static class pA {
        public final Throwable KZx;
        public final String Og;
        public final String pA;

        public pA(String str, String str2, Throwable th) {
            this.pA = str;
            this.Og = str2;
            this.KZx = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> Bzk() {
        HashMap map = new HashMap();
        yFO yfoPA = com.bytedance.sdk.openadsdk.utils.Og.pA();
        if (yfoPA != null) {
            map.put(Ad.AD_TYPE, String.valueOf(yfoPA.FHA()));
            map.put(yk.SESSION_HISTORY_KEY_AD_ID, String.valueOf(yfoPA.Kj()));
            map.put("cid", yfoPA.nCO());
            map.put("reqId", yfoPA.Ij());
            map.put("rit", yfoPA.TV("-1"));
            int iDu = yfoPA.du();
            if (yfoPA.BF() != 2) {
                iDu = -1;
            }
            map.put("render_type", String.valueOf(iDu));
        }
        return map;
    }

    private static void Og(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        aBv.KZx().pA(KZx(str), "https://" + str2 + "/monitor/collect/c/session?version_code=6508&device_platform=android&aid=10000001");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void KZx(String str, String str2) {
        Og(str, str2);
    }

    public static void reportPvFromBackGround() {
        if (ZZv) {
            Og(WV.pA(aBv.pA()), aBv.ZZv().xy());
        }
    }

    private static JSONObject KZx(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject3.put("host_app_id", KZx);
            jSONObject2.putOpt("custom", jSONObject3);
            jSONObject2.put("os", "Android");
            jSONObject2.put(CommonUrlParts.OS_VERSION, Build.VERSION.RELEASE);
            jSONObject2.put("device_model", Build.MODEL);
            jSONObject2.put("device_brand", Build.BRAND);
            jSONObject2.put("sdk_version_name", "0.0.5");
            jSONObject2.put(yk.SESSION_HISTORY_KEY_AD_ID, "10000001");
            jSONObject2.put("update_version_code", BuildConfig.VERSION_CODE);
            jSONObject2.put("bd_did", str);
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("local_time", Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("local_time_ms", System.currentTimeMillis()));
            jSONObject.putOpt("launch", jSONArray);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("ApmHelper", e.getMessage());
        }
        return jSONObject;
    }

    public static boolean isIsInit() {
        return pA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ZZv(final String str) {
        final yFO yfoPA = com.bytedance.sdk.openadsdk.utils.Og.pA();
        if (yfoPA != null) {
            String strPA = gbA.pA(yfoPA);
            if (TextUtils.isEmpty(strPA)) {
                return;
            }
            KZx.pA(System.currentTimeMillis(), yfoPA, strPA, "sdk_crash_info", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.2
                @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                public JSONObject pA() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("type", str);
                        jSONObject2.put("material", com.bytedance.sdk.component.utils.pA.pA(yfoPA.jO()).toString());
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    } catch (JSONException unused) {
                    }
                    return jSONObject;
                }
            });
        }
    }
}
