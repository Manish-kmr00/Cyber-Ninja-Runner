package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class hb1 implements kc2<gb1> {
    @Override // com.yandex.mobile.ads.impl.kc2
    public final gb1 a(eb2 videoAd, ru creative, aw0 mediaFile, rc2 adPodInfo, String str, String str2, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(creative, "creative");
        Intrinsics.checkNotNullParameter(mediaFile, "mediaFile");
        Intrinsics.checkNotNullParameter(adPodInfo, "adPodInfo");
        return new gb1(mediaFile.f(), mediaFile.h(), mediaFile.d());
    }
}
