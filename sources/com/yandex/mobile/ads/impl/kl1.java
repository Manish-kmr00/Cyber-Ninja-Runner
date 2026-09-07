package com.yandex.mobile.ads.impl;

import android.widget.ProgressBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class kl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final yd f9429a;

    public final void a(ProgressBar progressBar, long j, long j2) {
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        this.f9429a.getClass();
        yd.a(progressBar, j2, j);
    }

    public /* synthetic */ kl1() {
        this(new yd());
    }

    public kl1(yd animatedProgressBarController) {
        Intrinsics.checkNotNullParameter(animatedProgressBarController, "animatedProgressBarController");
        this.f9429a = animatedProgressBarController;
    }
}
