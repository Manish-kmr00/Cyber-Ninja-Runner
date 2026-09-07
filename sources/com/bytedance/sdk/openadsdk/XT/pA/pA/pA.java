package com.bytedance.sdk.openadsdk.XT.pA.pA;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ZZv.WV;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class pA extends ZZv {
    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.u);
        p0.startActivity(p1);
    }

    public pA(Context context, yFO yfo, String str) {
        super(context, yfo, str);
    }

    @Override // com.bytedance.sdk.openadsdk.XT.pA.pA.ZZv, com.bytedance.sdk.openadsdk.XT.pA.pA.JG
    public boolean pA() {
        HashMap map;
        if (this.pA == null) {
            return false;
        }
        if (this.Og == null || this.Og.Lf() != 0) {
            map = null;
        } else {
            map = new HashMap();
            map.put("dpl_probability_jump", Boolean.valueOf(this.JG >= 11));
        }
        return pA(this.Og, this.pA.KZx(), KZx(), this.KZx, map);
    }

    public static boolean pA(yFO yfo, String str, Context context, String str2, Map<String, Object> map) {
        Intent intentPA;
        if (yfo != null && yfo.Lm() == 0) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(str) || (intentPA = gbA.pA(context, str)) == null) {
                return false;
            }
            intentPA.putExtra("START_ONLY_FOR_ANDROID", true);
            if (!(context instanceof Activity)) {
                intentPA.addFlags(268435456);
            }
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentPA);
            if (map == null) {
                map = new HashMap<>();
            }
            pA(yfo, map);
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str2, "click_open", map);
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void pA(yFO yfo, Map<String, Object> map) {
        if (map == null) {
            return;
        }
        if (yfo != null && yfo.Lf() == 0) {
            map.put("auto_click", Boolean.valueOf((yfo == null || yfo.ZZv()) ? false : true));
        }
        map.put("can_query_install", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.XT.pA.pA.ZZv
    public boolean Og() {
        com.bytedance.sdk.openadsdk.core.ZZv.pA(this.Og, this.KZx, 1, null);
        if (this.Og.Itl() != null) {
            HashMap map = new HashMap();
            if (this.Og != null && this.Og.Lf() == 0) {
                map.put("dpl_probability_jump", Boolean.valueOf(this.JG >= 11));
            }
            if (pA(this.Og.Itl().pA(), KZx(), this.KZx, this.Og, map)) {
                return true;
            }
            if (!this.ZZv || this.ML.get()) {
                this.ZZv = true;
                pA(this.Og, map);
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.Og, this.KZx, "open_fallback_url", map);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.ZZv.pA(this.Og, this.KZx, -1, null);
        }
        return false;
    }

    public static boolean pA(String str, Context context, String str2, yFO yfo, Map<String, Object> map) {
        Intent intent = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                Uri uri = Uri.parse(str);
                Intent intent2 = new Intent("android.intent.action.VIEW");
                try {
                    intent2.setData(uri);
                    if (!(context instanceof Activity)) {
                        intent2.addFlags(268435456);
                    }
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    pA(yfo, map);
                    map.put("url", str);
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str2, "open_url_app", map);
                    safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent2);
                    WV.pA().pA(map).pA(yfo, str2);
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA("dp_start_act_success", yfo, str2, map);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    intent = intent2;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("exception", th.getMessage());
                        if (intent != null) {
                            jSONObject.put(SDKConstants.PARAM_INTENT, intent.toString());
                        }
                        jSONObject.put("can_query_install", 0);
                    } catch (Exception unused) {
                    }
                    com.bytedance.sdk.openadsdk.core.ZZv.pA(yfo, str2, -4, jSONObject);
                    return false;
                }
            }
            com.bytedance.sdk.openadsdk.core.ZZv.pA(yfo, str2, -2, null);
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
