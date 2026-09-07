package com.safedk.android.analytics.brandsafety.creatives;

import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class d extends c {
    private static final String b = "bundleId";
    private static final String c = "dynamicMarkup";

    public d(JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.c
    public c.a a() {
        c.a aVarA = super.a();
        if (this.f8062a.optString("bundleId", null) == null) {
            aVarA.b = a(aVarA.d);
        }
        return aVarA;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.c
    protected String a(JSONObject jSONObject) throws JSONException {
        return jSONObject.getString(c);
    }

    private String a(String str) {
        Matcher matcher = com.safedk.android.utils.g.N().matcher(str);
        if (!matcher.find() || matcher.groupCount() <= 0) {
            return null;
        }
        return matcher.group(1);
    }
}
