package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l4 f9594a;

    public m4(Context context, dt adBreak, gm0 adPlayerController, pj0 imageProvider, zm0 adViewsHolderManager, hc2<do0> playbackEventsListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(adPlayerController, "adPlayerController");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(adViewsHolderManager, "adViewsHolderManager");
        Intrinsics.checkNotNullParameter(playbackEventsListener, "playbackEventsListener");
        this.f9594a = new l4(context, adBreak, q2.a(adBreak.a().c()), imageProvider, adPlayerController, adViewsHolderManager, playbackEventsListener);
    }

    public final ArrayList a(List videoAdInfoList) {
        Intrinsics.checkNotNullParameter(videoAdInfoList, "videoAdInfoList");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(videoAdInfoList, 10));
        Iterator it = videoAdInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f9594a.a((rb2) it.next()));
        }
        return arrayList;
    }
}
