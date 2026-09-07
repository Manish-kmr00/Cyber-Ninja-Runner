package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.util.d0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class T implements U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1681a;
    public String b;
    public M c;
    public P d;
    public Q e;
    public V f;
    public W g;

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        d0.a(jSONObject, "id", this.f1681a);
        d0.a(jSONObject, "spotId", this.b);
        d0.a(jSONObject, "display", this.c);
        d0.a(jSONObject, "monitor", this.d);
        d0.a(jSONObject, "native", this.e);
        d0.a(jSONObject, "video", this.f);
        d0.a(jSONObject, "viewability", this.g);
        return jSONObject.toString();
    }
}
