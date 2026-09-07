package com.yandex.mobile.ads.impl;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b3 f9983a;

    public q5(ge2 videoDurationHolder, b3 adBreakTimingProvider) {
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(adBreakTimingProvider, "adBreakTimingProvider");
        this.f9983a = adBreakTimingProvider;
    }

    public final AdPlaybackState a(bt instreamAd, Object obj) {
        Intrinsics.checkNotNullParameter(instreamAd, "instreamAd");
        List<dt> listA = instreamAd.a();
        if (listA.isEmpty() || obj == null) {
            AdPlaybackState adPlaybackState = AdPlaybackState.NONE;
            Intrinsics.checkNotNull(adPlaybackState);
            return adPlaybackState;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<dt> it = listA.iterator();
        boolean z = false;
        while (it.hasNext()) {
            long jA = this.f9983a.a(it.next().b());
            if (jA == Long.MIN_VALUE) {
                z = true;
            } else if (jA != -1) {
                arrayList.add(Long.valueOf(Util.msToUs(jA)));
            }
        }
        int size = z ? arrayList.size() + 1 : arrayList.size();
        long[] jArr = new long[size];
        if (z) {
            jArr[size - 1] = Long.MIN_VALUE;
        }
        int size2 = arrayList.size();
        for (int i = 0; i < size2; i++) {
            jArr[i] = ((Number) arrayList.get(i)).longValue();
        }
        Arrays.sort(jArr, 0, arrayList.size());
        return new AdPlaybackState(obj, Arrays.copyOf(jArr, size));
    }
}
