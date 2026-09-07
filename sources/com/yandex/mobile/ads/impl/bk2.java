package com.yandex.mobile.ads.impl;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bk2 {
    public static Rect a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Rect rect = new Rect();
        try {
            view.getWindowVisibleDisplayFrame(rect);
        } catch (NullPointerException unused) {
        }
        int[] iArr = {i, i};
        view.getRootView().getLocationOnScreen(iArr);
        int i = -iArr[0];
        int i2 = -iArr[1];
        rect.offset(i, i2);
        return rect;
    }
}
