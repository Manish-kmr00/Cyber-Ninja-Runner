package com.bytedance.sdk.openadsdk.ZZv.pA;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.BF;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.du;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.roi;
import com.json.yk;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class KZx {
    private final Context KZx;
    private final String ML;
    private int Og;
    private final boolean ZZv;
    private long pA;

    private static class pA {
        private static final KZx pA = new KZx();
    }

    public static KZx pA() {
        return pA.pA;
    }

    private KZx() {
        this.ZZv = KZx();
        this.KZx = aBv.pA().getApplicationContext();
        this.ML = ML();
    }

    public String pA(List<com.bytedance.sdk.openadsdk.ZZv.pA> list) {
        String strOptString;
        if (list.size() > 0 && list.get(0) != null && list.get(0).KZx() != null) {
            strOptString = list.get(0).KZx().optString("app_log_url");
        } else {
            strOptString = "";
        }
        return gbA.ML(strOptString);
    }

    private void pA(com.bytedance.sdk.openadsdk.ZZv.pA pAVar, boolean z) {
        if (pAVar == null) {
            return;
        }
        try {
            String strOptString = z ? pAVar.KZx().optJSONObject("params").optString("log_extra", "") : pAVar.KZx().optString("log_extra", "");
            long jPA = yFO.pA(strOptString);
            int iZZv = yFO.ZZv(strOptString);
            if (jPA == 0) {
                jPA = this.pA;
            }
            this.pA = jPA;
            if (iZZv == 0) {
                iZZv = this.Og;
            }
            this.Og = iZZv;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("AdLogParamsGenerate", "getInfoFromLogExtra exception", e.getMessage());
        }
    }

    public JSONObject pA(List<com.bytedance.sdk.openadsdk.ZZv.pA> list, long j, JSONObject jSONObject, boolean z) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            pA(list.get(0), z);
            jSONObject2.put("header", jSONObject);
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.sdk.openadsdk.ZZv.pA> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().pA(z));
            }
            if (z) {
                jSONObject2.put("event_v3", jSONArray);
                jSONObject2.put("magic_tag", "ss_app_log");
            } else {
                jSONObject2.put("event", jSONArray);
            }
            jSONObject2.put("_gen_time", j);
            jSONObject2.put("local_time", j / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public List<com.bytedance.sdk.openadsdk.ZZv.pA> pA(List<com.bytedance.sdk.openadsdk.ZZv.pA> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.ZZv.pA pAVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObjectKZx = pAVar.KZx();
                jSONObject.putOpt("event", jSONObjectKZx.optString("label"));
                long jOptLong = jSONObjectKZx.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(jOptLong));
                jSONObject.putOpt("datetime", com.bytedance.sdk.openadsdk.ZZv.JG.KZx.format(new Date(jOptLong)));
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> itKeys = jSONObjectKZx.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.equals(next, "label")) {
                        jSONObject2.putOpt(next, jSONObjectKZx.opt(next));
                    }
                }
                if (z) {
                    jSONObject2.putOpt("_ad_staging_flag", 3);
                }
                jSONObject.putOpt("params", jSONObject2);
                arrayList.add(new com.bytedance.sdk.openadsdk.ZZv.JG(pAVar.pA, jSONObject));
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("AdLogParamsGenerate", e.getMessage());
            }
        }
        return arrayList;
    }

    public List<com.bytedance.sdk.openadsdk.ZZv.pA> Og(List<com.bytedance.sdk.openadsdk.ZZv.pA> list) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.ZZv.pA pAVar : list) {
            try {
                JSONObject jSONObjectKZx = pAVar.KZx();
                jSONObjectKZx.putOpt("_ad_staging_flag", 1);
                arrayList.add(new com.bytedance.sdk.openadsdk.ZZv.pA(pAVar.pA, jSONObjectKZx));
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("AdLogParamsGenerate", e.getMessage());
            }
        }
        return arrayList;
    }

    @JProtect
    public JSONObject Og() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", gbA.KZx());
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("app_version", gbA.SD());
            jSONObject.put("sim_op", pA(this.KZx));
            jSONObject.put("root", this.ZZv ? 1 : 0);
            jSONObject.put("timezone", ZZv());
            jSONObject.put("access", BF.pA(this.KZx));
            jSONObject.put("os", "Android");
            jSONObject.put(CommonUrlParts.OS_VERSION, Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(CommonUrlParts.DEVICE_TYPE, this.ML);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put(POBConstants.KEY_LANGUAGE, Locale.getDefault().getLanguage());
            jSONObject.put("resolution", Vgu.ZZv(this.KZx) + VastAttributes.HORIZONTAL_POSITION + Vgu.KZx(this.KZx));
            jSONObject.put("display_density", pA(Vgu.SD(this.KZx)));
            jSONObject.put("density_dpi", Vgu.SD(this.KZx));
            jSONObject.put(yk.SESSION_HISTORY_KEY_AD_ID, "1371");
            jSONObject.put("device_id", com.bytedance.sdk.openadsdk.core.WV.pA(this.KZx));
            jSONObject.put("rom", JG());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("ut", this.Og);
            jSONObject.put("uid", this.pA);
            jSONObject.put("google_aid", com.bytedance.sdk.openadsdk.XT.pA.Og.pA.pA().Og());
            jSONObject.put("locale_language", DeviceUtils.ZZv());
            jSONObject.put("screen_bright", Math.ceil(DeviceUtils.ML() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", !DeviceUtils.Og() ? 1 : 0);
            com.bytedance.sdk.openadsdk.core.settings.JG jgZZv = aBv.ZZv();
            jSONObject.put("force_language", com.bytedance.sdk.component.utils.yFO.pA(this.KZx, "tt_choose_language"));
            if (jgZZv.roi("mnc")) {
                jSONObject.put("mnc", roi.KZx());
            }
            if (jgZZv.roi("mcc")) {
                jSONObject.put("mcc", roi.Og());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String pA(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            return telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    private boolean KZx() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private int ZZv() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    private String ML() {
        if (DeviceUtils.KZx(this.KZx)) {
            return "tv";
        }
        if (DeviceUtils.Og(this.KZx)) {
            return "android_pad";
        }
        return "android";
    }

    private String pA(int i) {
        if (i == 120) {
            return "ldpi";
        }
        if (i == 160) {
            return "mdpi";
        }
        if (i == 240) {
            return "hdpi";
        }
        if (i == 320) {
            return "xhdpi";
        }
        if (i == 480) {
            return "xxhdpi";
        }
        if (i != 640) {
            return "mdpi";
        }
        return "xxxhdpi";
    }

    @JProtect
    private String JG() {
        StringBuilder sb = new StringBuilder();
        try {
            if (du.ML()) {
                sb.append("MIUI-");
            } else if (du.Og()) {
                sb.append("FLYME-");
            } else {
                String strSn = du.Sn();
                if (du.pA(strSn)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strSn)) {
                    sb.append(strSn).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
