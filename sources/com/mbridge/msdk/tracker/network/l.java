package com.mbridge.msdk.tracker.network;

/* JADX INFO: compiled from: MBridgeVolleyManager.java */
/* JADX INFO: loaded from: classes6.dex */
public class l {
    private static volatile l b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f5635a;

    private l() {
    }

    public static l a() {
        if (b == null) {
            synchronized (l.class) {
                if (b == null) {
                    b = new l();
                }
            }
        }
        return b;
    }

    public u b() {
        if (this.f5635a == null) {
            u uVarA = com.mbridge.msdk.tracker.network.toolbox.o.a(new com.mbridge.msdk.tracker.network.toolbox.b(new com.mbridge.msdk.tracker.network.toolbox.m()), null, 10, new com.mbridge.msdk.tracker.network.toolbox.l());
            this.f5635a = uVarA;
            uVarA.b();
        }
        return this.f5635a;
    }
}
