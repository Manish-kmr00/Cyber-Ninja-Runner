package sg.bigo.ads.ad.b;

import android.content.Context;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.core.f.a.p;

/* JADX INFO: loaded from: classes5.dex */
public final class g<T extends Ad> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    T f12521a;
    Context b;
    sg.bigo.ads.core.a.a c;
    p d;
    sg.bigo.ads.api.b.d.a<T> e;
    final sg.bigo.ads.core.g.c f;
    sg.bigo.ads.core.player.b.a g;
    sg.bigo.ads.core.player.b.d h;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.b.g$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12522a;

        AnonymousClass1(int i) {
            this.f12522a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f12522a != 0) {
                g.this.e.a(g.this.f12521a, 1006, this.f12522a, "Invalid VPAID media files.");
                return;
            }
            g.this.g = new sg.bigo.ads.core.player.b.a() { // from class: sg.bigo.ads.ad.b.g.1.1
                @Override // sg.bigo.ads.core.player.b.a
                public final void a() {
                }

                @Override // sg.bigo.ads.core.player.b.a
                public final void a(int i) {
                    if (g.this.d == null) {
                        g.this.e.a(g.this.f12521a, 1006, 10075, "VPAID video config is empty.");
                    } else {
                        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.b.g.1.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                sg.bigo.ads.api.c.b bVarB = sg.bigo.ads.api.c.b.b(g.this.c.x());
                                bVarB.c = false;
                                int i2 = g.this.d.x;
                                int i3 = g.this.d.w;
                                g.this.h = new sg.bigo.ads.core.player.b.d(g.this.b, i2, i3, bVarB, g.this.c);
                                g.this.h.setOnEventListener(g.this.f);
                            }
                        });
                    }
                }

                @Override // sg.bigo.ads.core.player.b.a
                public final void a(String str, sg.bigo.ads.common.h.a aVar) {
                }

                @Override // sg.bigo.ads.core.player.b.a
                public final void b(int i) {
                    g.this.e.a(g.this.f12521a, 1006, i, "Failed to download VPAID.");
                }
            };
            sg.bigo.ads.core.player.b.a().a(g.this.b, g.this.c, g.this.g);
        }
    }

    public g(Context context, sg.bigo.ads.core.g.c cVar, sg.bigo.ads.core.a.a aVar, p pVar, sg.bigo.ads.api.b.d.a<T> aVar2, T t) {
        this.b = context;
        this.f = cVar;
        this.c = aVar;
        this.d = pVar;
        this.e = aVar2;
        this.f12521a = t;
    }

    public final boolean a() {
        return this.c.at() == 1;
    }
}
