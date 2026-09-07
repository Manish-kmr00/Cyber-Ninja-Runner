package com.yandex.mobile.ads.impl;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class il1 extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9240a;
    private final int b;
    private final WeakReference<ProgressBar> c;

    public il1(ProgressBar progressBar, int i, int i2) {
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        this.f9240a = i;
        this.b = i2;
        this.c = new WeakReference<>(progressBar);
        setInterpolator(new LinearInterpolator());
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation) {
        ProgressBar progressBar = this.c.get();
        if (progressBar != null) {
            super.applyTransformation(f, transformation);
            int i = this.f9240a;
            progressBar.setProgress(Math.round(((this.b - i) * f) + i));
        }
    }
}
