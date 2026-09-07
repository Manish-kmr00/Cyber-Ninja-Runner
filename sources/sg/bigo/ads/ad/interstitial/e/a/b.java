package sg.bigo.ads.ad.interstitial.e.a;

import androidx.core.view.ViewCompat;
import sg.bigo.ads.ad.interstitial.d;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes12.dex */
public abstract class b {
    protected final int b;
    protected final int c;
    protected final int d;
    protected final int e;
    protected final int f;
    protected final int g;
    protected final int h;
    protected final int i;
    protected final a j = new a(this, 0);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f12794a;
        public int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;

        /* JADX WARN: Code duplicated, block: B:14:0x005c  */
        /* JADX WARN: Code duplicated, block: B:17:0x006e A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:18:0x0070  */
        /* JADX WARN: Code duplicated, block: B:20:0x0078  */
        /* JADX WARN: Code duplicated, block: B:22:0x0080  */
        private a(b bVar) {
            int iC;
            int iD;
            int i = d.b;
            int iE = bVar.e();
            if (iE != 2) {
                if (iE != 3) {
                    this.f12794a = false;
                    this.b = -1;
                    this.c = sg.bigo.ads.common.w.b.a(i, 0.15f);
                    this.d = i;
                    this.f = i;
                } else {
                    this.f12794a = true;
                    this.b = sg.bigo.ads.common.w.b.a(ViewCompat.MEASURED_STATE_MASK, 0.3f);
                }
                this.e = sg.bigo.ads.common.w.b.a(this.f, 128);
                iC = bVar.c();
                if (iC != 2 || iC == 4) {
                    this.g = 0;
                    this.h = 0;
                } else {
                    this.g = this.b;
                    this.h = this.c;
                }
                this.i = -1;
                this.j = sg.bigo.ads.common.w.b.a(i, 0.15f);
                iD = bVar.d();
                if (iD != 2) {
                    this.k = -14972829;
                    this.l = 0;
                } else if (iD != 3) {
                    this.k = -16736769;
                    this.l = 0;
                } else {
                    this.k = 872415231;
                    this.l = -1;
                }
            }
            this.f12794a = false;
            this.b = ViewCompat.MEASURED_STATE_MASK;
            this.c = sg.bigo.ads.common.w.b.a(-1, 0.15f);
            this.d = -1;
            this.f = -1;
            this.e = sg.bigo.ads.common.w.b.a(this.f, 128);
            iC = bVar.c();
            if (iC != 2) {
                this.g = 0;
                this.h = 0;
            } else {
                this.g = 0;
                this.h = 0;
            }
            this.i = -1;
            this.j = sg.bigo.ads.common.w.b.a(i, 0.15f);
            iD = bVar.d();
            if (iD != 2) {
                this.k = -14972829;
                this.l = 0;
            } else if (iD != 3) {
                this.k = -16736769;
                this.l = 0;
            } else {
                this.k = 872415231;
                this.l = -1;
            }
        }

        /* synthetic */ a(b bVar, byte b) {
            this(bVar);
        }
    }

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = i7;
        this.i = i8;
    }

    public static boolean a(b bVar) {
        return bVar == null || bVar.b() == 0;
    }

    public final a a() {
        return this.j;
    }

    public final int b() {
        int i = this.b;
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 0;
    }

    public int c() {
        int i = this.c;
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return i;
        }
        return 1;
    }

    public final int d() {
        int i = this.d;
        if (i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 1;
    }

    public final int e() {
        int i = this.e;
        if (i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 1;
    }

    public final int f() {
        int i = this.f;
        if (i == 2 || i == 4 || i == 6 || i == 8 || i == 10 || i == 12 || i == 14 || i == 16 || i == 18 || i == 20) {
            return i;
        }
        return 20;
    }

    public final long g() {
        int i = this.g;
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return r.f13300a.a(this.g);
        }
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0014  */
    public final long h() {
        r rVar;
        int i;
        int i2 = this.h;
        if (i2 == 0 || i2 == 1) {
            rVar = r.f13300a;
            i = this.h;
        } else {
            i = 2;
            if (i2 == 2 || i2 == 3) {
                rVar = r.f13300a;
                i = this.h;
            } else {
                rVar = r.f13300a;
            }
        }
        return rVar.a(i);
    }

    public final int i() {
        int i = this.i;
        if (i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 3;
    }
}
