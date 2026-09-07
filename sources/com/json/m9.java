package com.json;

/* JADX INFO: loaded from: classes10.dex */
public class m9 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f3917a;

    m9(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f3917a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        n9 n9Var = new n9(th);
        if (n9Var.getIsIronsourceCrash()) {
            new lc(n9Var.getStackTrace(), "" + System.currentTimeMillis(), "Crash").a();
        }
        this.f3917a.uncaughtException(thread, th);
    }
}
