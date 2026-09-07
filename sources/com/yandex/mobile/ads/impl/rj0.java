package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.adjust.sdk.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10113a;

    public rj0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10113a = context.getApplicationContext();
    }

    public final String a(int i, int i2) {
        Context context = this.f10113a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int iA = oh2.a(context, i);
        Context context2 = this.f10113a;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int iA2 = oh2.a(context2, i2);
        String str = "width = " + i + ", height = " + i2 + ", widthDip = " + iA + ", heightDip = " + iA2;
        op0.a(new Object[0]);
        if (iA >= 320 || iA2 >= 240) {
            return Constants.LARGE;
        }
        if (iA < 160 && iA2 < 160) {
            return Constants.SMALL;
        }
        return "medium";
    }
}
