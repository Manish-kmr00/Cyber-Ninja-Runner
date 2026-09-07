package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.ac, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC3303ac {
    public static final short a(I3 errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        int iOrdinal = errorCode.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 18) {
                return (short) 2229;
            }
            switch (iOrdinal) {
                case 12:
                    return (short) 2123;
                case 13:
                    return (short) 2124;
                case 14:
                    return (short) 2125;
                case 15:
                    return (short) 2126;
                case 16:
                    return (short) 2127;
            }
        }
        return (short) 2122;
    }
}
