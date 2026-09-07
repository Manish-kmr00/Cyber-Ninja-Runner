package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class x9 {
    public static String a(w9 adTuneInfo) {
        Intrinsics.checkNotNullParameter(adTuneInfo, "adTuneInfo");
        ArrayList arrayList = new ArrayList();
        if (!StringsKt.isBlank(adTuneInfo.a())) {
            arrayList.add(adTuneInfo.a());
        }
        if (!StringsKt.isBlank(adTuneInfo.c())) {
            arrayList.add("erid: " + adTuneInfo.c());
        }
        return CollectionsKt.joinToString$default(arrayList, " · ", null, null, 0, null, null, 62, null);
    }
}
