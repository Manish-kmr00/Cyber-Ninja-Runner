package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class if1 implements z00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9211a;

    @Override // com.yandex.mobile.ads.impl.z00
    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f9211a == context.getResources().getConfiguration().orientation;
    }

    public if1(int i) {
        this.f9211a = i;
    }
}
