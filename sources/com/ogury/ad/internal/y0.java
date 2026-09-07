package com.ogury.ad.internal;

import android.content.Context;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7445a;
    public final FrameLayout b;
    public final c c;

    public y0(Context context, FrameLayout activityRoot, c ad) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activityRoot, "activityRoot");
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f7445a = context;
        this.b = activityRoot;
        this.c = ad;
    }

    public static FrameLayout.LayoutParams a(q9 q9Var, FrameLayout.LayoutParams layoutParams) {
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        int i = q9Var.g;
        if (i != -1) {
            layoutParams.leftMargin = j7.a(i);
        }
        int i2 = q9Var.f;
        if (i2 != -1) {
            layoutParams.topMargin = j7.a(i2);
        }
        int i3 = q9Var.e;
        layoutParams.width = i3 <= 0 ? -1 : j7.a(i3);
        int i4 = q9Var.d;
        layoutParams.height = i4 > 0 ? j7.a(i4) : -1;
        return layoutParams;
    }
}
