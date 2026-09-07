package com.inmobi.media;

import android.animation.ValueAnimator;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class Z7 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3256a;

    public Z7(C3314b8 view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f3256a = new WeakReference(view);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        C3314b8 c3314b8 = (C3314b8) this.f3256a.get();
        if (c3314b8 == null) {
            return;
        }
        int visibility = c3314b8.getVisibility();
        if (visibility == 4 || visibility == 8) {
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            if (((Float) animatedValue).floatValue() >= 1.0d) {
                c3314b8.a();
                return;
            }
            return;
        }
        Object animatedValue2 = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        c3314b8.l = 360 * ((Float) animatedValue2).floatValue();
        c3314b8.invalidate();
    }
}
