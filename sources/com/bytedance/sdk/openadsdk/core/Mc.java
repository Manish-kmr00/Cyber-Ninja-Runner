package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.json.fe;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.playon.bridge.Ad;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class Mc implements eG {
    private static final Map<Integer, String> ML = new HashMap<Integer, String>(12) { // from class: com.bytedance.sdk.openadsdk.core.Mc.1
        {
            put(1, "abtest");
            put(2, "user_data");
            put(3, fe.Q0);
            put(4, "apk-sign");
            put(5, CommonUrlParts.APP_SET_ID_SCOPE);
            put(6, CommonUrlParts.APP_SET_ID);
            put(7, "installed_source");
            put(8, "app_running_time");
            put(9, "vendor");
            put(10, "model");
            put(11, "user_agent_device");
            put(12, "user_agent_webview");
            put(13, "sys_compiling_time");
            put(14, "sec_did");
            put(15, "url");
            put(16, "X-Argus");
            put(17, "X-Ladon");
            put(18, "X-Khronos");
            put(19, "X-Gorgon");
            put(20, "pangle_m");
            put(21, CommonUrlParts.SCREEN_HEIGHT);
            put(22, CommonUrlParts.SCREEN_WIDTH);
            put(23, "rom_version");
            put(24, "carrier_name");
            put(25, CommonUrlParts.OS_VERSION);
            put(26, "conn_type");
            put(27, "boot");
            put(28, "feature_data");
            put(29, "t_ver");
            put(30, CampaignEx.JSON_KEY_AAB);
            put(31, "w_ver");
            put(32, "is_fold");
            put(33, "abi");
        }
    };
    boolean pA = false;
    boolean Og = false;
    String KZx = "com.union_test.internationad";
    String ZZv = "8025677";
    private int JG = 0;

    @Override // com.bytedance.sdk.openadsdk.core.eG
    /* JADX INFO: renamed from: ZZv, reason: merged with bridge method [inline-methods] */
    public Mc pA(String str) {
        Bzk.Og().pA(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    /* JADX INFO: renamed from: ML, reason: merged with bridge method [inline-methods] */
    public Mc Og(String str) {
        Bzk.Og().KZx(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public eG pA(int i) {
        Bzk.Og().ML(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public eG pA() {
        com.bytedance.sdk.component.utils.WV.pA("PangleSDK-6508");
        com.bykv.vk.openvk.pA.pA.pA.SD.KZx.pA("PangleSDK-6508");
        com.bytedance.sdk.component.utils.WV.Og();
        com.bytedance.sdk.component.SD.pA.pA();
        com.bykv.vk.openvk.pA.pA.pA.SD.KZx.pA();
        com.bytedance.sdk.openadsdk.utils.TX.pA();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public eG Og(int i) {
        Bzk.Og().Og(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public int Og() {
        return Bzk.Og().omh();
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public eG KZx(int i) {
        Bzk.Og().KZx(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public int KZx() {
        return Bzk.Og().Bzk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public String ZZv() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public String ML() {
        return KZx((String) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public String KZx(String str) {
        int size;
        gbA.SGo("getBiddingToken");
        com.bytedance.sdk.openadsdk.core.Bzk.KZx.pA();
        try {
            JSONObject jSONObject = new JSONObject();
            boolean z = true;
            jSONObject.put("is_init", Sn.ML() ? 1 : 0);
            String strSGo = aBv.ZZv().SGo();
            String strVZF = aBv.ZZv().vZF();
            if (strSGo != null && strVZF != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("version", strSGo);
                jSONObject2.put(Ad.VERIFICATIONPARAM, strVZF);
                jSONObject.put("abtest", jSONObject2);
            }
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("package_name", gbA.ML());
            jSONObject.put("user_data", vZF.pA(TextUtils.isEmpty(str) ? null : new AdSlot.Builder().setCodeId(str).build()));
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
            if (jSONObject.toString().getBytes().length <= 2680) {
                com.bytedance.sdk.openadsdk.core.settings.JG jgZZv = aBv.ZZv();
                if (jgZZv.roi(fe.Q0)) {
                    jSONObject.put(fe.Q0, com.bytedance.sdk.openadsdk.XT.pA.Og.pA.pA().Og());
                }
                jSONObject.put("app_reg", jgZZv.qQU() ? 1 : 0);
                Context contextPA = aBv.pA();
                jSONObject.put("apk-sign", com.bytedance.sdk.openadsdk.common.Og.SD());
                jSONObject.put(CommonUrlParts.APP_SET_ID_SCOPE, com.bytedance.sdk.openadsdk.core.settings.ZZv.Og());
                jSONObject.put(CommonUrlParts.APP_SET_ID, com.bytedance.sdk.openadsdk.core.settings.ZZv.KZx());
                jSONObject.put("installed_source", com.bytedance.sdk.openadsdk.core.settings.ZZv.ZZv());
                jSONObject.put("app_running_time", (System.currentTimeMillis() - Sn.pA()) / 1000);
                jSONObject.put("rewardedfull_link", com.bytedance.sdk.openadsdk.core.settings.oX.vkV().Lm() ? 1 : 0);
                jSONObject.put("js_render_ver", com.bytedance.sdk.openadsdk.core.omh.WV.Og());
                jSONObject.put("js_render_v3_ver", com.bytedance.sdk.openadsdk.core.omh.WV.KZx());
                jSONObject.put("vendor", Build.MANUFACTURER);
                jSONObject.put("model", Build.MODEL);
                jSONObject.put("user_agent_device", gbA.Og());
                jSONObject.put("user_agent_webview", gbA.KZx());
                jSONObject.put("sys_compiling_time", WV.Og(contextPA));
                jSONObject.put(CommonUrlParts.SCREEN_HEIGHT, Vgu.ZZv(contextPA));
                jSONObject.put(CommonUrlParts.SCREEN_WIDTH, Vgu.KZx(contextPA));
                jSONObject.put("rom_version", com.bytedance.sdk.openadsdk.utils.du.pA());
                jSONObject.put("carrier_name", com.bytedance.sdk.openadsdk.utils.roi.pA());
                jSONObject.put(CommonUrlParts.OS_VERSION, Build.VERSION.RELEASE);
                jSONObject.put("conn_type", gbA.WV(contextPA));
                if (jgZZv.roi("boot")) {
                    jSONObject.put("boot", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
                }
                gbA.pA(jSONObject);
                com.bytedance.sdk.openadsdk.core.Bzk.KZx.pA(jSONObject);
                com.bytedance.sdk.openadsdk.utils.JG.pA(jSONObject, contextPA);
                size = ML.size();
            } else {
                size = 2;
            }
            while (size > 0 && jSONObject.toString().getBytes().length > 2680) {
                jSONObject.remove(ML.get(Integer.valueOf(size)));
                size--;
            }
            com.bytedance.sdk.openadsdk.JG.Og.pA().pA(jSONObject);
            if (!com.bytedance.sdk.openadsdk.core.settings.oX.ka() || !com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA(PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN)) {
                z = false;
            }
            JSONObject jSONObjectPA = pA(jSONObject, z);
            while (size > 0 && jSONObjectPA.toString().getBytes().length > 4096) {
                jSONObject.remove(ML.get(Integer.valueOf(size)));
                jSONObjectPA = pA(jSONObject, z);
                size--;
            }
            if (com.bytedance.sdk.component.utils.WV.ZZv()) {
                new StringBuilder("bidding token: ").append(jSONObjectPA).append("\nbidding token length: ");
                int length = jSONObjectPA.toString().getBytes().length;
            }
            new StringBuilder("bidding token: ").append(jSONObjectPA);
            return jSONObjectPA.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private JSONObject pA(JSONObject jSONObject, boolean z) {
        JSONObject jSONObjectPA;
        if (z) {
            jSONObjectPA = PangleEncryptManager.encryptType4(jSONObject, new TX(PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN));
            BF.pA(jSONObjectPA);
        } else {
            jSONObjectPA = com.bytedance.sdk.component.utils.pA.pA(jSONObject);
        }
        return jSONObjectPA != null ? jSONObjectPA : new JSONObject();
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public boolean pA(String str, int i, String str2, String str3, String str4) {
        if (!this.KZx.equals(aBv.pA().getPackageName()) || !this.ZZv.equals(Bzk.Og().ZZv()) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Method methodPA = com.bytedance.sdk.component.utils.WQf.pA("com.bytedance.sdk.openadsdk.TTC3Proxy", "verityPlayable", String.class, Integer.TYPE, String.class, String.class, String.class);
            if (methodPA != null) {
                methodPA.invoke(null, str, Integer.valueOf(i), str2, str3, str4);
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public eG ZZv(int i) {
        Bzk.Og().JG(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public int JG() {
        return Bzk.Og().vZF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public eG ML(int i) {
        this.JG = i;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public int SD() {
        return this.JG;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eG
    public eG JG(int i) {
        Bzk.Og().pA(i);
        return this;
    }
}
