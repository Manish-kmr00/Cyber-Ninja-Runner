package com.ogury.ad.internal;

import android.app.Activity;
import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class m6 implements z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f7356a;
    public final q6 b;
    public final l6 c;
    public final g9 d;
    public final Application e;
    public a f;

    public static final class a extends b {
        public a() {
        }

        @Override // com.ogury.ad.internal.b, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity instanceof s5) {
                return;
            }
            q6 q6Var = m6.this.b;
            if (q6Var.f7389a.getParent() == null || q6Var.b.e()) {
                return;
            }
            q6Var.b.h();
            q6Var.f7389a.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity instanceof s5) {
                return;
            }
            m6 m6Var = m6.this;
            if (m6Var.c.a(activity)) {
                m6Var.b.a(activity);
            }
        }
    }

    public m6(Activity activity, q6 adLayoutController, l6 overlayActivityFilter) {
        g9 topActivityMonitor = g9.f7309a;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adLayoutController, "adLayoutController");
        Intrinsics.checkNotNullParameter(overlayActivityFilter, "overlayActivityFilter");
        Intrinsics.checkNotNullParameter(topActivityMonitor, "topActivityMonitor");
        this.f7356a = activity;
        this.b = adLayoutController;
        this.c = overlayActivityFilter;
        this.d = topActivityMonitor;
        this.e = activity.getApplication();
    }

    @Override // com.ogury.ad.internal.z6
    public final void a() {
        this.e.unregisterActivityLifecycleCallbacks(this.f);
    }

    @Override // com.ogury.ad.internal.z6
    public final void b() {
        this.d.getClass();
        Activity activity = g9.b.get();
        if (activity == null) {
            activity = this.f7356a;
        }
        if (this.c.a(activity)) {
            this.b.a(activity);
        }
    }

    @Override // com.ogury.ad.internal.z6
    public final void c() {
        a aVar = new a();
        this.f = aVar;
        this.e.registerActivityLifecycleCallbacks(aVar);
    }
}
