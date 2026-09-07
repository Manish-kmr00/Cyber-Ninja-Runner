package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class pd2 {
    public static od2 a(List videoAds) {
        Intrinsics.checkNotNullParameter(videoAds, "videoAds");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : videoAds) {
            if (((eb2) obj).o()) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return new od2((List) pair.component2(), (List) pair.component1());
    }
}
