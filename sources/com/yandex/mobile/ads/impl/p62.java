package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public final class p62 implements r0 {
    static final /* synthetic */ KProperty<Object>[] d = {ta.a(p62.class, "contextReference", "getContextReference()Landroid/content/Context;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o62.a f9899a;
    private final g0 b;
    private final zn1 c;

    public p62(Activity context, w81 trackingListener, g0 activityBackgroundListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(trackingListener, "trackingListener");
        Intrinsics.checkNotNullParameter(activityBackgroundListener, "activityBackgroundListener");
        this.f9899a = trackingListener;
        this.b = activityBackgroundListener;
        this.c = ao1.a(context);
    }

    @Override // com.yandex.mobile.ads.impl.r0
    public final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Context context = (Context) this.c.getValue(this, d[0]);
        if (context == null || !Intrinsics.areEqual(context, activity)) {
            return;
        }
        this.f9899a.b();
    }

    @Override // com.yandex.mobile.ads.impl.r0
    public final void b(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Context context = (Context) this.c.getValue(this, d[0]);
        if (context == null || !Intrinsics.areEqual(context, activity)) {
            return;
        }
        this.f9899a.a();
    }

    public final void c(Activity activityContext) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        this.b.b(activityContext, this);
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b.a(context, this);
    }
}
