package com.inmobi.media;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class L0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3121a = "L0";
    public final ArrayList b = new ArrayList();
    public boolean c;

    public static K0 a(ValueAnimator valueAnimator, C3455l7 c3455l7) {
        valueAnimator.setDuration(0L);
        valueAnimator.setStartDelay(0L);
        X7 x7 = c3455l7.d.k;
        if (x7 != null) {
            W7 w7 = x7.f3236a;
            W7 w8 = x7.b;
            if (w8 != null) {
                valueAnimator.setDuration(w8.a() * ((long) 1000));
            }
            if (w7 != null) {
                valueAnimator.setStartDelay(w7.a() * ((long) 1000));
            }
        }
        return new K0(valueAnimator);
    }

    public static ValueAnimator b(final View view, float f, float f2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        final C3527q7 c3527q7 = layoutParams instanceof C3527q7 ? (C3527q7) layoutParams : null;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.inmobi.media.L0$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                L0.b(c3527q7, view, valueAnimator);
            }
        });
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    public static final void b(C3527q7 c3527q7, View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        if (c3527q7 != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            c3527q7.b = (int) ((Float) animatedValue).floatValue();
        }
        view.setLayoutParams(c3527q7);
        view.requestLayout();
    }

    public static ValueAnimator a(final View view, float f, float f2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        final C3527q7 c3527q7 = layoutParams instanceof C3527q7 ? (C3527q7) layoutParams : null;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.inmobi.media.L0$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                L0.a(c3527q7, view, valueAnimator);
            }
        });
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    public static final void a(C3527q7 c3527q7, View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        if (c3527q7 != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            c3527q7.f3407a = (int) ((Float) animatedValue).floatValue();
        }
        view.setLayoutParams(c3527q7);
        view.requestLayout();
    }

    public final void a(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            K0 k0 = (K0) it.next();
            if (!k0.c) {
                ValueAnimator valueAnimator = k0.f3109a;
                Intrinsics.checkNotNull(valueAnimator, "null cannot be cast to non-null type android.animation.ValueAnimator");
                valueAnimator.setCurrentPlayTime(k0.b);
                valueAnimator.start();
            }
            if (!this.b.contains(k0)) {
                this.b.add(k0);
            }
        }
    }

    public final void a() {
        if (this.c) {
            this.c = false;
            for (K0 k0 : this.b) {
                ValueAnimator valueAnimator = k0.f3109a;
                Intrinsics.checkNotNull(valueAnimator, "null cannot be cast to non-null type android.animation.ValueAnimator");
                k0.b = valueAnimator.getCurrentPlayTime();
                if (valueAnimator.getAnimatedFraction() == 1.0d) {
                    k0.c = true;
                }
                valueAnimator.cancel();
            }
        }
    }
}
