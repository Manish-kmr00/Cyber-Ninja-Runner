package com.ogury.ad.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g9 f7309a = new g9();
    public static WeakReference<Activity> b = new WeakReference<>(null);
    public static boolean c;

    public static final class a extends b {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            g9 g9Var = g9.f7309a;
            g9.b = new WeakReference<>(activity);
        }
    }

    public final synchronized void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (c) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application == null) {
            return;
        }
        c = true;
        application.registerActivityLifecycleCallbacks(new a());
    }
}
