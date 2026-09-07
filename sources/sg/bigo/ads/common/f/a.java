package sg.bigo.ads.common.f;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final a e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f13142a = true;
    long b;
    long c;
    public InterfaceC0862a d;

    /* JADX INFO: renamed from: sg.bigo.ads.common.f.a$a, reason: collision with other inner class name */
    public interface InterfaceC0862a {
        void a(long j, long j2);

        void a(boolean z, long j, long j2, long j3);
    }

    private a() {
        b();
    }

    public static a a() {
        return e;
    }

    final void b() {
        this.b = SystemClock.elapsedRealtime();
        this.c = System.currentTimeMillis();
    }

    final boolean c() {
        return this.b > 0;
    }
}
