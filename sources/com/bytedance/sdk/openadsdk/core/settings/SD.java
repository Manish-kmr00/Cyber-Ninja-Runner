package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.ArrayList;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class SD {
    public boolean JG;
    public String KZx;
    public boolean ML;
    public boolean ZZv;
    public static final SD pA = new SD(null);
    public static String Og = "";

    public SD(String str) {
        this.KZx = "https://sf19-static.i18n-pglstatp.com/obj/ad-pattern-sg/3p_monitor.9db44671.js";
        this.ZZv = true;
        this.ML = true;
        this.JG = true;
        try {
            JSONObject jSONObjectOptJSONObject = PangleNetworkBridge.jsonObjectInit(str).optJSONObject("performance_js");
            String strOptString = jSONObjectOptJSONObject.optString("url", "https://sf19-static.i18n-pglstatp.com/obj/ad-pattern-sg/3p_monitor.9db44671.js");
            if (!TextUtils.isEmpty(strOptString)) {
                this.KZx = strOptString;
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("execute_time");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(jSONArrayOptJSONArray.optString(i));
            }
            this.ZZv = arrayList.contains("load_finish");
            this.JG = arrayList.contains(Reporting.EventType.LOAD_FAIL);
            this.ML = arrayList.contains("load");
        } catch (Exception unused) {
        }
    }
}
