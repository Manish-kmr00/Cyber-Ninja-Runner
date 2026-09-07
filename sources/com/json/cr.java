package com.json;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes9.dex */
public class cr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o5 f3584a;
    private dr b;
    private Timer c = null;

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cr.this.b.b();
        }
    }

    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cr.this.b.b();
        }
    }

    public cr(o5 o5Var, dr drVar) {
        this.f3584a = o5Var;
        this.b = drVar;
    }

    private void d() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
    }

    public synchronized void a() {
        d();
        Timer timer = new Timer();
        this.c = timer;
        timer.schedule(new b(), this.f3584a.b());
    }

    public void b() {
        synchronized (this) {
            d();
        }
        this.b.b();
    }

    public synchronized void c() {
        d();
        Timer timer = new Timer();
        this.c = timer;
        timer.schedule(new a(), this.f3584a.j());
    }
}
