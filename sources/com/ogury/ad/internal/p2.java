package com.ogury.ad.internal;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes13.dex */
public final class p2 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7382a;

        static {
            int[] iArr = new int[o2.values().length];
            try {
                o2 o2Var = o2.IMPRESSION_SOURCE_FORMAT;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                o2 o2Var2 = o2.IMPRESSION_SOURCE_FORMAT;
                iArr[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f7382a = iArr;
        }
    }

    public static String a(o2 o2Var) {
        int i = o2Var == null ? -1 : a.f7382a[o2Var.ordinal()];
        if (i == -1) {
            return "";
        }
        if (i == 1) {
            return "sdk";
        }
        if (i == 2) {
            return "format";
        }
        throw new NoWhenBranchMatchedException();
    }
}
