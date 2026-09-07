package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class ap1 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Button f8432a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap1(Context context, Button replayButton) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(replayButton, "replayButton");
        this.f8432a = replayButton;
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

    public final Button a() {
        return this.f8432a;
    }
}
