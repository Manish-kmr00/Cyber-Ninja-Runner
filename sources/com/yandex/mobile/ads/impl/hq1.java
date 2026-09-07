package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.common.AdTheme;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hq1 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9126a;

        static {
            int[] iArr = new int[AdTheme.values().length];
            try {
                iArr[AdTheme.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdTheme.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f9126a = iArr;
        }
    }

    public static gq1 a(AdTheme adTheme) {
        Intrinsics.checkNotNullParameter(adTheme, "adTheme");
        int i = a.f9126a[adTheme.ordinal()];
        if (i == 1) {
            return gq1.d;
        }
        if (i == 2) {
            return gq1.c;
        }
        throw new NoWhenBranchMatchedException();
    }
}
