package com.bytedance.sdk.openadsdk.ZZv.pA;

import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class Wx implements com.bytedance.sdk.openadsdk.Sn.Og {
    private final boolean Og;
    private final com.bytedance.sdk.component.JG.pA.JG.ZZv pA;

    public Wx(boolean z, com.bytedance.sdk.component.JG.pA.JG.ZZv zZv) {
        this.pA = zZv;
        this.Og = z;
    }

    @Override // com.bytedance.sdk.openadsdk.Sn.Og
    public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
        int i;
        if (this.pA == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", this.Og);
        jSONObject.put("url", this.pA.Og());
        int iZZv = this.pA.ZZv();
        if (iZZv <= 0) {
            iZZv = 0;
        }
        jSONObject.put("retry_times", iZZv);
        jSONObject.put(CreativeInfo.c, this.pA.JG());
        jSONObject.put("track_type", this.pA.ML());
        if (!this.Og) {
            i = 4;
        } else if (this.pA.SGo()) {
            i = 3;
        } else {
            i = this.pA.ZZv() <= 0 ? 1 : 2;
        }
        jSONObject.put("upload_scene", i);
        String strSD = this.pA.SD();
        if (!TextUtils.isEmpty(strSD)) {
            JSONArray jSONArray = new JSONArray();
            for (String str : strSD.split(StringUtils.COMMA)) {
                jSONArray.put(str);
            }
            jSONObject.put("error_code", jSONArray);
        }
        String strBzk = this.pA.Bzk();
        if (!TextUtils.isEmpty(strBzk)) {
            JSONArray jSONArray2 = new JSONArray();
            for (String str2 : strBzk.split(StringUtils.COMMA)) {
                jSONArray2.put(str2);
            }
            jSONObject.put("error_msg", jSONArray2);
        }
        return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("track_link_result").Og(jSONObject.toString());
    }
}
