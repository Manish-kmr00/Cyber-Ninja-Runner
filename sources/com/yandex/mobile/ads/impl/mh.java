package com.yandex.mobile.ads.impl;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class mh implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f9638a;

    public mh(ViewTreeObserver.OnGlobalLayoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f9638a = listener;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v.getViewTreeObserver().addOnGlobalLayoutListener(this.f9638a);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v.getViewTreeObserver().removeOnGlobalLayoutListener(this.f9638a);
    }
}
