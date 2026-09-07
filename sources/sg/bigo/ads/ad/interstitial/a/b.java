package sg.bigo.ads.ad.interstitial.a;

import android.content.Context;
import android.view.View;
import java.util.Iterator;
import sg.bigo.ads.ad.banner.g;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.core.f.a.p;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements sg.bigo.ads.ad.interstitial.a.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12644a;
    public Runnable c;
    public InterfaceC0826b d;
    public final sg.bigo.ads.ad.interstitial.a.a.b f;
    public boolean b = false;
    final sg.bigo.ads.ad.interstitial.a.b.a.C0827a e = new sg.bigo.ads.ad.interstitial.a.b.a.C0827a();

    final class a implements sg.bigo.ads.ad.interstitial.a.b.b.a {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void a() {
            if (b.this.c != null) {
                b.this.c.run();
            }
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void a(c cVar) {
            b.this.e.a(cVar, 6, 0L);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void a(c cVar, long j) {
            b.this.e.a(cVar, 0, j);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void b() {
            if (b.this.d != null) {
                b.this.d.a();
            }
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void b(c cVar, long j) {
            b.this.e.a(cVar, 2, j);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void c(c cVar, long j) {
            b.this.e.a(cVar, 1, j);
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final boolean c() {
            return false;
        }

        @Override // sg.bigo.ads.ad.interstitial.a.b.b.a
        public final void d(c cVar, long j) {
            b.this.e.a(cVar, 5, j);
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0826b {
        void a();
    }

    public b(Ad ad, l lVar, c cVar, sg.bigo.ads.core.player.c cVar2, p pVar) {
        sg.bigo.ads.core.f.a.a next;
        byte b = 0;
        sg.bigo.ads.core.f.a.a.C0894a c0894aBm = ad instanceof sg.bigo.ads.core.a.a ? ((sg.bigo.ads.core.a.a) ad).bm() : null;
        if ((c0894aBm == null || !c0894aBm.a()) && pVar != null) {
            Iterator<sg.bigo.ads.core.f.a.a> it = pVar.A.iterator();
            while (it.hasNext() && ((next = it.next()) == null || (c0894aBm = next.a()) == null || !c0894aBm.a())) {
            }
        }
        sg.bigo.ads.core.f.a.a.C0894a c0894a = c0894aBm;
        boolean zS = lVar.s();
        boolean zAc = cVar.ac();
        boolean z = c0894a != null && c0894a.a();
        int iX = cVar.x();
        boolean z2 = (zS || cVar.ar()) && zAc && z && (iX == 3 || iX == 4 || iX == 12 || iX == 20);
        this.f12644a = z2;
        this.f = z2 ? new sg.bigo.ads.ad.interstitial.a.a.b(ad, cVar, cVar2, pVar, c0894a, new a(this, b)) : new sg.bigo.ads.ad.interstitial.a.a.b(ad, cVar, null, null, null, null);
        sg.bigo.ads.common.t.a.a(0, 3, "PlayableAdCompanion", "The ad with slot: " + lVar.l() + ", pid: " + lVar.n() + " is playable: " + z2);
    }

    public b(Ad ad, l lVar, sg.bigo.ads.core.f.a.a.C0894a c0894a, c cVar, sg.bigo.ads.core.player.c cVar2, p pVar) {
        byte b = 0;
        boolean z = cVar.x() == 3 || cVar.x() == 4 || cVar.x() == 20;
        this.f12644a = z;
        if (z) {
            this.f = new sg.bigo.ads.ad.interstitial.a.a.b(ad, cVar, cVar2, pVar, c0894a, new a(this, b));
        } else {
            this.f = new sg.bigo.ads.ad.interstitial.a.a.b(ad, cVar, null, null, null, null);
        }
        sg.bigo.ads.common.t.a.a(0, 3, "PlayableAdCompanion", "The ad with slot: " + lVar.l() + ", pid: " + lVar.n() + " is playable: " + z);
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final View a() {
        return this.f.i;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i) {
        if (i == 1) {
            this.b = true;
        }
        this.f.a(i);
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i, int i2) {
        this.f.a(i, i2);
    }

    public final void a(Runnable runnable) {
        if (this.c == runnable) {
            this.c = null;
        }
    }

    public final void a(g gVar) {
        this.f.g = gVar;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean a(Context context) {
        if (this.f12644a) {
            return this.f.a(context);
        }
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean b() {
        if (this.f12644a) {
            return this.f.b();
        }
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void c() {
        this.f.c();
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void d() {
        this.f.d();
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void e() {
        this.f.e();
        this.d = null;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void f() {
        this.f.f();
    }
}
