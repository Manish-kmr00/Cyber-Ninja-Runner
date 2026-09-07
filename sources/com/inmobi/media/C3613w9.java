package com.inmobi.media;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.squareup.picasso.Picasso;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.w9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3613w9 implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        WeakReference weakReferenceA;
        Intrinsics.checkNotNullParameter(activity, "activity");
        synchronized (C3627x9.c) {
            if (C3627x9.b != null && (weakReferenceA = C3627x9.a(C3627x9.f3477a, activity)) != null) {
                activity.getApplication().unregisterActivityLifecycleCallbacks(this);
                C3627x9.d.remove(weakReferenceA);
                if (C3627x9.d.isEmpty()) {
                    Intrinsics.checkNotNullExpressionValue(C3627x9.d(), "access$getTAG$p(...)");
                    Objects.toString(C3627x9.b);
                    Picasso picasso = C3627x9.b;
                    if (picasso != null) {
                        picasso.shutdown();
                    }
                    C3627x9.b = null;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
