package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class on {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f9836a;
    private final zd<TextView> b;

    public /* synthetic */ on(Context context) {
        this(context, new Handler(Looper.getMainLooper()), qn.a(context));
    }

    public on(Context context, Handler handler, zd<TextView> callToActionAnimator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(callToActionAnimator, "callToActionAnimator");
        this.f9836a = handler;
        this.b = callToActionAnimator;
    }

    public final void a() {
        this.f9836a.removeCallbacksAndMessages(null);
        this.b.cancel();
    }

    public final void a(TextView callToActionView) {
        Intrinsics.checkNotNullParameter(callToActionView, "callToActionView");
        this.f9836a.postDelayed(new h22(callToActionView, this.b), 2000L);
    }
}
