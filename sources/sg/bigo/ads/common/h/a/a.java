package sg.bigo.ads.common.h.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13191a = 3;
    public int b = 20;
    public int c = 40;
    public long d = 432000000;

    public a() {
        c();
    }

    private void c() {
        this.f13191a = 3;
        this.b = 20;
        this.c = 40;
        this.d = 432000000L;
    }

    public final int a() {
        int i = this.b;
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        return i;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            c();
            return;
        }
        this.f13191a = jSONObject.optInt("download_parallel_num", 3);
        int iOptInt = jSONObject.optInt("num", 20);
        this.b = iOptInt;
        this.c = iOptInt * 2;
        long jOptInt = ((long) jSONObject.optInt("valid_period")) * 1000;
        if (jOptInt == 0) {
            jOptInt = 432000000;
        }
        this.d = jOptInt;
    }

    public final boolean b() {
        return this.f13191a <= 0;
    }
}
