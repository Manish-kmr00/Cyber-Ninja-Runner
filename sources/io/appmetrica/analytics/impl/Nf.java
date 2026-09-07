package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class Nf implements Jf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Rf f11269a;

    public Nf(Rf rf) {
        this.f11269a = rf;
    }

    @Override // io.appmetrica.analytics.impl.Jf
    public final void a() {
        Rf rf = this.f11269a;
        ArrayList arrayList = rf.g;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            C4044cg c4044cg = (C4044cg) obj;
            rf.c.getClass();
            String str = c4044cg != null ? c4044cg.f11496a : null;
            if (!(str == null || str.length() == 0)) {
                arrayList2.add(obj);
            }
        }
        rf.a(rf.c.a(CollectionsKt.filterNotNull(arrayList2)));
    }
}
