package com.digitalturbine.ignite.authenticator.logger;

/* JADX INFO: loaded from: classes10.dex */
public final class a {
    public static final a b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILogger f1235a;

    public static void a(String str, Object... objArr) {
        ILogger iLogger = b.f1235a;
        if (iLogger != null) {
            iLogger.d(str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        ILogger iLogger = b.f1235a;
        if (iLogger != null) {
            iLogger.w(str, objArr);
        }
    }
}
