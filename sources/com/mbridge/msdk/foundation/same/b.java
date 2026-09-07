package com.mbridge.msdk.foundation.same;

/* JADX INFO: compiled from: MBridgeRefactor.java */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    private static volatile b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Boolean f4958a = null;

    private b() {
    }

    public static b b() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public Boolean a() {
        return this.f4958a;
    }
}
