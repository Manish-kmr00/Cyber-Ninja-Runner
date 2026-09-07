package sg.bigo.ads.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13512a = 10;
    public int b = 900000;
    public int c = 259200000;

    public a() {
        b();
    }

    private void b() {
        this.f13512a = 10;
        this.b = 900000;
        this.c = 259200000;
    }

    public final int a() {
        return Math.round(this.f13512a * 0.8f);
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            b();
            return;
        }
        this.f13512a = jSONObject.optInt("num", 10);
        int iOptInt = jSONObject.optInt("interval") * 1000;
        this.b = iOptInt;
        if (iOptInt == 0) {
            this.b = 900000;
        }
        this.c = jSONObject.optInt("expired") * 1000;
    }
}
