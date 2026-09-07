package sg.bigo.ads.controller.c;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements sg.bigo.ads.api.core.i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13420a;
    private final int b;
    private final String c;

    public h(JSONObject jSONObject) {
        this.f13420a = jSONObject.optInt("w");
        this.b = jSONObject.optInt("h");
        this.c = jSONObject.optString("data");
    }

    @Override // sg.bigo.ads.api.core.i.b
    public final int a() {
        return this.f13420a;
    }

    @Override // sg.bigo.ads.api.core.i.b
    public final int b() {
        return this.b;
    }

    @Override // sg.bigo.ads.api.core.i.b
    public final String c() {
        return this.c;
    }
}
