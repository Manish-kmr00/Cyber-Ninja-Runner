package com.json;

import com.json.mediationsdk.logger.IronLog;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes9.dex */
public class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o2 f4177a;
    private final fm b;
    private final wl c = c();
    private Timer d;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q2.this.b.b();
        }
    }

    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            q2.this.b.b();
        }
    }

    public q2(o2 o2Var, fm fmVar) {
        this.f4177a = o2Var;
        this.b = fmVar;
    }

    private synchronized void b(long j) {
        j();
        Timer timer = new Timer();
        this.d = timer;
        timer.schedule(new b(), j);
    }

    private wl c() {
        return new wl(new a(), com.json.lifecycle.b.d(), new yu());
    }

    private synchronized void j() {
        Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
            this.d = null;
        }
    }

    public void a() {
        if (this.f4177a.a() == o2.a.MANUAL_WITH_AUTOMATIC_RELOAD) {
            IronLog.INTERNAL.verbose();
            i();
        }
    }

    protected void a(long j) {
        wl wlVar = this.c;
        if (wlVar != null) {
            wlVar.a(j);
        }
    }

    protected o2 b() {
        return this.f4177a;
    }

    protected boolean d() {
        return this.f4177a.c() > 0;
    }

    public void e() {
        if (this.f4177a.e()) {
            IronLog.INTERNAL.verbose();
            b(this.f4177a.c());
        }
    }

    public void f() {
        if (this.f4177a.a() == o2.a.AUTOMATIC_LOAD_AFTER_CLOSE) {
            IronLog.INTERNAL.verbose();
            b(this.f4177a.d());
        }
    }

    public void g() {
        if (this.f4177a.e()) {
            IronLog.INTERNAL.verbose();
            b(0L);
        }
    }

    public void h() {
        if (this.f4177a.a() != o2.a.AUTOMATIC_LOAD_WHILE_SHOW || this.f4177a.d() < 0) {
            return;
        }
        IronLog.INTERNAL.verbose();
        b(this.f4177a.d());
    }

    protected void i() {
        wl wlVar = this.c;
        if (wlVar != null) {
            wlVar.b();
        }
    }

    public void k() {
        if (this.f4177a.a() != o2.a.MANUAL_WITH_AUTOMATIC_RELOAD || this.f4177a.b() <= 0) {
            return;
        }
        IronLog.INTERNAL.verbose();
        a(this.f4177a.b());
    }
}
