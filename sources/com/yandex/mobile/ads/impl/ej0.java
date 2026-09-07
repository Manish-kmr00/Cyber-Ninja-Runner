package com.yandex.mobile.ads.impl;

import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ej0 {
    public static String b(String url, ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        return a(url, scaleType);
    }

    private static String a(String str, ImageView.ScaleType scaleType) {
        return "#S" + scaleType.ordinal() + str;
    }

    public static String a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return a(url, ImageView.ScaleType.CENTER_INSIDE);
    }
}
