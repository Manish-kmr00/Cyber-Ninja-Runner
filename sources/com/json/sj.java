package com.json;

import com.json.mediationsdk.logger.IronLog;
import com.json.sdk.utils.SDKUtils;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class sj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4423a;
    private String e;
    private Map<String, String> f;
    private final io g;
    private boolean h;
    private boolean b = false;
    private boolean c = false;
    private tg d = null;
    protected boolean i = false;
    protected String j = null;

    public sj(String str, io ioVar) throws NullPointerException {
        this.f4423a = SDKUtils.requireNonEmptyOrNull(str, "Instance name can't be null");
        this.g = (io) SDKUtils.requireNonNull(ioVar, "AdListener name can't be null");
    }

    public rj a() {
        return new rj(b(), this.f4423a, this.b, this.c, this.h, this.i, this.j, this.f, this.g, this.d);
    }

    public sj a(tg tgVar) {
        this.d = tgVar;
        return this;
    }

    public sj a(String str) {
        this.e = str;
        return this;
    }

    public sj a(Map<String, String> map) {
        this.f = map;
        return this;
    }

    public sj a(boolean z) {
        this.c = z;
        return this;
    }

    public sj b(String str) {
        this.j = str;
        return this;
    }

    public sj b(boolean z) {
        this.i = z;
        return this;
    }

    public String b() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            jSONObjectJsonObjectInit.put("name", this.f4423a);
            jSONObjectJsonObjectInit.put("rewarded", this.b);
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return (this.c || this.h) ? ck.a() : ck.a(jSONObjectJsonObjectInit);
    }

    public sj c() {
        this.b = true;
        return this;
    }

    public sj c(boolean z) {
        this.h = z;
        return this;
    }
}
