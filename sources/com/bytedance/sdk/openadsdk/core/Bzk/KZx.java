package com.bytedance.sdk.openadsdk.core.Bzk;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.sdk.component.utils.ML;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.pgl.ssdk.ces.out.PglSSManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class KZx {
    private static boolean pA;

    public static void pA() {
        if (!pA && aBv.ZZv().JBA()) {
            Og.Og();
            pA = Og.Og().KZx();
        }
    }

    public static void pA(String str) {
        if (TextUtils.isEmpty(str) && aBv.ZZv().JBA()) {
            Og.Og().pA(str);
        }
    }

    public static void Og(String str) {
        if (TextUtils.isEmpty(str) || !aBv.ZZv().JBA()) {
            return;
        }
        Og.Og().Og(str);
    }

    public static void Og() {
        if (aBv.ZZv().JBA()) {
            Og.Og().pA();
        }
    }

    public static void pA(yFO yfo, String str) {
        long jOptLong;
        long jOptLong2;
        long jOptLong3;
        Object obj;
        if (aBv.ZZv().JBA()) {
            HashMap map = new HashMap();
            map.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            map.put("au_show", str);
            if (yfo != null) {
                String strIj = yfo.Ij();
                String strOptString = "-1";
                if (!TextUtils.isEmpty(strIj)) {
                    map.put("request_id", strIj);
                } else {
                    map.put("request_id", "-1");
                }
                try {
                    long j = -1;
                    if (yfo.fg() != null) {
                        jOptLong = yfo.fg().optLong(CreativeInfo.c, -1L);
                        jOptLong2 = yfo.fg().optLong("rit", -1L);
                        jOptLong3 = yfo.fg().optLong("ad_slot_type", -1L);
                        strOptString = yfo.fg().optString("ad_type", "-1");
                    } else {
                        jOptLong = -1;
                        jOptLong2 = -1;
                        jOptLong3 = -1;
                    }
                    map.put(CreativeInfo.c, Long.valueOf(jOptLong));
                    map.put("rit", Long.valueOf(jOptLong2));
                    map.put("ad_slot_type", Long.valueOf(jOptLong3));
                    map.put("ad_type", strOptString);
                    Map<String, Object> mapTZW = yfo.tZW();
                    if (mapTZW != null && (obj = mapTZW.get(TTAdConstant.SDK_BIDDING_TYPE)) != null) {
                        j = Long.parseLong(obj.toString());
                    }
                    map.put(TTAdConstant.SDK_BIDDING_TYPE, Long.valueOf(j));
                    Og.Og().pA(PglSSManager.REPORT_SCENE_ADSHOW, map);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static Map<String, String> pA(String str, String str2) {
        if (aBv.ZZv().JBA()) {
            return Og.Og().pA(str, str2 != null ? str2.getBytes() : new byte[0]);
        }
        return new HashMap();
    }

    public static String KZx() {
        if (aBv.ZZv().JBA()) {
            return Og.Og().ML();
        }
        return "";
    }

    public static long ZZv() {
        if (aBv.ZZv().JBA()) {
            return Og.Og().JG();
        }
        return 0L;
    }

    public static int ML() {
        if (aBv.ZZv().JBA()) {
            return Og.Og().SD();
        }
        return 6;
    }

    public static void pA(MotionEvent motionEvent) {
        if (aBv.ZZv().JBA()) {
            Og.Og().pA(motionEvent);
        }
    }

    public static void pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (aBv.ZZv().JBA()) {
                pA();
                if (ML() == 0) {
                    jSONObject.put("sec_did", Og.Og().ZZv());
                    String strPA = ML.pA(jSONObject.toString());
                    Map<String, String> mapPA = Og.Og().pA("https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250", strPA != null ? strPA.getBytes() : new byte[0]);
                    if (mapPA != null && mapPA.size() > 0) {
                        for (String str : mapPA.keySet()) {
                            jSONObject.put(str, mapPA.get(str));
                        }
                        jSONObject.put("url", "https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250");
                        jSONObject.put("pangle_m", strPA);
                    } else {
                        jSONObject.put("pglx", "8");
                    }
                    jSONObject.put("ec", Og.Og().JG());
                    return;
                }
                jSONObject.put("pglx", String.valueOf(ML()));
                return;
            }
            jSONObject.put("pglx", "6");
        } catch (Throwable th) {
            WV.pA("SecSdkHelperUtil", th.getMessage());
            try {
                jSONObject.put("pglx", "7");
            } catch (JSONException unused) {
            }
        }
    }

    public static String JG() {
        if (aBv.ZZv().JBA()) {
            return Og.Og().ZZv();
        }
        return null;
    }
}
