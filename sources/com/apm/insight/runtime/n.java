package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: NpthHandlerThread.java */
/* JADX INFO: loaded from: classes13.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile r f296a;
    private static volatile Handler b;

    private static HandlerThread b() {
        if (f296a == null) {
            synchronized (n.class) {
                if (f296a == null) {
                    r rVar = new r("default_npth_thread");
                    f296a = rVar;
                    rVar.b();
                }
            }
        }
        return f296a.c();
    }

    public static r a() {
        if (f296a == null) {
            b();
        }
        return f296a;
    }
}
