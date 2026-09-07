package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class m8 {
    public static RelativeLayout.LayoutParams a(Context context, zy1 zy1Var) {
        RelativeLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(context, "context");
        if (zy1Var != null) {
            layoutParams = new RelativeLayout.LayoutParams(oh2.a(context, zy1Var.c(context)), oh2.a(context, zy1Var.a(context)));
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(13);
        return layoutParams;
    }

    @JvmStatic
    public static final RelativeLayout.LayoutParams a(Context context, md0 anchorView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        int iA = oh2.a(context, 25.0f);
        int iA2 = oh2.a(context, 64.0f);
        int i = iA2 >> 1;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA2, iA2);
        layoutParams.addRule(7, anchorView.getId());
        layoutParams.addRule(6, anchorView.getId());
        ViewGroup.LayoutParams layoutParams2 = anchorView.getLayoutParams();
        int i2 = layoutParams2.width;
        boolean z = true;
        boolean z2 = i2 == -1 || i2 + iA >= bb0.a(context, "context").widthPixels;
        int i3 = layoutParams2.height;
        if (i3 != -1 && i3 + iA < bb0.a(context, "context").heightPixels) {
            z = false;
        }
        int i4 = (iA >> 1) - ((iA2 - iA) / 2);
        if (!z2 && !z) {
            i4 = -i;
        }
        layoutParams.setMargins(0, i4, i4, 0);
        return layoutParams;
    }

    @JvmStatic
    public static final RelativeLayout.LayoutParams a(Context context, o8<?> o8Var) {
        RelativeLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(context, "context");
        if (o8Var != null) {
            layoutParams = new RelativeLayout.LayoutParams(oh2.a(context, o8Var.r()), oh2.a(context, o8Var.c()));
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(13);
        return layoutParams;
    }
}
