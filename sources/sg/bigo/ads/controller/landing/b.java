package sg.bigo.ads.controller.landing;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.b.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements sg.bigo.ads.a.a.c, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f13480a;
    String b;
    String c;
    private final String f;
    private final sg.bigo.ads.api.core.c g;
    private final sg.bigo.ads.ad.c<?, ?> h;
    private final sg.bigo.ads.controller.landing.a i;
    private final int l;
    private final long m;
    private final String e = "ChromeTabStatSession";
    private int j = 0;
    private boolean k = false;
    protected long d = -1;
    private final List<f.a> n = new ArrayList();
    private final AtomicBoolean o = new AtomicBoolean(true);
    private final AtomicBoolean p = new AtomicBoolean(true);
    private boolean q = false;

    static class a implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13481a;
        private final long b;

        private a(int i, long j) {
            this.f13481a = i;
            this.b = System.currentTimeMillis() - j;
        }

        /* synthetic */ a(int i, long j, byte b) {
            this(i, j);
        }

        @Override // sg.bigo.ads.api.b.f.a
        public final int a() {
            return this.f13481a;
        }

        @Override // sg.bigo.ads.api.b.f.a
        public final long b() {
            return this.b;
        }
    }

    public b(String str, sg.bigo.ads.api.core.c cVar, sg.bigo.ads.ad.c<?, ?> cVar2, sg.bigo.ads.controller.landing.a aVar) {
        long jCurrentTimeMillis;
        this.f = str;
        this.g = cVar;
        this.h = cVar2;
        this.i = aVar;
        if (cVar2 != null) {
            this.l = cVar2.q();
            jCurrentTimeMillis = cVar2.r();
        } else {
            this.l = 0;
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        this.m = jCurrentTimeMillis;
    }

    private void a(int i) {
        a aVar = new a(i, this.m, (byte) 0);
        this.n.add(0, aVar);
        sg.bigo.ads.core.d.b.a(this, aVar, this.g, this.h, (String) null);
    }

    @Override // sg.bigo.ads.a.a.c
    public final void a() {
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabStatSession", "Chrome tabs shown: " + this.f);
        a(1);
    }

    @Override // sg.bigo.ads.a.a.c
    public final void b() {
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabStatSession", "Chrome tabs page started: " + this.f);
        this.d = SystemClock.elapsedRealtime();
        this.j++;
        if (this.o.compareAndSet(true, false)) {
            a(4);
        }
    }

    @Override // sg.bigo.ads.a.a.c
    public final void c() {
        this.k = true;
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabStatSession", "Chrome tabs page aborted: " + this.f);
    }

    @Override // sg.bigo.ads.a.a.c
    public final void d() {
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabStatSession", "Chrome tabs page failed: " + this.f);
        if (this.q) {
            return;
        }
        a(6);
    }

    @Override // sg.bigo.ads.a.a.c
    public final void e() {
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabStatSession", "Chrome tabs page finished: " + this.f);
        this.q = true;
        if (this.p.compareAndSet(true, false)) {
            a(5);
        }
    }

    @Override // sg.bigo.ads.api.b.f
    public final int f() {
        return 0;
    }

    @Override // sg.bigo.ads.api.b.f
    public final String g() {
        return this.f;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int h() {
        return 0;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int i() {
        return 0;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int j() {
        return this.q ? 100 : 0;
    }

    @Override // sg.bigo.ads.api.b.f
    public final boolean k() {
        sg.bigo.ads.controller.landing.a aVar = this.i;
        return aVar != null && aVar.d;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int l() {
        return this.l;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int m() {
        return 2;
    }

    @Override // sg.bigo.ads.api.b.f
    public final Map<String, String> n() {
        if (!this.k && TextUtils.isEmpty(this.f13480a) && TextUtils.isEmpty(this.c) && TextUtils.isEmpty(this.b)) {
            return null;
        }
        HashMap map = new HashMap();
        if (this.k) {
            map.put("tab_aborted", "1");
        }
        if (!TextUtils.isEmpty(this.f13480a)) {
            map.put("chrome_pkg", this.f13480a);
        }
        if (!TextUtils.isEmpty(this.c)) {
            map.put("is_chrome_def", TextUtils.equals(this.f13480a, this.c) ? "1" : "0");
        }
        if (!TextUtils.isEmpty(this.b)) {
            map.put("chrome_ver", this.b);
        }
        return map;
    }

    @Override // sg.bigo.ads.a.a.c
    public final void o() {
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabStatSession", "Chrome tabs hidden: " + this.f);
        sg.bigo.ads.core.d.b.a(this, this.n.isEmpty() ? null : this.n.get(0), System.currentTimeMillis() - this.m, this.j, this.g, this.h, (String) null);
    }
}
