package com.inmobi.media;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.p9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC3515p9 {
    public static final EnumC3501o9 a(byte b) {
        if (b == 1) {
            return EnumC3501o9.PORTRAIT;
        }
        if (b == 2) {
            return EnumC3501o9.REVERSE_PORTRAIT;
        }
        if (b == 3) {
            return EnumC3501o9.LANDSCAPE;
        }
        return b == 4 ? EnumC3501o9.REVERSE_LANDSCAPE : EnumC3501o9.PORTRAIT;
    }

    public static final boolean b(EnumC3501o9 enumC3501o9) {
        Intrinsics.checkNotNullParameter(enumC3501o9, "<this>");
        return enumC3501o9 == EnumC3501o9.LANDSCAPE || enumC3501o9 == EnumC3501o9.REVERSE_LANDSCAPE;
    }

    public static final int a(EnumC3501o9 enumC3501o9) {
        Intrinsics.checkNotNullParameter(enumC3501o9, "<this>");
        int iOrdinal = enumC3501o9.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        if (iOrdinal == 1) {
            return 90;
        }
        if (iOrdinal == 2) {
            return 180;
        }
        if (iOrdinal == 3) {
            return 270;
        }
        throw new NoWhenBranchMatchedException();
    }
}
