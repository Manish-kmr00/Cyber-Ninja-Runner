package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ub1 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final se2 f10373a;
    private final TextureView b;
    private final ma1 c;
    private cb1 d;
    private ou0 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ub1(Context context, se2 placeholderView, TextureView textureView, ma1 actionViewsContainer) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(placeholderView, "placeholderView");
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        Intrinsics.checkNotNullParameter(actionViewsContainer, "actionViewsContainer");
        this.f10373a = placeholderView;
        this.b = textureView;
        this.c = actionViewsContainer;
        this.e = new ky1();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final se2 b() {
        return this.f10373a;
    }

    public final TextureView c() {
        return this.b;
    }

    public final ma1 a() {
        return this.c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        ou0.a aVarA = this.e.a(i, i2);
        super.onMeasure(aVarA.f9859a, aVarA.b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        cb1 cb1Var = this.d;
        if (cb1Var != null) {
            cb1Var.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cb1 cb1Var = this.d;
        if (cb1Var != null) {
            cb1Var.a();
        }
    }

    public final void setAspectRatio(float f) {
        this.e = new hm1(f);
    }

    public final void setOnAttachStateChangeListener(cb1 cb1Var) {
        this.d = cb1Var;
    }
}
