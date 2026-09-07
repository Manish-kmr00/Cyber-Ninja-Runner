package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.InstreamAd;
import com.yandex.mobile.ads.instream.InstreamAdBreak;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class sl2 implements InstreamAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bt f10217a;

    public sl2(bt coreInstreamAd) {
        Intrinsics.checkNotNullParameter(coreInstreamAd, "coreInstreamAd");
        this.f10217a = coreInstreamAd;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof sl2) && Intrinsics.areEqual(this.f10217a, ((sl2) obj).f10217a);
    }

    public final int hashCode() {
        return this.f10217a.hashCode();
    }

    public final String toString() {
        return "YandexInstreamAd(coreInstreamAd=" + this.f10217a + ")";
    }

    public final bt a() {
        return this.f10217a;
    }

    @Override // com.yandex.mobile.ads.instream.InstreamAd
    public final List<InstreamAdBreak> getAdBreaks() {
        List<dt> listA = this.f10217a.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(new tl2((dt) it.next()));
        }
        return arrayList;
    }
}
