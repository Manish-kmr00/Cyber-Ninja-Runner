package sg.bigo.ads.common.utils;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes9.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f13300a = new r() { // from class: sg.bigo.ads.common.utils.r.1
        @Override // sg.bigo.ads.common.utils.r
        public final long a(int i) {
            return ((long) i) * 1000;
        }
    };
    public static final r b = new r() { // from class: sg.bigo.ads.common.utils.r.2
        @Override // sg.bigo.ads.common.utils.r
        public final long a(int i) {
            return ((long) i) * 60000;
        }
    };
    public static final r c = new r() { // from class: sg.bigo.ads.common.utils.r.3
        @Override // sg.bigo.ads.common.utils.r
        public final long a(int i) {
            return ((long) i) * 3600000;
        }
    };
    public static final r d = new r() { // from class: sg.bigo.ads.common.utils.r.4
        @Override // sg.bigo.ads.common.utils.r
        public final long a(int i) {
            return ((long) i) * 86400000;
        }
    };
    private static a e = null;
    private static long f = 1619452800;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f13301a;
        private final long b = SystemClock.elapsedRealtime();

        public a(long j) {
            this.f13301a = j;
        }

        public final long a() {
            return this.f13301a + (SystemClock.elapsedRealtime() - this.b);
        }
    }

    private r() {
    }

    /* synthetic */ r(byte b2) {
        this();
    }

    public static long a() {
        long jCurrentTimeMillis = System.currentTimeMillis() - sg.bigo.ads.common.x.a.e();
        if (jCurrentTimeMillis > 0) {
            return jCurrentTimeMillis;
        }
        sg.bigo.ads.common.x.a.f();
        return System.currentTimeMillis();
    }

    public static void a(long j) {
        if (j < f) {
            return;
        }
        a aVar = new a(j * 1000);
        if (e == null) {
            e = aVar;
        } else if (aVar.a() > e.a()) {
            e = aVar;
        }
    }

    public static long b() {
        a aVar = e;
        return aVar == null ? System.currentTimeMillis() : aVar.a();
    }

    public long a(int i) {
        return i;
    }
}
