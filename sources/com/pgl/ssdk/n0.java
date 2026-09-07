package com.pgl.ssdk;

/* JADX INFO: loaded from: classes9.dex */
public class n0 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile n0 f7524a;
    private volatile boolean c = false;
    private final Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();

    private n0() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static n0 b() {
        if (f7524a == null) {
            synchronized (n0.class) {
                if (f7524a == null) {
                    f7524a = new n0();
                }
            }
        }
        return f7524a;
    }

    public boolean a() {
        return this.c;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.c = true;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
