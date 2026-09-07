package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class se2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProgressBar f10200a;
    private final ImageView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public se2(Context context, ProgressBar progressBar, ImageView imageView) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        this.f10200a = progressBar;
        this.b = imageView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final ProgressBar b() {
        return this.f10200a;
    }

    public final ImageView a() {
        return this.b;
    }
}
