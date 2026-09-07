package sg.bigo.ads.api.b;

import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdBid;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.p;
import sg.bigo.ads.api.core.q;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a<T extends Ad, U extends sg.bigo.ads.api.core.c> implements Ad, d<T> {
    protected final sg.bigo.ads.api.b P;
    protected sg.bigo.ads.common.v.a Q;
    protected a S;
    public int M = 0;
    public int N = 0;
    public int O = 0;
    protected int R = sg.bigo.ads.common.v.a.f13307a;
    protected int T = 0;
    public final p U = new p();

    /* JADX INFO: renamed from: sg.bigo.ads.api.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0855a {
        void a(sg.bigo.ads.api.core.d dVar);

        void b();
    }

    public a(sg.bigo.ads.api.b bVar) {
        this.P = bVar;
    }

    public final a H() {
        return this.S;
    }

    public final q I() {
        sg.bigo.ads.api.core.c cVarF = f();
        if (cVarF != null) {
            return cVarF.Y();
        }
        return null;
    }

    public final int J() {
        return this.R;
    }

    public final sg.bigo.ads.api.b K() {
        return this.P;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Ad ad) {
        if (ad == null) {
            return 1;
        }
        return g() >= (ad instanceof a ? ((a) ad).g() : 0.0d) ? 1 : -1;
    }

    public void a(int i) {
        this.N = i;
    }

    public abstract void a(int i, int i2, String str);

    public void a(String str, String str2, int i) {
    }

    public void a(boolean z, boolean z2) {
        int i;
        if (z2) {
            i = 1;
        } else {
            i = !z ? 2 : 3;
        }
        this.M = i;
    }

    public abstract void b();

    public void b(int i) {
        this.O = i;
    }

    public int b_() {
        int i = this.T + 1;
        this.T = i;
        return i;
    }

    public abstract void c();

    public void c(int i) {
        this.R = i;
    }

    public p c_() {
        return this.U;
    }

    public abstract String d();

    public abstract long e();

    public abstract U f();

    public double g() {
        AdBid bid = getBid();
        return bid != null ? bid.getPrice() : (sg.bigo.ads.common.j.a.a(d(), e()) * 1.0d) / 1.0E8d;
    }
}
