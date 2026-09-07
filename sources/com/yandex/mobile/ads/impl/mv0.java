package com.yandex.mobile.ads.impl;

import android.util.Base64;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class mv0 {
    public static byte[] a(pv0 pv0Var, String str, int i, String str2) {
        pv0Var.getClass();
        byte[] bArrDecode = Base64.decode(str, i);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, str2);
        return bArrDecode;
    }
}
