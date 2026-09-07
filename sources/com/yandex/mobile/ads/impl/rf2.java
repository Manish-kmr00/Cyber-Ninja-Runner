package com.yandex.mobile.ads.impl;

import android.content.res.TypedArray;
import com.yandex.mobile.ads.R;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rf2 {
    public static qf2 a(TypedArray attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return (qf2) ArraysKt.getOrNull(qf2.values(), attributes.getInt(R.styleable.MonetizationAdsInternalMediaView_monetization_internal_video_scale_type, -1));
    }
}
