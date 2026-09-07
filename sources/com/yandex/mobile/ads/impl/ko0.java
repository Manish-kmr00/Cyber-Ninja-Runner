package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ko0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final su f9440a;

    public ko0(su creativeAssetsProvider) {
        Intrinsics.checkNotNullParameter(creativeAssetsProvider, "creativeAssetsProvider");
        this.f9440a = creativeAssetsProvider;
    }

    public final zd2 a(ru creative, String str) {
        Object next;
        List listEmptyList;
        Intrinsics.checkNotNullParameter(creative, "creative");
        this.f9440a.getClass();
        Iterator it = su.a(creative).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((ig) next).b(), str));
        ig igVar = (ig) next;
        rr0 rr0VarA = igVar != null ? igVar.a() : null;
        if (rr0VarA != null) {
            return new zd2(rr0VarA.e(), rr0VarA.d());
        }
        String strB = creative.b();
        List list = (List) ((LinkedHashMap) creative.a()).get("clickTracking");
        if (list == null || (listEmptyList = CollectionsKt.filterNotNull(list)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return new zd2(strB, listEmptyList);
    }
}
