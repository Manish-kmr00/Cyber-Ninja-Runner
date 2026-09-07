package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class st0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bt f10235a;
    private final f3 b;
    private final g3 c;
    private final nt0 d;

    public st0(Context context, wm2 sdkEnvironmentModule, bt instreamAd) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamAd, "instreamAd");
        this.f10235a = instreamAd;
        this.b = new f3();
        this.c = new g3();
        this.d = new nt0(context, sdkEnvironmentModule, instreamAd);
    }

    public final ArrayList a(String breakType) {
        g3 g3Var = this.c;
        List<dt> adBreaks = this.f10235a.a();
        g3Var.getClass();
        Intrinsics.checkNotNullParameter(adBreaks, "adBreaks");
        ArrayList arrayList = new ArrayList(adBreaks);
        Collections.sort(arrayList, new g3.a());
        ArrayList<dt> adBreaks2 = new ArrayList(arrayList);
        this.b.getClass();
        Intrinsics.checkNotNullParameter(breakType, "breakType");
        Intrinsics.checkNotNullParameter(adBreaks2, "adBreaks");
        ArrayList arrayList2 = new ArrayList();
        for (dt dtVar : adBreaks2) {
            if (Intrinsics.areEqual(dtVar.e(), breakType)) {
                if (et.a.d == dtVar.b().a()) {
                    arrayList2.add(dtVar);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(this.d.a((dt) it.next()));
        }
        return arrayList3;
    }
}
