package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class fn0 {
    public static en0 a(Context context, rb2 videoAdInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        return new en0(new dn0(context, videoAdInfo, new su(), new s12(context, videoAdInfo), new hz(context)).a());
    }
}
