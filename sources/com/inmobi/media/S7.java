package com.inmobi.media;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class S7 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f3192a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S7(Context context, byte b) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3192a = b;
    }

    public abstract void a(C3513p7 c3513p7, T7 t7, int i, int i2, L7 l7);

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final byte getType() {
        return this.f3192a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
