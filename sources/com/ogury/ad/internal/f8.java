package com.ogury.ad.internal;

import android.graphics.Rect;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h2 f7298a;
    public final int b;

    public f8() {
        h2 minVisibilityAdjustmentGateway = new h2(0.75f);
        Intrinsics.checkNotNullParameter(minVisibilityAdjustmentGateway, "minVisibilityAdjustmentGateway");
        this.f7298a = minVisibilityAdjustmentGateway;
        this.b = j7.a(50);
    }

    public final boolean a(ViewGroup adLayout, e8 resizeProps) {
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(resizeProps, "resizeProps");
        int i = resizeProps.b;
        int i2 = this.b;
        if (i < i2 || resizeProps.c < i2) {
            return false;
        }
        Rect containerRect = new Rect();
        adLayout.getWindowVisibleDisplayFrame(containerRect);
        Rect adLayoutRect = new Rect();
        int i3 = containerRect.left + resizeProps.d;
        adLayoutRect.left = i3;
        int i4 = containerRect.top + resizeProps.e;
        adLayoutRect.top = i4;
        adLayoutRect.right = i3 + resizeProps.b;
        adLayoutRect.bottom = i4 + resizeProps.c;
        h2 h2Var = this.f7298a;
        h2Var.getClass();
        Intrinsics.checkNotNullParameter(adLayoutRect, "adLayoutRect");
        Intrinsics.checkNotNullParameter(containerRect, "containerRect");
        g2 g2Var = new g2(adLayoutRect, containerRect, h2Var.f7312a);
        float fA = g2Var.a();
        if (fA < 0.5f) {
            return false;
        }
        boolean z = resizeProps.f7292a;
        if (!z && fA < 0.75f) {
            return false;
        }
        if (!z || fA >= 0.75f) {
            return true;
        }
        if (!g2Var.b()) {
            return false;
        }
        resizeProps.d = adLayoutRect.left - containerRect.left;
        resizeProps.e = adLayoutRect.top - containerRect.top;
        resizeProps.b = adLayoutRect.width();
        resizeProps.c = adLayoutRect.height();
        return true;
    }
}
