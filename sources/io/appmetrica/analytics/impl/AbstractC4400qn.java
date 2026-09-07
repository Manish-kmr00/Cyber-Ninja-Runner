package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.qn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractC4400qn {
    public static final C4325nn a(Throwable th, S s, List list, String str, Boolean bool) {
        ArrayList arrayList = null;
        C4076dn c4076dnA = th != null ? AbstractC4101en.a(th, 1, 0) : null;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new C4124fl((StackTraceElement) it.next()));
            }
        }
        return new C4325nn(c4076dnA, s, arrayList, null, null, null, str, bool);
    }
}
