package io.bidmachine.rendering.internal.adform.video.player;

import android.net.Uri;
import io.bidmachine.rendering.internal.l;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.utils.UiUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a implements b {
    private d f;
    private Uri i;
    private long j;
    private volatile boolean g = false;
    private volatile boolean h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0784a f12336a = new C0784a(16);
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final AtomicLong e = new AtomicLong(-1);

    /* JADX INFO: renamed from: io.bidmachine.rendering.internal.adform.video.player.a$a, reason: collision with other inner class name */
    private class C0784a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f12337a = new AtomicBoolean(false);
        private final AtomicInteger b = new AtomicInteger(0);
        private final int c;

        public C0784a(int i) {
            this.c = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.f12337a.set(false);
            UiUtils.cancelOnUiThread(this);
        }

        @Override // io.bidmachine.rendering.utils.SafeRunnable
        public void onRun() {
            if (this.f12337a.get()) {
                if (a.this.e()) {
                    a();
                }
                a aVar = a.this;
                aVar.a(aVar.h());
                UiUtils.onUiThread(this, this.c);
            }
        }

        private void a() {
            float fH = (a.this.h() * 100.0f) / a.this.g();
            int i = this.b.get();
            if (fH > (i * 25.0f) - 1.0f) {
                if (i == 0) {
                    a.this.t();
                } else if (i == 1) {
                    a.this.r();
                } else if (i == 2) {
                    a.this.s();
                } else if (i == 3) {
                    a.this.u();
                } else if (i == 4) {
                    a.this.q();
                }
                this.b.incrementAndGet();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            c();
            this.f12337a.set(true);
            UiUtils.onUiThread(this);
        }
    }

    private void a(boolean z, Long l) {
        if (l != null) {
            try {
                b(l.longValue());
            } catch (Exception e) {
                a(e);
                return;
            }
        }
        if (z) {
            z();
            return;
        }
        B();
        Uri uri = this.i;
        if (uri != null) {
            b(uri);
        }
        A();
    }

    private d c() {
        return this.f;
    }

    protected abstract void A();

    protected abstract void B();

    protected void b() {
        this.f12336a.c();
    }

    protected abstract void b(Uri uri);

    protected abstract void c(long j);

    protected void d() {
        if (this.c.compareAndSet(true, false)) {
            a(true, Long.valueOf(this.j));
        }
        p();
    }

    protected abstract void d(float f);

    public boolean e() {
        try {
            return w();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // io.bidmachine.rendering.internal.s
    public void f() {
        if (!this.h || this.d.get()) {
            return;
        }
        pause();
        b(g());
        m();
    }

    public boolean i() {
        try {
            return x();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // io.bidmachine.rendering.internal.o
    public void j() {
        b(1.0f);
    }

    protected void k() {
        d dVarC;
        if (this.d.get() || (dVarC = c()) == null) {
            return;
        }
        dVarC.c(this);
    }

    @Override // io.bidmachine.rendering.internal.o
    public void l() {
        b(0.0f);
    }

    protected void m() {
        d dVarC;
        if (this.d.get() || (dVarC = c()) == null) {
            return;
        }
        dVarC.d(this);
    }

    protected void n() {
        d dVarC;
        if (this.d.get() || (dVarC = c()) == null) {
            return;
        }
        dVarC.b(this);
    }

    protected void p() {
        d dVarC;
        if (this.b.compareAndSet(false, true) && (dVarC = c()) != null) {
            dVarC.f(this);
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public void pause() {
        try {
            this.c.set(false);
            y();
            this.j = h();
        } catch (Exception unused) {
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public void play() {
        try {
            this.h = true;
            this.c.set(true);
            a(i(), this.d.get() ? Long.valueOf(g()) : null);
        } catch (Exception e) {
            b(e);
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public void prepare() {
        try {
            A();
        } catch (Exception e) {
            c(e);
        }
    }

    protected void q() {
        d dVarC;
        if (this.d.compareAndSet(false, true) && (dVarC = c()) != null) {
            dVarC.i(this);
        }
    }

    protected void r() {
        d dVarC;
        if (this.d.get() || (dVarC = c()) == null) {
            return;
        }
        dVarC.a(this);
    }

    protected void s() {
        d dVarC;
        if (this.d.get() || (dVarC = c()) == null) {
            return;
        }
        dVarC.h(this);
    }

    protected void t() {
        d dVarC;
        if (this.d.get() || (dVarC = c()) == null) {
            return;
        }
        dVarC.g(this);
    }

    protected void u() {
        d dVarC;
        if (this.d.get() || (dVarC = c()) == null) {
            return;
        }
        dVarC.e(this);
    }

    protected void v() {
        if (this.d.get()) {
            return;
        }
        this.f12336a.b();
    }

    protected abstract boolean w();

    protected abstract boolean x();

    protected abstract void y();

    protected abstract void z();

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public void a() {
        this.f = null;
        b();
    }

    protected void b(Error error) {
        d dVarC;
        if (this.d.get() || (dVarC = c()) == null) {
            return;
        }
        dVarC.a(this, error);
    }

    protected void c(Error error) {
        d dVarC;
        if (this.d.get() || (dVarC = c()) == null) {
            return;
        }
        dVarC.b(this, error);
    }

    protected void a(Error error) {
        if (this.h) {
            b(error);
        } else {
            c(error);
        }
    }

    protected void b(Throwable th) {
        b(Error.create(th));
    }

    protected void c(Throwable th) {
        c(Error.create(th));
    }

    protected void a(Throwable th) {
        a(Error.create(th));
    }

    public void b(long j) {
        try {
            c(j);
        } catch (Exception unused) {
        }
    }

    protected void c(float f) {
        boolean z;
        if (f == 0.0f && !this.g) {
            z = true;
        } else if (!this.g) {
            return;
        } else {
            z = false;
        }
        this.g = z;
        a(z);
    }

    protected void a(boolean z) {
        d dVarC;
        if (this.d.get() || (dVarC = c()) == null) {
            return;
        }
        dVarC.a(this, z);
    }

    public void b(float f) {
        try {
            d(f);
        } catch (Exception unused) {
        }
    }

    protected void a(long j) {
        d dVarC;
        if (this.e.getAndSet(j) == j || this.d.get() || (dVarC = c()) == null) {
            return;
        }
        dVarC.a((b) this, j);
    }

    protected void a(float f) {
        d dVarC;
        if (this.d.get() || (dVarC = c()) == null) {
            return;
        }
        dVarC.a(this, f);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public void a(d dVar) {
        this.f = dVar;
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public void a(Uri uri) {
        try {
            b(uri);
            this.i = uri;
        } catch (Exception unused) {
        }
    }
}
