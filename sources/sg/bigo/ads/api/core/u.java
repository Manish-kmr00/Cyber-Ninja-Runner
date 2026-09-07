package sg.bigo.ads.api.core;

/* JADX INFO: loaded from: classes13.dex */
public final class u {
    public int d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13118a = "";
    public long b = 0;
    public long c = 0;
    public long e = 0;
    public long f = 0;
    public String g = "";
    public boolean h = false;
    public String i = "";
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private long n = 0;
    public boolean j = false;

    public u(int i) {
        this.d = i;
    }

    public final void a(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i == 1) {
            if (this.k <= 0) {
                this.k = jCurrentTimeMillis;
            }
        } else if (i == 2) {
            if (this.l <= 0) {
                this.l = jCurrentTimeMillis;
            }
        } else {
            if (i != 3) {
                return;
            }
            if (this.m <= 0) {
                this.m = jCurrentTimeMillis;
            }
            if (this.n <= 0) {
                this.n = jCurrentTimeMillis;
            }
        }
    }

    public final void a(String str, String str2, boolean z) {
        this.g = str;
        this.i = str2;
        this.h = z;
    }

    public final void b(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i == 1) {
            if (this.b <= 0) {
                long j = this.k;
                if (j > 0) {
                    this.b = jCurrentTimeMillis - j;
                    return;
                }
                return;
            }
            return;
        }
        if (i == 2) {
            this.j = true;
            if (this.c <= 0) {
                long j2 = this.l;
                if (j2 > 0) {
                    this.c = jCurrentTimeMillis - j2;
                    return;
                }
                return;
            }
            return;
        }
        if (i == 3) {
            if (this.e <= 0) {
                long j3 = this.m;
                if (j3 > 0) {
                    this.e = jCurrentTimeMillis - j3;
                    return;
                }
                return;
            }
            return;
        }
        if (i == 4 && this.f <= 0) {
            long j4 = this.n;
            if (j4 > 0) {
                this.f = jCurrentTimeMillis - j4;
            }
        }
    }
}
