package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class u80 {
    public static boolean a(Context context, t80 toggle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toggle, "toggle");
        int i = ns0.b;
        Intrinsics.checkNotNullParameter(context, "context");
        return ns0.a(context, "YadPreferenceFile").a(toggle.a(), false);
    }
}
