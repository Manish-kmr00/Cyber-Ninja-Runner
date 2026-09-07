package com.ogury.ad.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q5 {
    public static final c a(List<c> list, String nextAdId) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(nextAdId, "nextAdId");
        if (!list.isEmpty()) {
            if (nextAdId.length() == 0 || Intrinsics.areEqual(nextAdId, "null")) {
                return list.remove(0);
            }
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (Intrinsics.areEqual(next.b, nextAdId)) {
                    it.remove();
                    return next;
                }
            }
        }
        return null;
    }

    public static final void a(List<c> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        CollectionsKt.removeAll((List) list, new Function1() { // from class: com.ogury.ad.internal.q5$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(q5.a((c) obj));
            }
        });
    }

    public static final boolean a(c it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.v;
    }
}
