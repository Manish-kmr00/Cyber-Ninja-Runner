package com.ogury.ad.internal;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h2 implements t6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f7312a;

    public h2(float f) {
        this.f7312a = f;
    }

    @Override // com.ogury.ad.internal.t6
    public final void a(Rect adLayoutRect, Rect containerRect) {
        Intrinsics.checkNotNullParameter(adLayoutRect, "adLayoutRect");
        Intrinsics.checkNotNullParameter(containerRect, "containerRect");
        g2 g2Var = new g2(adLayoutRect, containerRect, this.f7312a);
        Intrinsics.checkNotNullParameter(adLayoutRect, "adLayoutRect");
        Intrinsics.checkNotNullParameter(containerRect, "containerRect");
        g2Var.b();
    }
}
