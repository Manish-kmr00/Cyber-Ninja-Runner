package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class H3 implements InterfaceC4599yn {
    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<L3> invoke(List<L3> list, L3 l3) {
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                X7 x7 = ((L3) it.next()).b;
                X7 x8 = l3.b;
                if (x7 == x8) {
                    if (x8 != X7.c) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (((L3) obj).b != X7.c) {
                            arrayList.add(obj);
                        }
                    }
                    return CollectionsKt.plus((Collection<? extends L3>) arrayList, l3);
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends L3>) list, l3);
    }
}
