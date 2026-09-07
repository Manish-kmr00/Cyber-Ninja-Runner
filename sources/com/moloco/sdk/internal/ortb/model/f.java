package com.moloco.sdk.internal.ortb.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {
    public static final String a(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        String strC = cVar.e().c();
        return strC == null ? "UNKNOWN_MTID" : strC;
    }
}
