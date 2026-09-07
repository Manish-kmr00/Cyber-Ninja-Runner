package com.yandex.mobile.ads.impl;

import android.view.View;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ti2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10306a;
    private final int b;

    public final void a(View volumeControl, boolean z) {
        Intrinsics.checkNotNullParameter(volumeControl, "volumeControl");
        volumeControl.setBackground(ContextCompat.getDrawable(volumeControl.getContext(), z ? this.f10306a : this.b));
    }

    public ti2(int i, int i2) {
        this.f10306a = i;
        this.b = i2;
    }
}
