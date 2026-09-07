package com.json;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes9.dex */
public class wl {
    private static final String g = "wl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.json.lifecycle.b f4565a;
    private final Runnable b;
    private final yu c;
    private Timer e;
    private final Object d = new Object();
    private final nk f = new a();

    class a implements nk {
        a() {
        }

        @Override // com.json.nk
        public void a() {
        }

        @Override // com.json.nk
        public void b() {
            wl.this.c.c(System.currentTimeMillis());
            wl.this.c();
        }

        @Override // com.json.nk
        public void c() {
            wl.this.c.b(System.currentTimeMillis());
            wl wlVar = wl.this;
            wlVar.b(wlVar.c.a());
        }

        @Override // com.json.nk
        public void d() {
        }
    }

    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            wl.this.f4565a.b(wl.this.f);
            wl.this.c.b();
            wl.this.b.run();
        }
    }

    public wl(Runnable runnable, com.json.lifecycle.b bVar, yu yuVar) {
        this.b = runnable;
        this.f4565a = bVar;
        this.c = yuVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        synchronized (this.d) {
            c();
            Timer timer = new Timer();
            this.e = timer;
            timer.schedule(new b(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.d) {
            Timer timer = this.e;
            if (timer != null) {
                timer.cancel();
                this.e = null;
            }
        }
    }

    public void a() {
        a(0L);
    }

    public void a(long j) {
        if (j < 0) {
            Log.d(g, "cannot start timer with delay < 0");
            return;
        }
        this.f4565a.a(this.f);
        this.c.a(j);
        if (this.f4565a.e()) {
            this.c.c(System.currentTimeMillis());
        } else {
            b(j);
        }
    }

    public void b() {
        c();
        this.f4565a.b(this.f);
        this.c.b();
    }
}
