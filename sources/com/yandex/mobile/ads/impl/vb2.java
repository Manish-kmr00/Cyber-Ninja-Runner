package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class vb2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nd2 f10471a;
    private final ka2 b;
    private final tb2<T> c;

    public final ArrayList a(List videoAds) {
        List listSortedWith;
        Intrinsics.checkNotNullParameter(videoAds, "videoAds");
        this.f10471a.getClass();
        Intrinsics.checkNotNullParameter(videoAds, "videoAds");
        if (!(videoAds instanceof Collection) || !videoAds.isEmpty()) {
            Iterator<T> it = videoAds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    listSortedWith = CollectionsKt.toList(videoAds);
                    break;
                }
                if (((eb2) it.next()).i() != null) {
                    ArrayList arrayList = new ArrayList();
                    for (T t : videoAds) {
                        if (((eb2) t).i() != null) {
                            arrayList.add(t);
                        }
                    }
                    listSortedWith = CollectionsKt.sortedWith(arrayList, new md2());
                    break;
                }
            }
        } else {
            listSortedWith = CollectionsKt.toList(videoAds);
            break;
        }
        ArrayList arrayListA = this.b.a(listSortedWith);
        int size = arrayListA.size();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayListA, 10));
        int i = 0;
        for (Object obj : arrayListA) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList2.add(this.c.a((ja2) obj, size, i));
            i = i2;
        }
        return arrayList2;
    }

    public /* synthetic */ vb2(Context context, kc2 kc2Var) {
        this(context, kc2Var, new nd2(), new ka2(context), new tb2(kc2Var));
    }

    public vb2(Context context, kc2<T> playbackInfoCreator, nd2 videoAdsOrderFilter, ka2 vastVideoAdsDataProvider, tb2<T> videoAdInfoCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playbackInfoCreator, "playbackInfoCreator");
        Intrinsics.checkNotNullParameter(videoAdsOrderFilter, "videoAdsOrderFilter");
        Intrinsics.checkNotNullParameter(vastVideoAdsDataProvider, "vastVideoAdsDataProvider");
        Intrinsics.checkNotNullParameter(videoAdInfoCreator, "videoAdInfoCreator");
        this.f10471a = videoAdsOrderFilter;
        this.b = vastVideoAdsDataProvider;
        this.c = videoAdInfoCreator;
    }
}
