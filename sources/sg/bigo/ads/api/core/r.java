package sg.bigo.ads.api.core;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13115a = false;
    private String b = "";
    private int c = 0;
    private int d = 0;

    public r() {
        a();
    }

    private void a() {
        this.f13115a = false;
        this.b = "";
        this.c = 3;
        this.d = 20000;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            a();
            return;
        }
        this.f13115a = true;
        this.b = jSONObject.optString("http_succ_code");
        this.c = jSONObject.optInt("retry_cnt", 3);
        int iOptInt = jSONObject.optInt("retry_interval") * 1000;
        this.d = iOptInt;
        if (iOptInt < 20000) {
            this.d = 20000;
        }
    }

    public final boolean a(int i) {
        if (i >= 100) {
            return this.b.contains(String.valueOf(i));
        }
        return false;
    }

    public final boolean a(long j, long j2) {
        return j + ((long) this.d) < j2;
    }

    public final boolean b(int i) {
        return i < this.c;
    }
}
