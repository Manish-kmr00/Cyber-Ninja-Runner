package com.ogury.ad.internal;

import android.content.res.Configuration;
import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
public final class k8 implements t6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Configuration f7341a;
    public Rect b;
    public Rect c;
    public int d;

    public k8(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f7341a = configuration;
        this.b = new Rect();
        this.c = new Rect();
        this.d = configuration.orientation;
    }

    @Override // com.ogury.ad.internal.t6
    public final void a(Rect adLayoutRect, Rect containerRect) {
        Intrinsics.checkNotNullParameter(adLayoutRect, "adLayoutRect");
        Intrinsics.checkNotNullParameter(containerRect, "containerRect");
        int i = this.f7341a.orientation;
        if (this.d != i) {
            int i2 = this.c.left;
            Rect rect = this.b;
            int i3 = i2 - rect.left;
            int iWidth = rect.width() - this.c.width();
            if (iWidth != 0) {
                float f = i3 / iWidth;
                int iWidth2 = adLayoutRect.width();
                int iRoundToInt = MathKt.roundToInt((containerRect.width() - iWidth2) * f) + containerRect.left;
                adLayoutRect.left = iRoundToInt;
                adLayoutRect.right = iRoundToInt + iWidth2;
            }
            int i4 = this.c.top;
            Rect rect2 = this.b;
            int i5 = i4 - rect2.top;
            int iHeight = rect2.height() - this.c.height();
            if (iHeight != 0) {
                float f2 = i5 / iHeight;
                int iHeight2 = adLayoutRect.height();
                int iRoundToInt2 = MathKt.roundToInt((containerRect.height() - iHeight2) * f2) + containerRect.top;
                adLayoutRect.top = iRoundToInt2;
                adLayoutRect.bottom = iRoundToInt2 + iHeight2;
            }
        }
        this.b = new Rect(containerRect);
        this.d = i;
    }
}
