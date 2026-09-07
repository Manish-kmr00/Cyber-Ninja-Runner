package com.fyber.inneractive.sdk.config;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.v0;
import com.fyber.inneractive.sdk.util.x0;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3073c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3075e f1686a;

    public C3073c(C3075e c3075e) {
        this.f1686a = c3075e;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.f1686a.e.hasMessages(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) || this.f1686a.f1692a.get()) {
            return;
        }
        this.f1686a.e.sendEmptyMessageDelayed(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, 3000L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        com.fyber.inneractive.sdk.cache.session.g gVar;
        this.f1686a.e.removeMessages(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
        C3075e c3075e = this.f1686a;
        if (c3075e.f1692a.compareAndSet(true, false)) {
            if (c3075e.b) {
                IAlog.a("onActivityResumed: restartSession", new Object[0]);
                c3075e.b = false;
                Z z = c3075e.d;
                if (z != null) {
                    com.fyber.inneractive.sdk.cache.session.e eVar = z.f1684a;
                    if (eVar != null) {
                        com.fyber.inneractive.sdk.cache.session.i iVar = eVar.f1647a;
                        for (com.fyber.inneractive.sdk.cache.session.enums.c cVar : com.fyber.inneractive.sdk.cache.session.enums.c.values()) {
                            if (cVar != com.fyber.inneractive.sdk.cache.session.enums.c.NONE && (gVar = (com.fyber.inneractive.sdk.cache.session.g) iVar.f1651a.get(cVar)) != null && gVar.f1650a != 0) {
                                eVar.a(cVar, gVar);
                            }
                        }
                        com.fyber.inneractive.sdk.util.r.f2374a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, com.fyber.inneractive.sdk.cache.session.enums.a.NEW_SESSION, com.fyber.inneractive.sdk.cache.session.enums.c.NONE));
                    }
                    c3075e.d.c.put("SESSION_STAMP", Long.toString(SystemClock.elapsedRealtime()));
                    c3075e.d.b.clear();
                }
            }
            x0 x0Var = c3075e.c;
            if (x0Var != null) {
                x0Var.d = false;
                x0Var.f = 0L;
                v0 v0Var = x0Var.c;
                if (v0Var != null) {
                    v0Var.removeMessages(1932593528);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
