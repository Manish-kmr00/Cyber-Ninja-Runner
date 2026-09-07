package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.common.AdInfo;
import com.yandex.mobile.ads.common.AdSize;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bl2 {
    public static AdInfo a(ps coreAdInfo) {
        Intrinsics.checkNotNullParameter(coreAdInfo, "coreAdInfo");
        h9 h9VarA = coreAdInfo.a();
        return new AdInfo(coreAdInfo.b(), h9VarA != null ? new AdSize(h9VarA.b(), h9VarA.a()) : null, coreAdInfo.c());
    }
}
