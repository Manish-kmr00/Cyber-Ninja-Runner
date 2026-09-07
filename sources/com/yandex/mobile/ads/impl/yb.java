package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class yb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u50 f10718a;
    private final bf1 b;
    private final k0 c;

    public final void a(View view, jb action) {
        Activity activityB;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(action, "action");
        this.c.getClass();
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        do {
            activityB = null;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                activityB = activity;
                break;
            }
            ContextWrapper contextWrapper = context instanceof ContextWrapper ? (ContextWrapper) context : null;
            if (contextWrapper == null) {
                break;
            } else {
                context = contextWrapper.getBaseContext();
            }
        } while (context != null);
        if (activityB == null) {
            activityB = p0.b();
        }
        if (activityB == null || !oa.a((Context) activityB)) {
            return;
        }
        try {
            a(activityB, new bc(activityB), action);
        } catch (Throwable unused) {
        }
    }

    public /* synthetic */ yb(u50 u50Var, bf1 bf1Var) {
        this(u50Var, bf1Var, new k0());
    }

    public yb(u50 eventListenerController, bf1 openUrlHandler, k0 activityContextProvider) {
        Intrinsics.checkNotNullParameter(eventListenerController, "eventListenerController");
        Intrinsics.checkNotNullParameter(openUrlHandler, "openUrlHandler");
        Intrinsics.checkNotNullParameter(activityContextProvider, "activityContextProvider");
        this.f10718a = eventListenerController;
        this.b = openUrlHandler;
        this.c = activityContextProvider;
    }

    private final void a(Activity activity, bc bcVar, jb jbVar) {
        new nb(new pb(activity, bcVar, new mb(activity, bcVar), new ob()).a(), bcVar, this.f10718a, this.b, new Handler(Looper.getMainLooper())).a(jbVar.c(), jbVar.d());
    }
}
