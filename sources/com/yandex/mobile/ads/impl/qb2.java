package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qb2 {
    public static String a(long j, rc2 adPodInfo, eb2 videoAd) {
        Intrinsics.checkNotNullParameter(adPodInfo, "adPodInfo");
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        int iA = adPodInfo.a();
        String strG = videoAd.g();
        if (strG == null) {
            strG = String.valueOf(ti0.a());
        }
        return "ad_break_#" + j + "|position_" + iA + "|video_ad_#" + strG;
    }
}
