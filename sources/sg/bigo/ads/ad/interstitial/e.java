package sg.bigo.ads.ad.interstitial;

/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f12791a = false;
    a b;
    private sg.bigo.ads.common.utils.n c;

    public interface a {
        boolean a(Runnable runnable);
    }

    public final void a() {
        this.f12791a = true;
        sg.bigo.ads.common.utils.n nVar = this.c;
        if (nVar != null) {
            nVar.b();
        }
    }

    protected final void a(int i, final Runnable runnable) {
        sg.bigo.ads.common.utils.n nVar = this.c;
        if (nVar != null) {
            nVar.b();
        }
        this.f12791a = false;
        sg.bigo.ads.common.utils.n nVar2 = new sg.bigo.ads.common.utils.n(((long) i) * 1000) { // from class: sg.bigo.ads.ad.interstitial.e.1
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                if (e.this.f12791a || runnable == null) {
                    return;
                }
                if (e.this.b != null) {
                    e.this.b.a(runnable);
                } else {
                    runnable.run();
                }
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
            }
        };
        this.c = nVar2;
        nVar2.c();
    }

    public void b() {
        sg.bigo.ads.common.utils.n nVar;
        if (this.f12791a || (nVar = this.c) == null || nVar.i) {
            return;
        }
        this.c.c();
    }

    public void c() {
        sg.bigo.ads.common.utils.n nVar;
        if (this.f12791a || (nVar = this.c) == null || nVar.i) {
            return;
        }
        this.c.d();
    }
}
