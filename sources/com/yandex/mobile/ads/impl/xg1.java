package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class xg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g5 f10653a;

    public xg1(g5 adLoadingPhasesManager) {
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        this.f10653a = adLoadingPhasesManager;
    }

    public final LinkedHashMap a(Set phases) {
        Intrinsics.checkNotNullParameter(phases, "phases");
        Sequence<e5> sequenceFilter = SequencesKt.filter(CollectionsKt.asSequence(this.f10653a.b()), new wg1(phases));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (e5 e5Var : sequenceFilter) {
            String strA = e5Var.a().a();
            Object arrayList = linkedHashMap.get(strA);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strA, arrayList);
            }
            ((List) arrayList).add(e5Var.b());
        }
        return linkedHashMap;
    }
}
