package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class XT {
    public static void pA(Context context, boolean z, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str, int i, WebView webView, com.bytedance.sdk.openadsdk.core.widget.JG jg) {
        int iOptInt = jSONObject.optInt("landingStyle");
        String strOptString = jSONObject.optString("url");
        String strOptString2 = jSONObject.optString("fallback_url");
        try {
            jSONObject.put("is_activity", z);
        } catch (JSONException unused) {
        }
        boolean z2 = true;
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str, 1, jSONObject);
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        if (iOptInt == 0) {
            if (webView != null) {
                PangleNetworkBridge.webviewLoadUrl(webView, strOptString);
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str, 2, (JSONObject) null);
            } else {
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str, -1, (JSONObject) null);
            }
        } else if (iOptInt == 1 || iOptInt == 8) {
            com.bytedance.sdk.openadsdk.Sn.pA.Og og = new com.bytedance.sdk.openadsdk.Sn.pA.Og();
            og.pA(com.bytedance.sdk.openadsdk.ZZv.Og.pA.Og);
            og.pA(yfo);
            og.Og(str);
            og.pA(-1);
            og.pA(false);
            og.Og(yfo.JBA());
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(og);
            com.bytedance.sdk.openadsdk.utils.vZF.pA(context, strOptString, yfo, com.bytedance.sdk.openadsdk.ZZv.Og.pA.Og);
        } else if (iOptInt == 2) {
            if (!com.bytedance.sdk.openadsdk.utils.vZF.Og(context, strOptString, yfo, str)) {
                com.bytedance.sdk.openadsdk.Sn.pA.Og og2 = new com.bytedance.sdk.openadsdk.Sn.pA.Og();
                og2.pA(com.bytedance.sdk.openadsdk.ZZv.Og.pA.Og);
                og2.pA(yfo);
                og2.Og(str);
                og2.pA(-1);
                og2.pA(false);
                og2.Og(yfo.JBA());
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(og2);
                HashMap map = new HashMap();
                map.put("deeplink_url", strOptString);
                map.put("fallback_url", strOptString2);
                map.put("jsb_deeplink", 1);
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str, "open_fallback_url", map);
                com.bytedance.sdk.openadsdk.utils.vZF.pA(context, strOptString2, yfo, com.bytedance.sdk.openadsdk.ZZv.Og.pA.Og);
            }
        } else if (iOptInt != 3) {
            z2 = false;
        } else if (rB.Og(context, strOptString, yfo, i, str, false)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str, 3, (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str, -2, (JSONObject) null);
        }
        if (jg == null || !z2) {
            return;
        }
        jg.pA();
    }
}
