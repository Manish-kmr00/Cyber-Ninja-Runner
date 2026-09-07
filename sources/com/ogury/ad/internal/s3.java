package com.ogury.ad.internal;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class s3 {
    public static String a(r3 r3Var) {
        Intrinsics.checkNotNullParameter(r3Var, "<this>");
        int iOrdinal = r3Var.ordinal();
        if (iOrdinal == 0) {
            return "format";
        }
        if (iOrdinal == 1) {
            return "sdk";
        }
        throw new NoWhenBranchMatchedException();
    }
}
