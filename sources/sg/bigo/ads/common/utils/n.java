package sg.bigo.ads.common.utils;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes9.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f13294a;
    final long d;
    long e;
    long f;
    long g;
    boolean h = false;
    public boolean i = false;
    private final Handler b = new Handler() { // from class: sg.bigo.ads.common.utils.n.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            long j;
            synchronized (n.this) {
                if (!n.this.h && !n.this.i) {
                    long jElapsedRealtime = n.this.e - SystemClock.elapsedRealtime();
                    if (jElapsedRealtime <= 0) {
                        n.this.i = true;
                        n.this.a();
                    } else {
                        if (n.this.f <= 0 || n.this.g <= 0) {
                            j = n.this.d;
                        } else {
                            j = n.this.d - (n.this.g - n.this.f);
                            n.this.g = 0L;
                        }
                        while (j < 0) {
                            j += n.this.d;
                        }
                        n.this.a(jElapsedRealtime);
                        n.this.f = SystemClock.elapsedRealtime();
                        sendMessageDelayed(obtainMessage(1), j);
                    }
                }
            }
        }
    };

    public n(long j, long j2) {
        this.d = j2;
        this.f13294a = j;
    }

    public abstract void a();

    public abstract void a(long j);

    public final synchronized void b() {
        this.h = true;
        this.b.removeMessages(1);
    }

    public final synchronized n c() {
        this.h = false;
        if (this.f13294a <= 0) {
            if (!this.i) {
                this.i = true;
                a();
            }
            return this;
        }
        this.e = SystemClock.elapsedRealtime() + this.f13294a;
        Handler handler = this.b;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public final void d() {
        if (this.i || this.h) {
            return;
        }
        b();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.g = jElapsedRealtime;
        this.f13294a = this.e - jElapsedRealtime;
    }

    public final boolean e() {
        return !this.i && this.h;
    }
}
