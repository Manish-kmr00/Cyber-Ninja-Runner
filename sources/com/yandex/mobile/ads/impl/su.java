package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class su {
    public static List a(ru creative) {
        mr0 mr0VarB;
        Intrinsics.checkNotNullParameter(creative, "creative");
        uu uuVarC = creative.c();
        List<ig<?>> listA = (uuVarC == null || (mr0VarB = uuVarC.b()) == null) ? null : mr0VarB.a();
        return listA == null ? CollectionsKt.emptyList() : listA;
    }
}
