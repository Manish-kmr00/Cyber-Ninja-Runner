package sg.bigo.ads.controller.c;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class m implements sg.bigo.ads.api.core.c.InterfaceC0857c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13424a;
    private final String b;
    private final String c;

    public m(JSONObject jSONObject) {
        this.f13424a = jSONObject.optString("vendor_url");
        this.b = jSONObject.optString("vendor_key");
        this.c = jSONObject.optString("params");
    }

    @Override // sg.bigo.ads.api.core.c.InterfaceC0857c
    public final String a() {
        return this.f13424a;
    }

    @Override // sg.bigo.ads.api.core.c.InterfaceC0857c
    public final String b() {
        return this.b;
    }

    @Override // sg.bigo.ads.api.core.c.InterfaceC0857c
    public final String c() {
        return this.c;
    }
}
