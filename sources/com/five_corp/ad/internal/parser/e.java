package com.five_corp.ad.internal.parser;

import android.util.Base64;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import java.nio.charset.StandardCharsets;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class e {
    public static com.five_corp.ad.internal.util.f a(String str) {
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(str, 0), StandardCharsets.UTF_8));
                return new com.five_corp.ad.internal.util.f(true, null, new com.five_corp.ad.internal.ad.b(jSONObject.getString("sl"), jSONObject.getString("ld"), b.a(jSONObject.getJSONObject(Reporting.Key.CLICK_SOURCE_TYPE_AD))));
            } catch (com.five_corp.ad.internal.exception.b e) {
                return new com.five_corp.ad.internal.util.f(false, new o(e.f1373a, "Input: " + str, e, null), null);
            } catch (JSONException e2) {
                return new com.five_corp.ad.internal.util.f(false, new o(p.M5, "Input: " + str, e2, null), null);
            }
        } catch (IllegalArgumentException e3) {
            return new com.five_corp.ad.internal.util.f(false, new o(p.L5, "Input: " + str, e3, null), null);
        }
    }
}
