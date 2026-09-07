package sg.bigo.ads.controller.c;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements sg.bigo.ads.api.core.o.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13421a;
    private final int b;
    private final String c;
    private final String d;

    public i(JSONObject jSONObject) {
        this.f13421a = jSONObject.optInt("w");
        this.b = jSONObject.optInt("h");
        this.c = jSONObject.optString("url");
        this.d = jSONObject.optString("md5");
    }

    @Override // sg.bigo.ads.api.core.o.a
    public final int a() {
        return this.f13421a;
    }

    @Override // sg.bigo.ads.api.core.o.a
    public final int b() {
        return this.b;
    }

    @Override // sg.bigo.ads.api.core.o.a
    public final String c() {
        return this.c;
    }
}
