package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class mt1 implements m51 {
    @Override // com.yandex.mobile.ads.impl.m51
    public final l51 a(Context context, o8 adResponse, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        return new l51(context, adConfiguration, adResponse);
    }
}
