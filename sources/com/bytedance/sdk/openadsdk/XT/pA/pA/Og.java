package com.bytedance.sdk.openadsdk.XT.pA.pA;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class Og {
    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.u);
        p0.startActivity(p1);
    }

    public static boolean pA(Context context, String str, yFO yfo) {
        String strPA = gbA.pA(yfo);
        com.bytedance.sdk.openadsdk.core.ZZv.pA(yfo, strPA, 1, null);
        Intent intentPA = pA(context, str);
        if (TextUtils.isEmpty(str) || intentPA == null) {
            com.bytedance.sdk.openadsdk.core.ZZv.pA(yfo, strPA, -2, yfo.Itl().ZZv());
            return false;
        }
        boolean zOmh = gbA.omh(context);
        HashMap map = new HashMap();
        map.put("url", str);
        if (zOmh) {
            gbA.Og Og = gbA.Og(context, intentPA);
            if (Og.Og > 0) {
                try {
                    pA(context, yfo, map);
                    map.put("matched_count", Integer.valueOf(Og.Og));
                    if (Og.pA != null) {
                        intentPA.setComponent(Og.pA);
                    }
                } catch (Throwable th) {
                    WV.pA("DeepLinkUtils", th.getMessage());
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(SDKConstants.PARAM_INTENT, intentPA.toString());
                    jSONObject.put("can_query_install", 1);
                } catch (Exception unused) {
                }
                com.bytedance.sdk.openadsdk.core.ZZv.pA(yfo, strPA, -3, jSONObject);
                return false;
            }
        }
        try {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, strPA, "open_url_app", map);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentPA);
            com.bytedance.sdk.openadsdk.ZZv.WV.pA().pA(map).pA(yfo, strPA);
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA("dp_start_act_success", yfo, strPA, map);
            return true;
        } catch (Throwable th2) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("exception", th2.getMessage());
                jSONObject2.put(SDKConstants.PARAM_INTENT, intentPA.toString());
                jSONObject2.put("can_query_install", zOmh ? 1 : 0);
            } catch (Exception unused2) {
            }
            com.bytedance.sdk.openadsdk.core.ZZv.pA(yfo, strPA, -4, jSONObject2);
            return false;
        }
    }

    private static Intent pA(Context context, String str) {
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            return intent;
        } catch (Throwable th) {
            WV.pA("DeepLinkUtils", th.getMessage());
            return null;
        }
    }

    private static void pA(Context context, yFO yfo, Map<String, Object> map) {
        if (yfo != null && yfo.Lf() == 0) {
            map.put("auto_click", Boolean.valueOf((yfo == null || yfo.ZZv()) ? false : true));
        }
        map.put("can_query_install", Integer.valueOf(gbA.omh(context) ? 1 : 0));
    }
}
