package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes9.dex */
public final class ds0 {
    public static final b d;
    public static final b e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f8726a;
    private c<? extends d> b;
    private IOException c;

    public interface a<T extends d> {
        b a(T t, long j, long j2, IOException iOException, int i);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    public interface d {
        void a() throws IOException;

        void b();
    }

    public interface e {
        void b();
    }

    static {
        long j = -9223372036854775807L;
        d = new b(2, j);
        e = new b(3, j);
    }

    public static final class g extends IOException {
        public g(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8727a;
        private final long b;

        private b(int i, long j) {
            this.f8727a = i;
            this.b = j;
        }

        public final boolean a() {
            int i = this.f8727a;
            return i == 0 || i == 1;
        }
    }

    public ds0(String str) {
        this.f8726a = x82.d("ExoPlayer:Loader:".concat(str));
    }

    public final boolean c() {
        return this.c != null;
    }

    public final void b() {
        this.c = null;
    }

    public final boolean d() {
        return this.b != null;
    }

    public final void a() {
        c<? extends d> cVar = this.b;
        if (cVar != null) {
            cVar.a(false);
            return;
        }
        throw new IllegalStateException();
    }

    private final class c<T extends d> extends Handler implements Runnable {
        public final int b;
        private final T c;
        private final long d;
        private a<T> e;
        private IOException f;
        private int g;
        private Thread h;
        private boolean i;
        private volatile boolean j;

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            try {
                synchronized (this) {
                    z = this.i;
                    this.h = Thread.currentThread();
                }
                if (!z) {
                    n52.a("load:".concat(this.c.getClass().getSimpleName()));
                    try {
                        this.c.a();
                        n52.a();
                    } catch (Throwable th) {
                        n52.a();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.h = null;
                    Thread.interrupted();
                }
                if (this.j) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e) {
                if (this.j) {
                    return;
                }
                obtainMessage(2, e).sendToTarget();
            } catch (Exception e2) {
                if (this.j) {
                    return;
                }
                at0.a("LoadTask", "Unexpected exception loading stream", e2);
                obtainMessage(2, new g(e2)).sendToTarget();
            } catch (OutOfMemoryError e3) {
                if (this.j) {
                    return;
                }
                at0.a("LoadTask", "OutOfMemory error loading stream", e3);
                obtainMessage(2, new g(e3)).sendToTarget();
            } catch (Error e4) {
                if (!this.j) {
                    at0.a("LoadTask", "Unexpected error loading stream", e4);
                    obtainMessage(3, e4).sendToTarget();
                }
                throw e4;
            }
        }

        public c(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.c = t;
            this.e = aVar;
            this.b = i;
            this.d = j;
        }

        public final void a(boolean z) {
            this.j = z;
            this.f = null;
            if (hasMessages(0)) {
                this.i = true;
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.i = true;
                    this.c.b();
                    Thread thread = this.h;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z) {
                ds0.this.b = null;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                a<T> aVar = this.e;
                aVar.getClass();
                aVar.a(this.c, jElapsedRealtime, jElapsedRealtime - this.d, true);
                this.e = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (this.j) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                this.f = null;
                ds0 ds0Var = ds0.this;
                ExecutorService executorService = ds0Var.f8726a;
                c cVar = ds0Var.b;
                cVar.getClass();
                executorService.execute(cVar);
                return;
            }
            if (i != 3) {
                ds0.this.b = null;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j = jElapsedRealtime - this.d;
                a<T> aVar = this.e;
                aVar.getClass();
                if (this.i) {
                    aVar.a(this.c, jElapsedRealtime, j, false);
                    return;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    try {
                        aVar.a(this.c, jElapsedRealtime, j);
                        return;
                    } catch (RuntimeException e) {
                        at0.a("LoadTask", "Unexpected exception handling load completed", e);
                        ds0.this.c = new g(e);
                        return;
                    }
                }
                if (i2 != 2) {
                    return;
                }
                IOException iOException = (IOException) message.obj;
                this.f = iOException;
                int i3 = this.g + 1;
                this.g = i3;
                b bVarA = aVar.a(this.c, jElapsedRealtime, j, iOException, i3);
                int i4 = bVarA.f8727a;
                if (i4 == 3) {
                    ds0.this.c = this.f;
                    return;
                }
                if (i4 != 2) {
                    if (i4 == 1) {
                        this.g = 1;
                    }
                    long jMin = bVarA.b;
                    if (jMin == -9223372036854775807L) {
                        jMin = Math.min((this.g - 1) * 1000, 5000);
                    }
                    ds0 ds0Var2 = ds0.this;
                    if (ds0Var2.b == null) {
                        ds0Var2.b = this;
                        if (jMin > 0) {
                            sendEmptyMessageDelayed(0, jMin);
                            return;
                        } else {
                            this.f = null;
                            ds0Var2.f8726a.execute(this);
                            return;
                        }
                    }
                    throw new IllegalStateException();
                }
                return;
            }
            throw ((Error) message.obj);
        }
    }

    private static final class f implements Runnable {
        private final e b;

        public f(e eVar) {
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.b();
        }
    }

    public final void a(int i) throws IOException {
        IOException iOException = this.c;
        if (iOException == null) {
            c<? extends d> cVar = this.b;
            if (cVar != null) {
                if (i == Integer.MIN_VALUE) {
                    i = cVar.b;
                }
                IOException iOException2 = ((c) cVar).f;
                if (iOException2 != null && ((c) cVar).g > i) {
                    throw iOException2;
                }
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void a(e eVar) {
        c<? extends d> cVar = this.b;
        if (cVar != null) {
            cVar.a(true);
        }
        if (eVar != null) {
            this.f8726a.execute(new f(eVar));
        }
        this.f8726a.shutdown();
    }

    public static b a(long j, boolean z) {
        return new b(z ? 1 : 0, j);
    }

    public final <T extends d> long a(T t, a<T> aVar, int i) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            this.c = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            c<? extends d> cVar = new c<>(looperMyLooper, t, aVar, i, jElapsedRealtime);
            if (this.b == null) {
                this.b = cVar;
                ((c) cVar).f = null;
                this.f8726a.execute(cVar);
                return jElapsedRealtime;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }
}
