package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h51 f10626a;

    public final List<String> a(u61 responseBody) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        List<c41> listE = responseBody.e();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listE, 10));
        Iterator<T> it = listE.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f10626a.a((c41) it.next()));
        }
        return CollectionsKt.flatten(arrayList);
    }

    public /* synthetic */ x61() {
        this(new h51());
    }

    public x61(h51 nativeAdDataExtractor) {
        Intrinsics.checkNotNullParameter(nativeAdDataExtractor, "nativeAdDataExtractor");
        this.f10626a = nativeAdDataExtractor;
    }
}
