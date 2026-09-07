package com.fyber.inneractive.sdk.config;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.v0;
import com.fyber.inneractive.sdk.util.x0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3075e implements r {
    public x0 c;
    public final Z d;
    public final C3074d f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f1692a = new AtomicBoolean(false);
    public boolean b = false;
    public final Handler e = new Handler(Looper.getMainLooper(), new C3072b(this));

    public C3075e(Z z) {
        C3073c c3073c = new C3073c(this);
        this.f = new C3074d(this);
        this.d = z;
        Application application = AbstractC3251o.f2370a;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(c3073c);
        }
    }

    public final void a() {
        IAConfigManager iAConfigManager = IAConfigManager.O;
        C3088s c3088s = iAConfigManager.u;
        if (!c3088s.d) {
            c3088s.c.add(this);
        }
        x0 x0Var = new x0(TimeUnit.MINUTES, iAConfigManager.u.b.a("session_duration", 30, 1));
        this.c = x0Var;
        x0Var.e = this.f;
    }

    @Override // com.fyber.inneractive.sdk.config.r
    public final void onGlobalConfigChanged(C3088s c3088s, C3085o c3085o) {
        x0 x0Var = this.c;
        if (x0Var != null) {
            x0Var.d = false;
            x0Var.f = 0L;
            v0 v0Var = x0Var.c;
            if (v0Var != null) {
                v0Var.removeMessages(1932593528);
            }
            x0 x0Var2 = new x0(TimeUnit.MINUTES, c3085o.a("session_duration", 30, 1), this.c.f);
            this.c = x0Var2;
            x0Var2.e = this.f;
        }
        c3088s.c.remove(this);
    }
}
