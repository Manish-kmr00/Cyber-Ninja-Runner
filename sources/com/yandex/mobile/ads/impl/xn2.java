package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class xn2 implements Application.ActivityLifecycleCallbacks {
    private static xn2 d = new xn2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10668a;
    private boolean b;
    private a c;

    public interface a {
    }

    private xn2() {
    }

    public static xn2 a() {
        return d;
    }

    public final void b() {
        this.f10668a = true;
        this.b = false;
        Iterator<mn2> it = nn2.a().b().iterator();
        while (it.hasNext()) {
            it.next().j().a(true);
        }
    }

    public final void c() {
        this.f10668a = false;
        this.b = false;
        this.c = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.b) {
            this.b = false;
            if (this.f10668a) {
                Iterator<mn2> it = nn2.a().b().iterator();
                while (it.hasNext()) {
                    it.next().j().a(true);
                }
                if (this.c != null) {
                    z62.g().getClass();
                    z62.a();
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        View viewF;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        boolean z = false;
        boolean z2 = runningAppProcessInfo.importance != 100;
        boolean z3 = true;
        for (mn2 mn2Var : nn2.a().c()) {
            if (mn2Var.g() && (viewF = mn2Var.f()) != null && viewF.hasWindowFocus()) {
                z3 = false;
            }
        }
        if (z2 && z3) {
            z = true;
        }
        if (this.b != z) {
            this.b = z;
            if (this.f10668a) {
                boolean z4 = !z;
                Iterator<mn2> it = nn2.a().b().iterator();
                while (it.hasNext()) {
                    it.next().j().a(z4);
                }
                if (this.c != null) {
                    if (z) {
                        z62.g().getClass();
                        z62.c();
                    } else {
                        z62.g().getClass();
                        z62.a();
                    }
                }
            }
        }
    }

    public final void a(a aVar) {
        this.c = aVar;
    }
}
