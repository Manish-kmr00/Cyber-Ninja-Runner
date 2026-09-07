package com.json.mediationsdk.logger;

import com.json.o9;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IronSourceLogger.IronSourceTag f3989a;
    private String b;
    private String c;
    private int d;

    public c(IronSourceLogger.IronSourceTag ironSourceTag, String str, String str2, int i) {
        this.f3989a = ironSourceTag;
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    public int a() {
        return this.d;
    }

    public JSONObject b() {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            jSONObjectJsonObjectInit.put("timestamp", this.b);
            jSONObjectJsonObjectInit.put("tag", this.f3989a);
            jSONObjectJsonObjectInit.put("level", this.d);
            jSONObjectJsonObjectInit.put("message", this.c);
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return jSONObjectJsonObjectInit;
    }
}
