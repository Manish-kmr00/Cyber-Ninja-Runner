package io.appmetrica.analytics.impl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class Mi extends Gg {
    public final Cif b;

    public Mi(C4282m5 c4282m5) {
        this(c4282m5, C4486ua.j().s());
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        JSONObject jSONObjectOptJSONObject;
        try {
            jSONObjectOptJSONObject = new JSONObject(c3984a6.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObjectOptJSONObject = null;
        }
        this.b.b(C4118ff.a(jSONObjectOptJSONObject));
        return false;
    }

    public Mi(C4282m5 c4282m5, Cif cif) {
        super(c4282m5);
        this.b = cif;
    }
}
