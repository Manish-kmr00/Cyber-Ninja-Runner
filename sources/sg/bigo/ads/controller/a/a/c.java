package sg.bigo.ads.controller.a.a;

import android.os.Parcel;
import org.json.JSONObject;
import sg.bigo.ads.common.n;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends b {
    public static final long d = r.c.a(1);
    public static final long e = r.b.a(5);
    public static final long f = r.f13300a.a(30);
    public long g;
    public long h;
    private long i;

    public c(String str) {
        super(str, "");
        this.i = d;
    }

    @Override // sg.bigo.ads.controller.a.a.b, sg.bigo.ads.common.f
    public final void a(Parcel parcel) {
        super.a(parcel);
        parcel.writeLong(this.i);
        parcel.writeLong(this.g);
        parcel.writeLong(this.h);
    }

    @Override // sg.bigo.ads.controller.a.a.b
    public final void a(JSONObject jSONObject, boolean z, String str, int i) {
        super.a(jSONObject, z, str, i);
        this.i = Math.max(jSONObject.optLong("interval", d / 1000) * 1000, f);
    }

    public final boolean a() {
        long j = this.g;
        long j2 = this.h;
        if (j == j2) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j > j2) {
            return Math.abs(jCurrentTimeMillis - this.g) > e;
        }
        return Math.abs(jCurrentTimeMillis - this.h) > this.i;
    }

    @Override // sg.bigo.ads.controller.a.a.b, sg.bigo.ads.common.f
    public final void b(Parcel parcel) {
        super.b(parcel);
        this.i = n.a(parcel, d);
        this.g = n.a(parcel, 0L);
        this.h = n.a(parcel, 0L);
    }
}
