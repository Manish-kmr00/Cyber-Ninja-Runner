package io.bidmachine.rendering.internal.controller;

import android.content.Context;
import io.bidmachine.rendering.internal.l;
import io.bidmachine.rendering.internal.m;
import io.bidmachine.rendering.model.AdParams;
import io.bidmachine.rendering.model.AdPhaseParams;
import io.bidmachine.rendering.model.CacheType;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.Orientation;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.Tag;
import io.bidmachine.rendering.utils.UiUtils;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes11.dex */
public class b implements io.bidmachine.rendering.internal.controller.a {
    private final Context b;
    private final AdParams c;
    private final io.bidmachine.rendering.internal.controller.c d;
    io.bidmachine.rendering.internal.view.f j;
    volatile io.bidmachine.rendering.internal.controller.d k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Tag f12349a = new Tag(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a);
    private final io.bidmachine.rendering.internal.c e = new io.bidmachine.rendering.internal.d();
    final Queue f = new ConcurrentLinkedQueue();
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12350a;

        static {
            int[] iArr = new int[CacheType.values().length];
            f12350a = iArr;
            try {
                iArr[CacheType.FullLoad.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12350a[CacheType.PartialLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12350a[CacheType.StreamLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.rendering.internal.controller.b$b, reason: collision with other inner class name */
    class C0788b implements f {
        C0788b() {
        }

        @Override // io.bidmachine.rendering.internal.controller.f
        public void a(io.bidmachine.rendering.internal.controller.d dVar, Error error) {
            m.a(b.this.f12349a, "onAdPhaseFailToLoad (%s) - %s", dVar, error);
            b.this.b(dVar);
            if (!b.this.k()) {
                b.this.a(error);
            } else if (b.this.e.d()) {
                b.this.a(dVar, new Error("Fail to load after show (CacheType - " + b.this.g() + ") - " + error));
            } else {
                b.this.n();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.f
        public void a(io.bidmachine.rendering.internal.controller.d dVar) {
            m.b(b.this.f12349a, "onAdPhaseLoaded (%s)", dVar);
            if (b.this.j()) {
                b.this.u();
                b.this.o();
            }
        }
    }

    private class c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.bidmachine.rendering.internal.controller.c f12352a;

        public c(io.bidmachine.rendering.internal.controller.c cVar) {
            this.f12352a = cVar;
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void a(PrivacySheetParams privacySheetParams) {
            this.f12352a.a(privacySheetParams);
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void b() {
            this.f12352a.b();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void c() {
            this.f12352a.c();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void d() {
            this.f12352a.onAdClicked();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void f() {
            if (b.this.i()) {
                b.this.u();
            } else {
                b();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void a() {
            this.f12352a.a();
        }
    }

    private class d implements io.bidmachine.rendering.internal.view.f.d {
        private d() {
        }

        @Override // io.bidmachine.rendering.internal.view.f.d
        public void a() {
            b.this.q();
        }

        @Override // io.bidmachine.rendering.internal.view.f.d
        public void onLoaded() {
            b.this.s();
        }

        /* synthetic */ d(b bVar, a aVar) {
            this();
        }
    }

    public b(Context context, AdParams adParams, io.bidmachine.rendering.internal.controller.c cVar) {
        this.b = context.getApplicationContext();
        this.c = adParams;
        this.d = cVar;
    }

    private void p() {
        if (this.e.h()) {
            this.d.c(this);
        }
    }

    @Override // io.bidmachine.rendering.internal.controller.a
    public void c() {
        m.b(this.f12349a, "load (cacheType - %s)", g());
        io.bidmachine.rendering.internal.g.b(this.b);
        Queue<AdPhaseParams> adPhaseParamsQueue = this.c.getAdPhaseParamsQueue();
        if (adPhaseParamsQueue.isEmpty()) {
            this.d.a(this, new Error("Ad phase queue is empty"));
            return;
        }
        if (k()) {
            this.d.b(this);
            return;
        }
        if (this.e.c()) {
            Iterator<AdPhaseParams> it = adPhaseParamsQueue.iterator();
            while (it.hasNext()) {
                a(new e(this.b, it.next(), new C0788b()));
            }
            int i = a.f12350a[g().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    m();
                    return;
                }
                m();
            }
            l();
        }
    }

    @Override // io.bidmachine.rendering.internal.controller.a
    public void d() {
        m.b(this.f12349a, "performHide", new Object[0]);
        io.bidmachine.rendering.internal.controller.d dVar = this.k;
        if (dVar != null) {
            dVar.d();
        }
        r();
    }

    @Override // io.bidmachine.rendering.internal.controller.a
    public boolean e() {
        m.b(this.f12349a, "performShow", new Object[0]);
        this.e.k();
        io.bidmachine.rendering.internal.controller.d dVar = this.k;
        if (dVar != null) {
            dVar.e();
            return true;
        }
        t();
        l();
        return false;
    }

    void f() {
        this.f.clear();
    }

    CacheType g() {
        return this.c.getCacheType();
    }

    io.bidmachine.rendering.internal.controller.d h() {
        return (io.bidmachine.rendering.internal.controller.d) this.f.peek();
    }

    boolean i() {
        return h() != null;
    }

    boolean j() {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            if (!((io.bidmachine.rendering.internal.controller.d) it.next()).b()) {
                return false;
            }
        }
        return true;
    }

    public boolean k() {
        return this.e.b();
    }

    void l() {
        if (this.g.compareAndSet(false, true)) {
            for (io.bidmachine.rendering.internal.controller.d dVar : this.f) {
                m.b(this.f12349a, "loadAdPhase (%s)", dVar);
                dVar.c();
            }
        }
    }

    void m() {
        final AdPhaseParams placeholderParams = this.c.getPlaceholderParams();
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.internal.controller.b$$ExternalSyntheticLambda0
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.a(placeholderParams);
            }
        });
    }

    void n() {
        if (this.e.j()) {
            this.d.a(this);
        }
    }

    boolean o() {
        if (!this.e.a(true)) {
            return false;
        }
        this.d.b(this);
        return true;
    }

    @Override // io.bidmachine.rendering.internal.controller.a
    public void onShown() {
        io.bidmachine.rendering.internal.controller.d dVar = this.k;
        if (dVar != null) {
            dVar.onShown();
            p();
        }
    }

    void q() {
        this.d.e();
    }

    void r() {
        io.bidmachine.rendering.internal.view.f fVar = this.j;
        if (fVar != null && this.i.compareAndSet(true, false)) {
            fVar.j();
            this.d.b(fVar);
        }
    }

    void s() {
        o();
    }

    void t() {
        io.bidmachine.rendering.internal.view.f fVar = this.j;
        if (fVar != null && this.i.compareAndSet(false, true)) {
            this.d.a(fVar);
            fVar.k();
        }
    }

    public String toString() {
        return this.f12349a.toString();
    }

    void u() {
        if (this.h.compareAndSet(false, true)) {
            this.d.d();
            io.bidmachine.rendering.internal.controller.d dVar = this.k;
            io.bidmachine.rendering.internal.controller.d dVarH = h();
            if (dVarH != null) {
                if (dVar != dVarH) {
                    c(dVarH);
                    b(dVar);
                    this.k = dVarH;
                    dVarH.a(new c(this.d));
                }
                this.d.a(dVarH);
                r();
            } else {
                a(dVar, dVar == null ? new Error("No ad phase to show") : null);
            }
            this.h.set(false);
        }
    }

    boolean a(io.bidmachine.rendering.internal.controller.d dVar) {
        return this.f.add(dVar);
    }

    void b(io.bidmachine.rendering.internal.controller.d dVar) {
        if (dVar == null) {
            return;
        }
        m.b(this.f12349a, "destroyAdPhase (%s)", dVar);
        c(dVar);
        dVar.a();
    }

    boolean c(io.bidmachine.rendering.internal.controller.d dVar) {
        return this.f.remove(dVar);
    }

    @Override // io.bidmachine.rendering.internal.controller.a
    public void a() {
        m.b(this.f12349a, "destroy", new Object[0]);
        this.e.a();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((io.bidmachine.rendering.internal.controller.d) it.next()).a();
        }
        f();
        io.bidmachine.rendering.internal.controller.d dVar = this.k;
        if (dVar != null) {
            b(dVar);
            this.k = null;
        }
        io.bidmachine.rendering.internal.view.f fVar = this.j;
        if (fVar != null) {
            fVar.b();
            this.j = null;
        }
    }

    @Override // io.bidmachine.rendering.internal.controller.a
    public Orientation b() {
        return this.c.getOrientation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AdPhaseParams adPhaseParams) {
        if (this.j != null) {
            return;
        }
        io.bidmachine.rendering.internal.view.f fVar = new io.bidmachine.rendering.internal.view.f(this.b, adPhaseParams);
        this.j = fVar;
        fVar.setListener(new d(this, null));
        this.j.f();
    }

    boolean a(Error error) {
        if (!this.e.a(false)) {
            return false;
        }
        this.d.a(this, error);
        return true;
    }

    void a(io.bidmachine.rendering.internal.controller.d dVar, Error error) {
        if (error != null) {
            this.d.a(dVar, error);
        }
        this.d.b();
    }
}
