package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class gp0 {
    /* JADX WARN: Code duplicated, block: B:17:0x004f  */
    public static fp0 a(ja1 nativeValidator, List showNotices) {
        int iIntValue;
        Integer num;
        Intrinsics.checkNotNullParameter(nativeValidator, "nativeValidator");
        Intrinsics.checkNotNullParameter(showNotices, "showNotices");
        if (showNotices.isEmpty()) {
            iIntValue = 50;
        } else {
            Iterator it = showNotices.iterator();
            if (it.hasNext()) {
                Integer numValueOf = Integer.valueOf(((xx1) it.next()).d());
                while (it.hasNext()) {
                    Integer numValueOf2 = Integer.valueOf(((xx1) it.next()).d());
                    if (numValueOf.compareTo(numValueOf2) < 0) {
                        numValueOf = numValueOf2;
                    }
                }
                num = numValueOf;
            } else {
                num = null;
            }
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                iIntValue = 50;
            }
        }
        return new fp0(nativeValidator, iIntValue);
    }
}
