package com.mbridge.msdk.tracker;

import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ExecutorManager.java */
/* JADX INFO: loaded from: classes7.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile ThreadPoolExecutor f5618a;

    /* JADX INFO: compiled from: ExecutorManager.java */
    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "MBridgeTrackThread");
        }
    }

    /* JADX INFO: compiled from: ExecutorManager.java */
    private static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f5620a;

        public b(Runnable runnable) {
            this.f5620a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (y.b(this.f5620a)) {
                return;
            }
            try {
                this.f5620a.run();
            } catch (Exception e) {
                if (com.mbridge.msdk.tracker.a.f5612a) {
                    Log.e("TrackManager", "execute error", e);
                }
            }
        }
    }

    public void a(Runnable runnable) {
        if (this.f5618a == null) {
            this.f5618a = a();
        }
        if (this.f5618a.isShutdown()) {
            return;
        }
        this.f5618a.execute(new b(runnable));
    }

    private ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(), new ThreadPoolExecutor.DiscardPolicy());
    }
}
