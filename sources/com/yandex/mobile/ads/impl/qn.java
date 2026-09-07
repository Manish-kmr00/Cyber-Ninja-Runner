package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.R;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class qn {
    public static xq a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new xq(CollectionsKt.listOf((Object[]) new zd[]{new si(), new i42(context.getResources().getColor(R.color.monetization_ads_internal_text_color_white))}));
    }
}
