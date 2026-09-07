package com.bytedance.sdk.openadsdk.core.Bzk.pA;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes10.dex */
public class pA implements Application.ActivityLifecycleCallbacks {
    private static volatile pA pA;
    private final Og Og;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    private pA(Application application) {
        this.Og = Og.pA(application);
    }

    public static pA pA(Application application) {
        if (pA == null) {
            synchronized (pA.class) {
                if (pA == null) {
                    pA = new pA(application);
                    application.registerActivityLifecycleCallbacks(pA);
                }
            }
        }
        return pA;
    }

    public String pA(String str, long j, int i) {
        Og og = this.Og;
        if (og != null) {
            return og.pA(str, j, i);
        }
        return "null";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Og og = this.Og;
        if (og != null) {
            og.pA(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Og og = this.Og;
        if (og != null) {
            og.Og(activity);
        }
    }
}
