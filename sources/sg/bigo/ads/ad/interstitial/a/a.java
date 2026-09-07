package sg.bigo.ads.ad.interstitial.a;

import android.content.Context;
import android.view.View;
import java.util.Iterator;
import sg.bigo.ads.ad.banner.g;
import sg.bigo.ads.ad.interstitial.a.b.c;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.core.f.a.p;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements sg.bigo.ads.ad.interstitial.a.b.b, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12630a;
    public sg.bigo.ads.ad.interstitial.a.b.a b;
    final sg.bigo.ads.ad.interstitial.a.b.a.C0827a c = new sg.bigo.ads.ad.interstitial.a.b.a.C0827a();

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.a.a$a, reason: collision with other inner class name */
    final class C0823a implements sg.bigo.ads.ad.interstitial.a.b.b.a {
        private C0823a() {
        }

        /* synthetic */ C0823a(a aVar, byte b) {
            this();
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void a() {
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void a(sg.bigo.ads.api.core.c cVar) {
            a.this.c.a(cVar, 6, 0L);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void a(sg.bigo.ads.api.core.c cVar, long j) {
            a.this.c.a(cVar, 0, j);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void b() {
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void b(sg.bigo.ads.api.core.c cVar, long j) {
            a.this.c.a(cVar, 2, j);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void c(sg.bigo.ads.api.core.c cVar, long j) {
            a.this.c.a(cVar, 1, j);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final boolean c() {
            return true;
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void d(sg.bigo.ads.api.core.c cVar, long j) {
            a.this.c.a(cVar, 5, j);
        }
    }

    final class b implements c.b {
        private b() {
        }

        /* synthetic */ b(a aVar, byte b) {
            this();
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.c.b
        public final void a(sg.bigo.ads.api.core.c cVar) {
            a.this.c.a(cVar, 6, 0L);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.c.b
        public final void a(sg.bigo.ads.api.core.c cVar, long j) {
            a.this.c.a(cVar, 5, j);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.c.b
        public final void a(sg.bigo.ads.api.core.c cVar, long j, String str, int i, String str2) {
            a.this.c.a(cVar, 3, j, str, i, str2, null);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.c.b
        public final void a(sg.bigo.ads.api.core.c cVar, long j, String str, int i, String str2, String str3) {
            a.this.c.a(cVar, 4, j, str, i, str2, str3);
        }
    }

    public a(boolean z, Ad ad, l lVar, sg.bigo.ads.api.core.c cVar, sg.bigo.ads.core.player.c cVar2, p pVar) {
        sg.bigo.ads.core.f.a.a.C0894a c0894aA;
        sg.bigo.ads.core.f.a.a.C0894a c0894aA2;
        sg.bigo.ads.core.f.a.a next;
        String str;
        byte b2 = 0;
        if (!cVar.ar() && !lVar.t()) {
            str = "render companion disable due to slot switch off";
        } else if (z) {
            str = "render companion disable due to playable";
        } else if (cVar.x() == 3 || cVar.x() == 4 || cVar.x() == 12 || cVar.x() == 20) {
            if (ad instanceof sg.bigo.ads.core.a.a) {
                sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) ad;
                c0894aA = aVar.bm();
                c0894aA2 = aVar.bl();
            } else {
                c0894aA = null;
                c0894aA2 = null;
            }
            if ((c0894aA2 == null || !c0894aA2.a()) && ((c0894aA == null || !c0894aA.a()) && pVar != null)) {
                Iterator<sg.bigo.ads.core.f.a.a> it = pVar.A.iterator();
                while (it.hasNext() && ((next = it.next()) == null || (((c0894aA2 = sg.bigo.ads.core.f.a.a.a(next.b)) == null || !c0894aA2.a()) && ((c0894aA = next.a()) == null || !c0894aA.a())))) {
                }
            }
            sg.bigo.ads.core.f.a.a.C0894a c0894a = c0894aA;
            if (c0894aA2 != null && c0894aA2.a()) {
                sg.bigo.ads.common.t.a.a(0, 3, "EndPageVastCompanion", "render companion init with image.");
                this.b = new sg.bigo.ads.ad.interstitial.a.a.c(ad, cVar, cVar2, pVar, new b(this, b2));
            }
            if (this.b == null && c0894a != null && c0894a.a()) {
                sg.bigo.ads.common.t.a.a(0, 3, "EndPageVastCompanion", "render companion init with html.");
                this.b = new sg.bigo.ads.ad.interstitial.a.a.b(ad, cVar, cVar2, pVar, c0894a, new C0823a(this, b2));
            }
            this.f12630a = this.b != null;
            str = "The ad with slot: " + lVar.l() + ", pid: " + lVar.n() + " isRenderable: " + this.f12630a;
        } else {
            str = "render companion disable due to invalid type";
        }
        sg.bigo.ads.common.t.a.a(0, 3, "EndPageVastCompanion", str);
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final View a() {
        sg.bigo.ads.ad.interstitial.a.b.a aVar;
        if (this.f12630a && (aVar = this.b) != null) {
            return aVar.a();
        }
        return null;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i) {
        sg.bigo.ads.ad.interstitial.a.b.a aVar;
        if (this.f12630a && (aVar = this.b) != null) {
            aVar.a(i);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i, int i2) {
        sg.bigo.ads.ad.interstitial.a.b.a aVar;
        if (this.f12630a && (aVar = this.b) != null) {
            aVar.a(i, i2);
        }
    }

    public final void a(g gVar) {
        sg.bigo.ads.ad.interstitial.a.b.a aVar = this.b;
        if (aVar instanceof sg.bigo.ads.ad.interstitial.a.a.b) {
            ((sg.bigo.ads.ad.interstitial.a.a.b) aVar).g = gVar;
        }
    }

    public final void a(c.a aVar) {
        sg.bigo.ads.ad.interstitial.a.b.a aVar2 = this.b;
        if (aVar2 instanceof sg.bigo.ads.ad.interstitial.a.a.c) {
            ((sg.bigo.ads.ad.interstitial.a.a.c) aVar2).f = aVar;
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean a(Context context) {
        sg.bigo.ads.common.t.a.a(0, 3, "EndPageVastCompanion", "tyr to start preload end page resource.");
        if (!this.f12630a) {
            sg.bigo.ads.common.t.a.a(0, 3, "EndPageVastCompanion", "end page resource is unavailable.");
            return false;
        }
        sg.bigo.ads.ad.interstitial.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.a(context);
        }
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean b() {
        sg.bigo.ads.ad.interstitial.a.b.a aVar;
        if (this.f12630a && (aVar = this.b) != null) {
            return aVar.b();
        }
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void c() {
        sg.bigo.ads.ad.interstitial.a.b.a aVar = this.b;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void d() {
        sg.bigo.ads.ad.interstitial.a.b.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void e() {
        sg.bigo.ads.ad.interstitial.a.b.a aVar = this.b;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void f() {
        sg.bigo.ads.ad.interstitial.a.b.a aVar = this.b;
        if (aVar != null) {
            aVar.f();
        }
    }
}
