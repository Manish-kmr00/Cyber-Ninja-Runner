package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ug {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f10383a;

    public ug(List<? extends ig<?>> assets) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(assets, 10)), 16));
        Iterator<T> it = assets.iterator();
        while (it.hasNext()) {
            ig igVar = (ig) it.next();
            Pair pair = TuplesKt.to(igVar.b(), igVar.d());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        this.f10383a = linkedHashMap;
    }

    public final ax0 a() {
        Object obj = this.f10383a.get("media");
        if (obj instanceof ax0) {
            return (ax0) obj;
        }
        return null;
    }
}
