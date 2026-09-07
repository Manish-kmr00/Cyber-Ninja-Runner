package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes9.dex */
public final class y extends Handler implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f2173a;
    public final x b;
    public final int c;
    public final long d;
    public IOException e;
    public int f;
    public volatile Thread g;
    public volatile boolean h;
    public final /* synthetic */ B i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(B b, Looper looper, z zVar, x xVar, int i, long j) {
        super(looper);
        this.i = b;
        this.f2173a = zVar;
        this.b = xVar;
        this.c = i;
        this.d = j;
    }

    public final void a(boolean z) {
        this.h = z;
        this.e = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.f2173a.b();
            if (this.g != null) {
                this.g.interrupt();
            }
        }
        if (z) {
            this.i.b = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.b.a(this.f2173a, jElapsedRealtime, jElapsedRealtime - this.d, true);
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.h) {
            return;
        }
        int i = message.what;
        if (i == 0) {
            this.e = null;
            B b = this.i;
            b.f2145a.execute(b.b);
            return;
        }
        if (i == 4) {
            throw ((Error) message.obj);
        }
        this.i.b = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.d;
        if (this.f2173a.a()) {
            this.b.a(this.f2173a, jElapsedRealtime, j, false);
            return;
        }
        int i2 = message.what;
        if (i2 == 1) {
            this.b.a(this.f2173a, jElapsedRealtime, j, false);
            return;
        }
        if (i2 == 2) {
            this.b.a(this.f2173a, jElapsedRealtime, j);
            return;
        }
        if (i2 != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.e = iOException;
        int iA = this.b.a(this.f2173a, jElapsedRealtime, j, iOException);
        if (iA == 3) {
            this.i.c = this.e;
            return;
        }
        if (iA != 2) {
            int i3 = iA == 1 ? 1 : this.f + 1;
            this.f = i3;
            long jMin = Math.min((i3 - 1) * 1000, 5000);
            B b2 = this.i;
            if (b2.b != null) {
                throw new IllegalStateException();
            }
            b2.b = this;
            if (jMin > 0) {
                sendEmptyMessageDelayed(0, jMin);
            } else {
                this.e = null;
                b2.f2145a.execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.g = Thread.currentThread();
            if (!this.f2173a.a()) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.w.a("load:".concat(this.f2173a.getClass().getSimpleName()));
                try {
                    this.f2173a.load();
                    com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
                } catch (Throwable th) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
                    throw th;
                }
            }
            if (this.h) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e) {
            if (this.h) {
                return;
            }
            obtainMessage(3, e).sendToTarget();
        } catch (InterruptedException unused) {
            if (!this.f2173a.a()) {
                throw new IllegalStateException();
            }
            if (this.h) {
                return;
            }
            sendEmptyMessage(2);
        } catch (Exception e2) {
            Log.e("LoadTask", "Unexpected exception loading stream", e2);
            if (this.h) {
                return;
            }
            obtainMessage(3, new A(e2)).sendToTarget();
        } catch (OutOfMemoryError e3) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e3);
            if (this.h) {
                return;
            }
            obtainMessage(3, new A(e3)).sendToTarget();
        } catch (Error e4) {
            Log.e("LoadTask", "Unexpected error loading stream", e4);
            if (!this.h) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        }
    }
}
