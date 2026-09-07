package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class hq {
    public static iq a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new iq(new jq(), new kq(), ns0.a(context, context.getPackageName() + "_preferences"));
    }
}
