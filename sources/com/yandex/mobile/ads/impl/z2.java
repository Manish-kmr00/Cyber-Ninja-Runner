package com.yandex.mobile.ads.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f10784a;

    public z2(List<dt> adBreaks) {
        Intrinsics.checkNotNullParameter(adBreaks, "adBreaks");
        this.f10784a = a(adBreaks);
    }

    private static LinkedHashMap a(List list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            linkedHashMap.put((dt) it.next(), y2.b);
        }
        return linkedHashMap;
    }

    public final y2 a(dt adBreak) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        y2 y2Var = (y2) this.f10784a.get(adBreak);
        return y2Var == null ? y2.f : y2Var;
    }

    public final boolean a() {
        List listListOf = CollectionsKt.listOf((Object[]) new y2[]{y2.i, y2.h});
        Collection collectionValues = this.f10784a.values();
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            return false;
        }
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            if (listListOf.contains((y2) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final void a(dt adBreak, y2 status) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(status, "status");
        this.f10784a.put(adBreak, status);
    }
}
