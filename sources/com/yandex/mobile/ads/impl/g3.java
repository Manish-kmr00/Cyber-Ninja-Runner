package com.yandex.mobile.ads.impl;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class g3 {

    /* JADX INFO: Access modifiers changed from: private */
    static final class a implements Comparator<dt> {
        @Override // java.util.Comparator
        public final int compare(dt dtVar, dt dtVar2) {
            dt first = dtVar;
            dt second = dtVar2;
            Intrinsics.checkNotNullParameter(first, "first");
            Intrinsics.checkNotNullParameter(second, "second");
            return (int) RangesKt.coerceIn(first.b().b() - second.b().b(), -1L, 1L);
        }
    }
}
