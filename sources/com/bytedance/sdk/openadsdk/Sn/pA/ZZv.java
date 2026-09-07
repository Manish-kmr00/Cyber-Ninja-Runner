package com.bytedance.sdk.openadsdk.Sn.pA;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.Sn.pA.ZZv;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class ZZv<T extends ZZv> implements KZx {
    private String BSW;
    private String Bzk;
    private String KZx;
    private String Og;
    private String SD;
    private String SGo;
    private String WV;
    private String pA;
    private final String ZZv = BuildConfig.VERSION_NAME;
    private long ML = System.currentTimeMillis() / 1000;
    private int JG = 0;
    private int omh = 0;

    private T oX() {
        return this;
    }

    public static ZZv<ZZv> Og() {
        return new ZZv<>();
    }

    @Override // com.bytedance.sdk.openadsdk.Sn.pA.KZx
    @JProtect
    public JSONObject pA() {
        JSONObject jSONObjectJsonObjectInit;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_sdk_version", SD());
            jSONObject.put("app_version", gbA.SD());
            jSONObject.put("timestamp", omh());
            jSONObject.put("conn_type", DX.Og(aBv.pA()));
            jSONObject.put("appid", TextUtils.isEmpty(Bzk.Og().ZZv()) ? "" : Bzk.Og().ZZv());
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, DX());
            if (!TextUtils.isEmpty(KZx())) {
                jSONObject.put("type", KZx());
            }
            jSONObject.put("error_code", BSW());
            if (!TextUtils.isEmpty(WV())) {
                jSONObject.put("error_msg", WV());
            }
            if (!TextUtils.isEmpty(ML())) {
                jSONObject.put("rit", ML());
            }
            if (!TextUtils.isEmpty(JG())) {
                jSONObject.put("creative_id", JG());
            }
            if (Bzk() > 0) {
                jSONObject.put("adtype", Bzk());
            }
            if (!TextUtils.isEmpty(SGo())) {
                jSONObject.put("req_id", SGo());
            }
            if (!TextUtils.isEmpty(Wx())) {
                jSONObject.put("extra", Wx());
            }
            String strZZv = ZZv();
            if (TextUtils.isEmpty(strZZv)) {
                jSONObjectJsonObjectInit = new JSONObject();
            } else {
                try {
                    jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strZZv);
                } catch (Exception unused) {
                    jSONObjectJsonObjectInit = null;
                }
            }
            if (jSONObjectJsonObjectInit != null) {
                jSONObjectJsonObjectInit.put("os_version_int", Build.VERSION.SDK_INT);
                jSONObject.put("event_extra", jSONObjectJsonObjectInit.toString());
            } else if (!TextUtils.isEmpty(strZZv)) {
                jSONObject.put("event_extra", strZZv);
            }
            if (!TextUtils.isEmpty(Sn())) {
                jSONObject.put("duration", Sn());
            }
        } catch (Throwable th) {
            WV.pA("LogStatsBase", th.getMessage());
        }
        return jSONObject;
    }

    @JProtect
    private JSONObject DX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("package_name", gbA.ML());
            jSONObject.put("ua", gbA.KZx());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public String KZx() {
        return this.pA;
    }

    public T pA(String str) {
        this.pA = str;
        return (T) oX();
    }

    public String ZZv() {
        return this.BSW;
    }

    public T Og(String str) {
        this.BSW = str;
        return (T) oX();
    }

    public String ML() {
        return this.Og;
    }

    public T KZx(String str) {
        this.Og = str;
        return (T) oX();
    }

    public String JG() {
        return this.KZx;
    }

    public T ZZv(String str) {
        this.KZx = str;
        return (T) oX();
    }

    public String SD() {
        return TextUtils.isEmpty(BuildConfig.VERSION_NAME) ? "" : BuildConfig.VERSION_NAME;
    }

    public long omh() {
        return this.ML;
    }

    public int Bzk() {
        return this.JG;
    }

    public T pA(int i) {
        this.JG = i;
        return (T) oX();
    }

    public String SGo() {
        return this.SD;
    }

    public T ML(String str) {
        this.SD = str;
        return (T) oX();
    }

    public int BSW() {
        return this.omh;
    }

    public T Og(int i) {
        this.omh = i;
        return (T) oX();
    }

    public String WV() {
        return this.Bzk;
    }

    public T JG(String str) {
        this.Bzk = str;
        return (T) oX();
    }

    public String Wx() {
        return this.SGo;
    }

    public T SD(String str) {
        this.SGo = str;
        return (T) oX();
    }

    public String Sn() {
        return this.WV;
    }

    public T omh(String str) {
        this.WV = str;
        return (T) oX();
    }
}
