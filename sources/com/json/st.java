package com.json;

import android.os.Handler;
import android.os.HandlerThread;
import com.json.mediationsdk.logger.d;

/* JADX INFO: loaded from: classes9.dex */
public class st extends Thread {
    private static st b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f4431a;

    private class a extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f4432a;

        a(String str) {
            super(str);
            setUncaughtExceptionHandler(new d());
        }

        Handler a() {
            return this.f4432a;
        }

        void b() {
            this.f4432a = new Handler(getLooper());
        }
    }

    private st() {
        a aVar = new a(getClass().getSimpleName());
        this.f4431a = aVar;
        aVar.start();
        this.f4431a.b();
    }

    public static synchronized st a() {
        if (b == null) {
            b = new st();
        }
        return b;
    }

    public synchronized void a(Runnable runnable) {
        a aVar = this.f4431a;
        if (aVar == null) {
            return;
        }
        Handler handlerA = aVar.a();
        if (handlerA != null) {
            handlerA.post(runnable);
        }
    }
}
