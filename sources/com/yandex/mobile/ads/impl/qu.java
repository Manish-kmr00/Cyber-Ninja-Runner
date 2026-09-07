package com.yandex.mobile.ads.impl;

import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class qu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pl1 f10049a;

    public final void a(TextView countDownProgress, long j, long j2) {
        Intrinsics.checkNotNullParameter(countDownProgress, "countDownProgress");
        this.f10049a.getClass();
        countDownProgress.setText(pl1.a(j - j2));
    }

    public /* synthetic */ qu() {
        this(new pl1());
    }

    public qu(pl1 progressDisplayTimeFormatter) {
        Intrinsics.checkNotNullParameter(progressDisplayTimeFormatter, "progressDisplayTimeFormatter");
        this.f10049a = progressDisplayTimeFormatter;
    }
}
