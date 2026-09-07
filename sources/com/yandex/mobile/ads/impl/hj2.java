package com.yandex.mobile.ads.impl;

import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hj2 implements wv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m71 f9105a;

    public hj2(m71 weakViewProvider) {
        Intrinsics.checkNotNullParameter(weakViewProvider, "weakViewProvider");
        this.f9105a = weakViewProvider;
    }

    @Override // com.yandex.mobile.ads.impl.wv0
    public final TextView getCountDownProgress() {
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.wv0
    public final CheckBox getMuteControl() {
        return this.f9105a.c();
    }

    @Override // com.yandex.mobile.ads.impl.wv0
    public final ProgressBar getVideoProgress() {
        return this.f9105a.e();
    }
}
