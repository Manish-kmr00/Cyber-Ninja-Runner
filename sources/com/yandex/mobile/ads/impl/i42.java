package com.yandex.mobile.ads.impl;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i42<T extends TextView> implements zd<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9173a;
    private final ArgbEvaluator b;
    private ValueAnimator c;

    private static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f9174a;

        public a(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "textView");
            this.f9174a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Integer) {
                this.f9174a.setTextColor(((Number) animatedValue).intValue());
            }
        }
    }

    public /* synthetic */ i42(int i) {
        this(i, new ArgbEvaluator());
    }

    public i42(int i, ArgbEvaluator argbEvaluator) {
        Intrinsics.checkNotNullParameter(argbEvaluator, "argbEvaluator");
        this.f9173a = i;
        this.b = argbEvaluator;
    }

    @Override // com.yandex.mobile.ads.impl.zd
    public final void a(View view) {
        TextView textView = (TextView) view;
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.c = ValueAnimator.ofObject(this.b, Integer.valueOf(textView.getCurrentTextColor()), Integer.valueOf(this.f9173a));
        a aVar = new a(textView);
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(aVar);
        }
        ValueAnimator valueAnimator2 = this.c;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(500);
        }
        ValueAnimator valueAnimator3 = this.c;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    @Override // com.yandex.mobile.ads.impl.zd
    public final void cancel() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.c;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }
}
