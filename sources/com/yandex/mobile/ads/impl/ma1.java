package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ma1 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ap1 f9617a;
    private final wv0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ma1(Context context, ap1 replayActionView, wv0 wv0Var) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(replayActionView, "replayActionView");
        this.f9617a = replayActionView;
        this.b = wv0Var;
        addView(replayActionView);
        if (wv0Var == 0 || !(wv0Var instanceof View)) {
            return;
        }
        addView((View) wv0Var);
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

    public final ap1 b() {
        return this.f9617a;
    }

    public final wv0 a() {
        return this.b;
    }
}
