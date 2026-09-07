package com.ogury.ad.internal;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class n5 implements t6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7365a;

    @Override // com.ogury.ad.internal.t6
    public final void a(Rect adLayoutRect, Rect containerRect) {
        Intrinsics.checkNotNullParameter(adLayoutRect, "adLayoutRect");
        Intrinsics.checkNotNullParameter(containerRect, "containerRect");
        int i = containerRect.top;
        int i2 = i - this.f7365a;
        if (i2 != 0) {
            this.f7365a = i;
            adLayoutRect.top -= i2;
            adLayoutRect.bottom -= i2;
        }
    }
}
