package com.yandex.mobile.ads.impl;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
final class po {
    public static byte[] a(byte[] bArr) {
        if (x82.f10629a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(x82.a(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray(UserMetadata.KEYDATA_FILENAME);
            for (int i = 0; i < jSONArray.length(); i++) {
                if (i != 0) {
                    sb.append(StringUtils.COMMA);
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                sb.append("{\"k\":\"");
                sb.append(jSONObject2.getString(CampaignEx.JSON_KEY_AD_K).replace('-', '+').replace('_', '/'));
                sb.append("\",\"kid\":\"");
                sb.append(jSONObject2.getString("kid").replace('-', '+').replace('_', '/'));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return x82.c(sb.toString());
        } catch (JSONException e) {
            at0.a("ClearKeyUtil", "Failed to adjust response data: ".concat(x82.a(bArr)), e);
            return bArr;
        }
    }
}
