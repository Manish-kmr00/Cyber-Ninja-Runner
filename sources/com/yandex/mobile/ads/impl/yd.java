package com.yandex.mobile.ads.impl;

import android.widget.ProgressBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class yd {
    public static void a(ProgressBar progressBar, long j, long j2) {
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        progressBar.clearAnimation();
        if (j > 0) {
            progressBar.setMax((int) j);
            il1 il1Var = new il1(progressBar, progressBar.getProgress(), (int) j2);
            il1Var.setDuration(200L);
            progressBar.startAnimation(il1Var);
        }
    }
}
