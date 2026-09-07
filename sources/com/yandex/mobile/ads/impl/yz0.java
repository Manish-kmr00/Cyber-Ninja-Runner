package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class yz0 {
    @JvmStatic
    public static final void a(ArrayList report) {
        Intrinsics.checkNotNullParameter(report, "report");
        Iterator it = report.iterator();
        while (it.hasNext()) {
            zz0.a aVar = (zz0.a) it.next();
            int iOrdinal = aVar.b().ordinal();
            if (iOrdinal == 0) {
                dp0.b(aVar.a(), new Object[0]);
            } else if (iOrdinal == 1) {
                dp0.a(aVar.a(), new Object[0]);
            }
        }
    }
}
