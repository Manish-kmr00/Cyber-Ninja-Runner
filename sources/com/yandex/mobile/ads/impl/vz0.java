package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class vz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wz0 f10520a;

    public vz0(wz0 networksDataProvider) {
        Intrinsics.checkNotNullParameter(networksDataProvider, "networksDataProvider");
        this.f10520a = networksDataProvider;
    }

    public final ArrayList a(List mediationNetworks) {
        Intrinsics.checkNotNullParameter(mediationNetworks, "mediationNetworks");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(mediationNetworks, 10));
        Iterator it = mediationNetworks.iterator();
        while (it.hasNext()) {
            nx nxVar = (nx) it.next();
            List<String> listB = nxVar.b();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
            for (String str : listB) {
                List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
                String str2 = (String) CollectionsKt.getOrNull(listSplit$default, CollectionsKt.getLastIndex(listSplit$default) - 1);
                if (str2 == null) {
                    str2 = "";
                }
                arrayList2.add(new iz0.b(str2, str));
            }
            arrayList.add(new iz0(nxVar.e(), arrayList2));
        }
        return this.f10520a.a(arrayList);
    }
}
