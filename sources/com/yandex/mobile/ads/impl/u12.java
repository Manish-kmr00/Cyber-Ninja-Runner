package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class u12 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x9 f10350a = new x9();

    public final String a(String sponsoredText, w9 adTuneInfo) {
        Intrinsics.checkNotNullParameter(sponsoredText, "sponsoredText");
        Intrinsics.checkNotNullParameter(adTuneInfo, "adTuneInfo");
        List listMutableListOf = CollectionsKt.mutableListOf(sponsoredText);
        this.f10350a.getClass();
        String strA = x9.a(adTuneInfo);
        if (!StringsKt.isBlank(strA)) {
            listMutableListOf.add(strA);
        }
        return CollectionsKt.joinToString$default(listMutableListOf, " · ", null, null, 0, null, null, 62, null);
    }
}
