package com.yandex.mobile.ads.impl;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class z3 {
    public static y3 a(bk loadController) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        int i = zp1.c;
        return new y3(loadController, zp1.a.a(), new WeakReference(loadController));
    }
}
