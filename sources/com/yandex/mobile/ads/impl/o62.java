package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j0 f9786a;
    private final k71 b;
    private final q62 c;
    private p62 d;
    private j71 e;

    public interface a {
        void a();

        void b();
    }

    public final void a(View nativeAdView, w81 trackingListener) {
        i0 i0Var;
        Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
        Intrinsics.checkNotNullParameter(trackingListener, "trackingListener");
        Context context = nativeAdView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        p62 p62Var = this.d;
        if (p62Var != null) {
            p62Var.a(context);
        }
        Activity activityContext = null;
        this.d = null;
        j71 j71Var = this.e;
        if (j71Var != null) {
            j71Var.b();
        }
        this.e = null;
        j0 j0Var = this.f9786a;
        Context context2 = nativeAdView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        j0Var.getClass();
        Intrinsics.checkNotNullParameter(context2, "context");
        int i = 0;
        while (context2 instanceof ContextWrapper) {
            int i2 = i + 1;
            if (i >= 10) {
                break;
            }
            if (context2 instanceof Activity) {
                activityContext = (Activity) context2;
                break;
            } else {
                context2 = ((ContextWrapper) context2).getBaseContext();
                i = i2;
            }
        }
        if (activityContext != null) {
            this.c.getClass();
            Intrinsics.checkNotNullParameter(activityContext, "activityContext");
            Intrinsics.checkNotNullParameter(trackingListener, "trackingListener");
            i0 i0Var2 = i0.g;
            if (i0Var2 == null) {
                synchronized (i0.f) {
                    i0Var = i0.g;
                    if (i0Var == null) {
                        i0Var = new i0();
                        i0.g = i0Var;
                    }
                }
                i0Var2 = i0Var;
            }
            p62 p62Var2 = new p62(activityContext, trackingListener, i0Var2);
            this.d = p62Var2;
            p62Var2.c(activityContext);
        }
        this.b.getClass();
        Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
        Intrinsics.checkNotNullParameter(trackingListener, "trackingListener");
        j71 j71Var2 = new j71(nativeAdView, trackingListener, new f71());
        this.e = j71Var2;
        j71Var2.a();
    }

    public /* synthetic */ o62() {
        this(new j0(), new k71(), new q62());
    }

    public o62(j0 activityContextProvider, k71 windowAttachListenerFactory, q62 activityLifecycleListenerFactory) {
        Intrinsics.checkNotNullParameter(activityContextProvider, "activityContextProvider");
        Intrinsics.checkNotNullParameter(windowAttachListenerFactory, "windowAttachListenerFactory");
        Intrinsics.checkNotNullParameter(activityLifecycleListenerFactory, "activityLifecycleListenerFactory");
        this.f9786a = activityContextProvider;
        this.b = windowAttachListenerFactory;
        this.c = activityLifecycleListenerFactory;
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        p62 p62Var = this.d;
        if (p62Var != null) {
            p62Var.a(context);
        }
        this.d = null;
        j71 j71Var = this.e;
        if (j71Var != null) {
            j71Var.b();
        }
        this.e = null;
    }
}
