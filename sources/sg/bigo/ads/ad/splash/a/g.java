package sg.bigo.ads.ad.splash.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.List;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.a.l;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements c {
    public sg.bigo.ads.ad.interstitial.a.b b;
    public sg.bigo.ads.ad.interstitial.a.a c;
    public int g;
    private final sg.bigo.ads.ad.splash.b h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13043a = c.a.f13038a;
    public boolean d = false;
    public int e = 1;
    public boolean f = false;

    static class a implements sg.bigo.ads.ad.banner.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13045a = 13;
        private int b = 6;
        private final sg.bigo.ads.ad.splash.b c;

        public a(sg.bigo.ads.ad.splash.b bVar) {
            this.c = bVar;
        }

        @Override // sg.bigo.ads.ad.banner.g
        public final void a() {
            this.c.d(this.b);
        }

        @Override // sg.bigo.ads.ad.banner.g
        public final void a(String str) {
        }

        @Override // sg.bigo.ads.ad.banner.g
        public final void a(sg.bigo.ads.common.i iVar, sg.bigo.ads.api.core.e eVar) {
            this.c.v.a(iVar, this.f13045a, this.b, eVar);
        }

        @Override // sg.bigo.ads.ad.banner.g
        public final void b() {
        }
    }

    public g(final sg.bigo.ads.ad.splash.b bVar, l lVar, sg.bigo.ads.api.core.c cVar) {
        int i = 0;
        int i2 = 1;
        this.g = 0;
        this.h = bVar;
        sg.bigo.ads.ad.b.c cVar2 = bVar.v;
        boolean z = cVar2 instanceof sg.bigo.ads.ad.b.d;
        this.b = new sg.bigo.ads.ad.interstitial.a.b(cVar2, lVar, cVar, z ? ((sg.bigo.ads.ad.b.d) cVar2).H : null, z ? ((sg.bigo.ads.ad.b.d) cVar2).I : null);
        this.c = new sg.bigo.ads.ad.interstitial.a.a(this.b.f12644a, cVar2, lVar, cVar, z ? ((sg.bigo.ads.ad.b.d) cVar2).H : null, z ? ((sg.bigo.ads.ad.b.d) cVar2).I : null);
        if (this.b.f12644a) {
            i = 1;
        } else if (this.c.f12630a) {
            i = 2;
        }
        this.g = i;
        cVar.d(i);
        if (!this.b.f12644a && !(this.c.b instanceof sg.bigo.ads.ad.interstitial.a.a.b)) {
            i2 = 2;
        }
        cVar.e(i2);
        sg.bigo.ads.ad.interstitial.a.b bVar2 = this.b;
        if (bVar2 != null) {
            bVar2.a(new a(bVar));
            this.b.a(bVar.b.f);
        }
        sg.bigo.ads.ad.interstitial.a.a aVar = this.c;
        if (aVar != null) {
            aVar.a(new a(bVar));
            this.c.a(new sg.bigo.ads.ad.interstitial.a.b.c.a() { // from class: sg.bigo.ads.ad.splash.a.g.1
                @Override // sg.bigo.ads.ad.interstitial.a.b.c.a
                public final void a(sg.bigo.ads.common.i iVar, sg.bigo.ads.api.core.e eVar) {
                    bVar.v.a(iVar, 15, 9, eVar);
                }
            });
            this.c.a(bVar.b.f);
        }
    }

    private boolean f() {
        sg.bigo.ads.ad.interstitial.a.b bVar = this.b;
        return (bVar == null || !bVar.f12644a || !this.b.b() || this.b.b || this.b.f.i == null) ? false : true;
    }

    private boolean g() {
        sg.bigo.ads.ad.interstitial.a.a aVar = this.c;
        return aVar != null && aVar.f12630a && this.c.b() && this.c.a() != null;
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a() {
    }

    public final void a(Runnable runnable) {
        sg.bigo.ads.ad.interstitial.a.b bVar = this.b;
        if (bVar != null) {
            bVar.a(runnable);
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z) {
        if (z) {
            if (this.f) {
                sg.bigo.ads.ad.interstitial.a.b bVar = this.b;
                if (bVar != null) {
                    bVar.f.c();
                    return;
                }
                return;
            }
            sg.bigo.ads.ad.interstitial.a.a aVar = this.c;
            if (aVar != null) {
                aVar.c();
                return;
            }
            return;
        }
        if (this.f) {
            sg.bigo.ads.ad.interstitial.a.b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.f.d();
                return;
            }
            return;
        }
        sg.bigo.ads.ad.interstitial.a.a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.d();
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z, ViewGroup viewGroup, int i) {
        int i2;
        this.f13043a = z ? c.a.b : c.a.c;
        if (z) {
            if (this.e == 2) {
                viewGroup.removeViewAt(1);
            }
            if (f()) {
                View view = this.b.f.i;
                viewGroup.addView(view, 1, new FrameLayout.LayoutParams(-1, -1));
                if (view != null) {
                    view.setTag(19);
                }
                this.b.a(1);
                this.d = true;
                this.f = true;
                i2 = 5;
            } else {
                View viewA = this.c.a();
                viewGroup.addView(viewA, 1, new FrameLayout.LayoutParams(-1, -1));
                if (viewA != null) {
                    viewA.setTag(20);
                }
                this.c.a(1);
                this.d = true;
                i2 = 7;
            }
            int i3 = this.e == 2 ? 9 : 8;
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) this.h.v.f(), i2, i);
            this.h.v.a(viewGroup, (MediaView) null, (ImageView) null, (AdOptionsView) null, (List<View>) null, i3, null);
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void b() {
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void c() {
        this.f13043a = c.a.d;
        sg.bigo.ads.ad.interstitial.a.b bVar = this.b;
        if (bVar != null) {
            bVar.e();
            this.b = null;
        }
        sg.bigo.ads.ad.interstitial.a.a aVar = this.c;
        if (aVar != null) {
            aVar.e();
            this.c = null;
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final int d() {
        return this.f13043a;
    }

    public final boolean e() {
        return f() || g();
    }
}
