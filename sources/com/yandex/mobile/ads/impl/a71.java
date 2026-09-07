package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a71 implements View.OnTouchListener, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final so f8376a;
    private final u51 b;

    public a71(Context context, View.OnClickListener onClickListener, so clickAreaVerificationListener, u51 nativeAdHighlightingController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        Intrinsics.checkNotNullParameter(clickAreaVerificationListener, "clickAreaVerificationListener");
        Intrinsics.checkNotNullParameter(nativeAdHighlightingController, "nativeAdHighlightingController");
        this.f8376a = clickAreaVerificationListener;
        this.b = nativeAdHighlightingController;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        this.b.b(view, event);
        return this.f8376a.onTouch(view, event);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f8376a.onClick(view);
    }
}
