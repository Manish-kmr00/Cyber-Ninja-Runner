package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f9728a;

    public ng(bp clickListenerFactory, List<? extends ig<?>> assets, i3 adClickHandler, c71 viewAdapter, po1 renderedTimer, mk0 impressionEventsObservable, rr0 rr0Var) {
        Intrinsics.checkNotNullParameter(clickListenerFactory, "clickListenerFactory");
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(adClickHandler, "adClickHandler");
        Intrinsics.checkNotNullParameter(viewAdapter, "viewAdapter");
        Intrinsics.checkNotNullParameter(renderedTimer, "renderedTimer");
        Intrinsics.checkNotNullParameter(impressionEventsObservable, "impressionEventsObservable");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(assets, 10)), 16));
        for (ig<?> igVar : assets) {
            String strB = igVar.b();
            rr0 rr0VarA = igVar.a();
            Pair pair = TuplesKt.to(strB, clickListenerFactory.a(igVar, rr0VarA == null ? rr0Var : rr0VarA, adClickHandler, viewAdapter, renderedTimer, impressionEventsObservable));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        this.f9728a = linkedHashMap;
    }

    public final void a(View view, String assetName) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        View.OnClickListener onClickListener = (View.OnClickListener) this.f9728a.get(assetName);
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
