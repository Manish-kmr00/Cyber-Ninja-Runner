package sg.bigo.ads.controller.a;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes5.dex */
public interface f extends c {

    public static class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final sg.bigo.ads.controller.a.a f13393a;
        private final sg.bigo.ads.controller.a.a.b b;
        private final sg.bigo.ads.common.g c;
        private final sg.bigo.ads.api.a.h d;
        private final String e;
        private String f;
        private j g;
        private j h;
        private final boolean i;
        private boolean j;
        private boolean k;
        private String l;
        private g m;
        private final AtomicBoolean n = new AtomicBoolean(false);
        private final AtomicBoolean o = new AtomicBoolean(false);
        private final Runnable p = new Runnable() { // from class: sg.bigo.ads.controller.a.f.a.1
            @Override // java.lang.Runnable
            public final void run() {
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[bigo url] run timeout task");
                a.this.b();
            }
        };

        public a(sg.bigo.ads.controller.a.a aVar, sg.bigo.ads.common.g gVar, sg.bigo.ads.api.a.h hVar, String str) {
            boolean z = false;
            this.f13393a = aVar;
            this.c = gVar;
            this.d = hVar;
            this.e = str;
            str.hashCode();
            if (str.equals("/Ad/GetSDKConfig")) {
                this.b = aVar.g;
                z = true;
            } else {
                this.b = !str.equals("/Ad/ReportUniBaina") ? aVar.i : aVar.h;
            }
            this.i = z;
        }

        @Override // sg.bigo.ads.common.u.a
        public final String a() {
            g gVar;
            g gVar2;
            if (q.a((CharSequence) this.f)) {
                String strV = this.c.v();
                e eVarA = this.b.a(strV, this.d.s());
                this.j = this.f13393a.f13366a;
                this.k = this.f13393a.e;
                this.l = this.f13393a.f;
                this.g = eVarA.f13392a;
                this.h = this.b.f13368a;
                this.f = sg.bigo.ads.b.a(this.g.c() ? this.g.b() : this.g.a(), this.e);
                if (eVarA.c && (gVar2 = this.m) != null) {
                    gVar2.a(this.e);
                }
                if (eVarA.b && (gVar = this.m) != null) {
                    gVar.a(strV, this.i);
                }
            }
            return this.f;
        }

        @Override // sg.bigo.ads.controller.a.c
        public final void a(long j) {
            if (this.o.compareAndSet(false, true)) {
                sg.bigo.ads.common.n.d.a(3, this.p, j);
            }
        }

        @Override // sg.bigo.ads.controller.a.c
        public final void a(g gVar) {
            this.m = gVar;
        }

        @Override // sg.bigo.ads.common.u.a
        public final void b() {
            g gVar;
            boolean zEquals = false;
            if (!this.n.compareAndSet(false, true)) {
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[bigo url] mark fail do nth, it has marked.");
                return;
            }
            sg.bigo.ads.common.n.d.a(this.p);
            String strD = d();
            sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[bigo url] mark fail, url is " + this.f);
            sg.bigo.ads.controller.a.a.b bVar = this.b;
            if (bVar.b != null && (zEquals = TextUtils.equals(strD, bVar.b.a()))) {
                bVar.c++;
            }
            if (zEquals && (gVar = this.m) != null) {
                gVar.a(this.e);
            }
        }

        @Override // sg.bigo.ads.common.u.a
        public final void c() {
            g gVar;
            boolean z = false;
            if (!this.n.compareAndSet(false, true)) {
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[bigo url] mark success do nth, it has marked.");
                return;
            }
            sg.bigo.ads.common.n.d.a(this.p);
            String strD = d();
            sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[bigo url] mark success, url is " + this.f);
            sg.bigo.ads.controller.a.a.b bVar = this.b;
            if (bVar.b != null) {
                boolean z2 = TextUtils.equals(strD, bVar.b.a()) && bVar.c > 0;
                if (z2) {
                    bVar.c = 0;
                }
                z = z2;
            }
            if (z && (gVar = this.m) != null) {
                gVar.a(this.e);
            }
        }

        @Override // sg.bigo.ads.common.u.a
        public final String d() {
            j jVar = this.g;
            return jVar != null ? jVar.a() : "";
        }

        @Override // sg.bigo.ads.common.u.a
        public final boolean e() {
            j jVar = this.g;
            return jVar != null && jVar.c();
        }

        @Override // sg.bigo.ads.common.u.a
        public final String f() {
            j jVar = this.h;
            return jVar != null ? jVar.a() : "";
        }

        @Override // sg.bigo.ads.controller.a.c
        public final j g() {
            return this.g;
        }

        @Override // sg.bigo.ads.controller.a.c
        public final boolean h() {
            return this.k;
        }

        @Override // sg.bigo.ads.controller.a.c
        public final String i() {
            return this.l;
        }
    }
}
