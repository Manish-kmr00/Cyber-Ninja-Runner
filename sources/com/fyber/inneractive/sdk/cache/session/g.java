package com.fyber.inneractive.sdk.cache.session;

import com.pubmatic.sdk.openwrap.core.POBConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1650a;
    public int b;
    public int c;
    public final long d;

    public g(int i, int i2, int i3, long j) {
        this.d = j;
        this.f1650a = i;
        this.b = i2;
        this.c = i3;
    }

    public final JSONObject a(boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        if (z) {
            try {
                jSONObject.put("time", this.d);
            } catch (JSONException unused) {
            }
        }
        jSONObject.put(POBConstants.KEY_IMPRESSION, this.f1650a);
        if (z2) {
            jSONObject.put("com", this.c);
        }
        jSONObject.put("cli", this.b);
        return jSONObject;
    }

    public static g a(JSONObject jSONObject) {
        if (jSONObject != null) {
            long jOptLong = jSONObject.optLong("time");
            int iOptInt = jSONObject.optInt("cli", -1);
            int iOptInt2 = jSONObject.optInt(POBConstants.KEY_IMPRESSION, -1);
            int iOptInt3 = jSONObject.optInt("com", -1);
            if (jOptLong != 0 && iOptInt >= 0 && iOptInt2 >= 0 && iOptInt3 >= 0) {
                return new g(iOptInt2, iOptInt, iOptInt3, jOptLong);
            }
        }
        return null;
    }
}
