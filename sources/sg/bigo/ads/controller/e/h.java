package sg.bigo.ads.controller.e;

import android.os.SystemClock;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.n;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements sg.bigo.ads.common.f.a.InterfaceC0862a {
    private static final h f = new h();
    private boolean h;
    private long i;
    private long j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13462a = false;
    long b = 5000;
    private long g = 21600000;
    long c = 0;
    long d = 0;
    public final a e = new a();

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f13463a = System.currentTimeMillis();
        long b = System.currentTimeMillis();
        long c = System.currentTimeMillis();

        public a() {
        }

        public final String a(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("start_ts", Long.valueOf(this.c));
                h hVar = h.this;
                jSONObject.putOpt("total_duration", Long.valueOf(hVar.c + hVar.b()));
                h hVar2 = h.this;
                long jB = hVar2.b();
                if (jB > hVar2.b) {
                    hVar2.d = jB;
                } else {
                    jB = hVar2.d;
                }
                jSONObject.putOpt("close_duration", Long.valueOf(jB));
                g.a aVarA = g.a().a(str);
                jSONObject.putOpt("front_total_req_times", Long.valueOf(g.this.c ? aVarA.f13461a.getAndAdd(1) : aVarA.f13461a.get()));
                g.a aVarA2 = g.a().a(str);
                jSONObject.putOpt("back_total_req_times", Long.valueOf(!g.this.c ? aVarA2.b.getAndAdd(1) : aVarA2.b.get()));
                g.a aVarA3 = g.a().a(str);
                jSONObject.putOpt("close_front_req_times", Long.valueOf(g.this.c ? aVarA3.c.getAndAdd(1) : aVarA3.c.get()));
                jSONObject.putOpt("req_status", Long.valueOf(h.a(h.this)));
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }

    private h() {
        sg.bigo.ads.common.f.a.a().d = this;
    }

    static /* synthetic */ int a(h hVar) {
        return hVar.h ? 1 : 2;
    }

    public static h a() {
        return f;
    }

    @Override // sg.bigo.ads.common.f.a.InterfaceC0862a
    public final void a(long j, long j2) {
        this.h = true;
        this.i = j;
        this.e.b = j2;
        long j3 = this.g;
        if (j3 > 0) {
            long j4 = this.j;
            if (j4 > 0 && j - j4 >= j3) {
                this.c = 0L;
                this.d = 0L;
                this.e.c = System.currentTimeMillis();
                g.a().f13460a.clear();
            }
        }
        if (this.e.c == 0) {
            this.e.c = System.currentTimeMillis();
        }
        g.a().a(true);
    }

    public final void a(n nVar) {
        this.f13462a = nVar.a();
        this.b = nVar.b();
        this.g = nVar.c();
    }

    @Override // sg.bigo.ads.common.f.a.InterfaceC0862a
    public final void a(boolean z, long j, long j2, long j3) {
        this.h = false;
        this.j = j2;
        this.i = 0L;
        long j4 = j2 - j;
        if (j4 > 0 && j4 > this.b) {
            this.c += j4;
            this.d = j4;
            if (this.f13462a) {
                sg.bigo.ads.core.d.b.a(z ? 1 : 2, j3, j4);
            }
        }
        g.a().a(false);
    }

    final long b() {
        long j = this.i;
        if (j <= 0) {
            return 0L;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (jElapsedRealtime <= 0 || jElapsedRealtime <= this.b) {
            return 0L;
        }
        return jElapsedRealtime;
    }
}
