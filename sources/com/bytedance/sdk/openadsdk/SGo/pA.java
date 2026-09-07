package com.bytedance.sdk.openadsdk.SGo;

import android.content.Context;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.XT.pA.pA.JG;
import com.bytedance.sdk.openadsdk.XT.pA.pA.SD;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class pA implements KZx {
    private final Map<String, JG> KZx = new HashMap();
    private final Og Og;
    private final yFO pA;

    private pA(Og og, yFO yfo) {
        this.Og = og;
        this.pA = yfo;
    }

    public static pA pA(Og og, yFO yfo) {
        return new pA(og, yfo);
    }

    @Override // com.bytedance.sdk.openadsdk.SGo.KZx
    public void pA() {
        this.KZx.clear();
    }

    private yFO pA(JSONObject jSONObject, String str) {
        String strPA;
        if (jSONObject == null) {
            return null;
        }
        yFO yfoKZx = yFO.KZx();
        yfoKZx.ZZv(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            yfoKZx.vZF(str);
        }
        if (this.pA == null) {
            return yfoKZx;
        }
        String strPA2 = yfoKZx.Wo() != null ? yfoKZx.Wo().pA() : null;
        if (TextUtils.isEmpty(strPA2)) {
            return this.pA;
        }
        com.bytedance.sdk.openadsdk.core.model.KZx kZxWo = this.pA.Wo();
        if (kZxWo != null && strPA2.equals(kZxWo.pA())) {
            return this.pA;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (kZxWo != null) {
            try {
                strPA = kZxWo.pA();
            } catch (JSONException unused) {
            }
        } else {
            strPA = "null";
        }
        jSONObject2.put("lu", strPA);
        jSONObject2.put("ju", strPA2);
        yFO yfo = this.pA;
        com.bytedance.sdk.openadsdk.core.ZZv.pA(yfo, gbA.pA(yfo), -5, jSONObject2);
        if (kZxWo != null && strPA2.contains("play.google.com/store") && !strPA2.contains(Constants.REFERRER)) {
            yfoKZx.Wo().pA(kZxWo.pA());
        }
        return yfoKZx;
    }

    @Override // com.bytedance.sdk.openadsdk.SGo.KZx
    public void pA(Context context, JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        pA(context, pA(jSONObjectOptJSONObject, str), jSONObjectOptJSONObject, i, z);
    }

    private void pA(Context context, yFO yfo, JSONObject jSONObject, int i, boolean z) {
        if (context == null || yfo == null || yfo.Wo() == null || jSONObject == null || this.Og == null || this.KZx.get(yfo.Wo().pA()) != null) {
            return;
        }
        String strOg = gbA.Og(i);
        if (TextUtils.isEmpty(strOg)) {
            return;
        }
        this.KZx.put(yfo.Wo().pA(), pA(context, yfo, jSONObject, strOg, z));
    }

    @Override // com.bytedance.sdk.openadsdk.SGo.KZx
    public void pA(Context context, JSONObject jSONObject, String str) {
        yFO yfo;
        if (context == null || (yfo = this.pA) == null) {
            return;
        }
        SD.pA(context, yfo, str).ZZv();
    }

    @Override // com.bytedance.sdk.openadsdk.SGo.KZx
    public void pA(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        pA(pA(jSONObjectOptJSONObject, (String) null), jSONObjectOptJSONObject);
    }

    private void pA(yFO yfo, JSONObject jSONObject) {
        if (this.Og == null || yfo == null || yfo.Wo() == null) {
            return;
        }
        String strPA = yfo.Wo().pA();
        if (this.KZx.containsKey(strPA)) {
            this.KZx.remove(strPA);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", "success");
                jSONObject2.put("status", "unsubscribed");
                jSONObject2.put("appad", jSONObject);
                this.Og.pA("app_ad_event", jSONObject2);
            } catch (JSONException e) {
                WV.pA("JsAppAdDownloadManager", e.getMessage());
            }
        }
    }

    private JG pA(Context context, yFO yfo, JSONObject jSONObject, String str, boolean z) {
        JG jgPA = SD.pA(context, yfo, str);
        jgPA.pA(true);
        return jgPA;
    }
}
