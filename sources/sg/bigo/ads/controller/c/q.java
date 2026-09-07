package sg.bigo.ads.controller.c;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class q implements sg.bigo.ads.api.core.o.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13428a;
    private final int b;
    private final String c;

    public q(JSONObject jSONObject) {
        this.f13428a = jSONObject.optInt("w");
        this.b = jSONObject.optInt("h");
        this.c = jSONObject.optString("data");
    }

    @Override // sg.bigo.ads.api.core.o.c
    public final int a() {
        return this.f13428a;
    }

    @Override // sg.bigo.ads.api.core.o.c
    public final int b() {
        return this.b;
    }

    @Override // sg.bigo.ads.api.core.o.c
    public final String c() {
        return this.c;
    }
}
