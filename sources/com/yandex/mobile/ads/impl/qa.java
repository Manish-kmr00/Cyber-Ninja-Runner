package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class qa {
    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    @JvmStatic
    public static final boolean a(Context context, zy1 sizeInfo, zy1 containerSizeInfo) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
        Intrinsics.checkNotNullParameter(containerSizeInfo, "containerSizeInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
        Intrinsics.checkNotNullParameter(containerSizeInfo, "containerSizeInfo");
        int iC = containerSizeInfo.c(context);
        int iA = containerSizeInfo.a(context);
        int iC2 = sizeInfo.c(context);
        int iA2 = sizeInfo.a(context);
        int iOrdinal = containerSizeInfo.a().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                if (iC2 <= iC || iC <= 0 || (iA2 > iA && iA != 0)) {
                    z = false;
                } else {
                    z = true;
                }
            } else if (iOrdinal == 2) {
                z = true;
            } else {
                if (iOrdinal != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (iC2 <= iC) {
                }
                z = false;
            }
        } else if (iC2 > iC || iC <= 0 || iA2 > iA) {
            z = false;
        } else {
            z = true;
        }
        return z && b(context, sizeInfo);
    }

    @JvmStatic
    public static final boolean b(Context context, zy1 adSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        return adSize.c(context) <= oh2.c(context) && adSize.a(context) <= oh2.b(context);
    }

    @JvmStatic
    public static final boolean a(Context context, zy1 adSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        return adSize.c(context) <= oh2.b(context) && adSize.a(context) <= oh2.c(context);
    }
}
