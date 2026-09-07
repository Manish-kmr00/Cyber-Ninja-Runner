package sg.bigo.ads.api.core;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements sg.bigo.ads.api.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13109a;
    private final int b;
    private final String c;
    private final String d;

    public k(JSONObject jSONObject) {
        this.f13109a = jSONObject.optInt("w");
        this.b = jSONObject.optInt("h");
        this.c = jSONObject.optString("url");
        this.d = jSONObject.optString("md5");
    }

    @Override // sg.bigo.ads.api.a.f
    public final int a() {
        return this.f13109a;
    }

    @Override // sg.bigo.ads.api.a.f
    public final int b() {
        return this.b;
    }

    @Override // sg.bigo.ads.api.a.f
    public final String c() {
        return this.c;
    }
}
