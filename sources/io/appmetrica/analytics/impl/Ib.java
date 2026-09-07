package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes5.dex */
public final class Ib implements InterfaceC4027c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC3978a0 f11193a;
    public final C4001an b = new C4001an();

    public Ib(InterfaceC3978a0 interfaceC3978a0) {
        this.f11193a = interfaceC3978a0;
    }

    public static final void a(Ib ib, S s) {
        ib.f11193a.a(s);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4027c
    public final void onAppNotResponding() {
        StackTraceElement[] stackTraceElementArrB;
        C4001an c4001an = this.b;
        Thread threadA = c4001an.f11468a.a();
        try {
            stackTraceElementArrB = c4001an.f11468a.b();
            if (stackTraceElementArrB == null) {
                try {
                    stackTraceElementArrB = threadA.getStackTrace();
                } catch (SecurityException unused) {
                }
            }
        } catch (SecurityException unused2) {
            stackTraceElementArrB = null;
        }
        final S s = new S((Tm) c4001an.b.apply(threadA, stackTraceElementArrB), c4001an.a(threadA, null), c4001an.c.b());
        ((G9) C4455t4.i().c.a()).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.Ib$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Ib.a(this.f$0, s);
            }
        });
    }
}
