package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: ThreadWithHandler.java */
/* JADX INFO: loaded from: classes13.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HandlerThread f304a;
    private volatile Handler d;
    private final Queue<c> b = new ConcurrentLinkedQueue();
    private final Queue<Message> c = new ConcurrentLinkedQueue();
    private final Object e = new Object();

    public r(String str) {
        this.f304a = new b(str);
    }

    public final Handler a() {
        return this.d;
    }

    public final void b() {
        this.f304a.start();
    }

    public final HandlerThread c() {
        return this.f304a;
    }

    private Message b(Runnable runnable) {
        return Message.obtain(this.d, runnable);
    }

    public final boolean a(Runnable runnable) {
        return a(b(runnable), 0L);
    }

    public final boolean a(Runnable runnable, long j) {
        return a(b(runnable), j);
    }

    static {
        new Object() { // from class: com.apm.insight.runtime.r.1
        };
        new Object() { // from class: com.apm.insight.runtime.r.2
        };
    }

    private boolean a(Message message, long j) {
        if (j < 0) {
            j = 0;
        }
        return b(message, SystemClock.uptimeMillis() + j);
    }

    private boolean b(Message message, long j) {
        if (this.d == null) {
            synchronized (this.e) {
                if (this.d == null) {
                    this.b.add(new c(message, j));
                    return true;
                }
            }
        }
        try {
            return this.d.sendMessageAtTime(message, j);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: compiled from: ThreadWithHandler.java */
    class b extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile int f306a;
        private volatile boolean b;

        b(String str) {
            super(str);
            this.f306a = 0;
            this.b = false;
        }

        /* JADX INFO: Infinite loop detected, blocks: 19, insns: 0 */
        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            super.onLooperPrepared();
            synchronized (r.this.e) {
                try {
                    r.this.d = new Handler();
                } catch (Throwable th) {
                    throw th;
                }
            }
            r.this.d.post(r.this.new a());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th2) {
                    try {
                        com.apm.insight.b.f.a(com.apm.insight.e.g()).a().c();
                        if (this.f306a < 5) {
                            com.apm.insight.c.a();
                            k.a(th2, "NPTH_CATCH");
                        } else if (!this.b) {
                            this.b = true;
                            com.apm.insight.c.a();
                            k.a(new RuntimeException(), "NPTH_ERR_MAX");
                        }
                        this.f306a++;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: ThreadWithHandler.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!r.this.c.isEmpty()) {
                if (r.this.d != null) {
                    try {
                        r.this.d.sendMessageAtFrontOfQueue((Message) r.this.c.poll());
                    } catch (Throwable unused) {
                    }
                }
            }
            while (!r.this.b.isEmpty()) {
                c cVar = (c) r.this.b.poll();
                if (r.this.d != null) {
                    try {
                        r.this.d.sendMessageAtTime(cVar.f307a, cVar.b);
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: ThreadWithHandler.java */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Message f307a;
        long b;

        c(Message message, long j) {
            this.f307a = message;
            this.b = j;
        }
    }
}
