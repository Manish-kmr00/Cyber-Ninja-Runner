package io.bidmachine.rendering.internal;

import io.bidmachine.rendering.utils.UiUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes11.dex */
public abstract class u implements r, o, q, t, s, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.bidmachine.rendering.internal.event.a f12371a;
    private final List b = new CopyOnWriteArrayList();

    class a extends b {
        a() {
            super(null);
        }

        @Override // io.bidmachine.rendering.utils.SafeRunnable
        public void onRun() {
            u.this.p().k();
            u.this.b.remove(this);
        }
    }

    private static abstract class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f12372a;
        private long b;

        private b() {
        }

        private long c() {
            return Math.max(this.b - System.currentTimeMillis(), 0L);
        }

        public void a() {
            this.f12372a = c();
            UiUtils.cancelOnUiThread(this);
        }

        public void b() {
            long j = this.f12372a;
            if (j > 0) {
                UiUtils.onUiThread(this, j);
            } else {
                UiUtils.onUiThread(this);
            }
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public void a(long j) {
            this.f12372a = j;
            this.b = System.currentTimeMillis() + j;
            b();
        }
    }

    public u(io.bidmachine.rendering.internal.event.a aVar) {
        this.f12371a = aVar;
    }

    public void a(long j, long j2, float f) {
    }

    public void a(String str) {
    }

    public void b() {
    }

    public void f() {
    }

    public void j() {
    }

    public void l() {
    }

    @Override // io.bidmachine.rendering.internal.r
    public void m() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((b) it.next()).b();
        }
    }

    public io.bidmachine.rendering.internal.event.a p() {
        return this.f12371a;
    }

    @Override // io.bidmachine.rendering.internal.r
    public void pause() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
    }

    public abstract String q();

    public void a() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
        this.b.clear();
    }

    @Override // io.bidmachine.rendering.internal.r
    public void a(long j) {
        a aVar = new a();
        this.b.add(aVar);
        aVar.a(j);
    }
}
