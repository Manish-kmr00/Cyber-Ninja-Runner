package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import com.yandex.mobile.ads.common.AdActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vx1 f9885a;

    public p1(vx1 showActivityProvider) {
        Intrinsics.checkNotNullParameter(showActivityProvider, "showActivityProvider");
        this.f9885a = showActivityProvider;
    }

    public final Intent a(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9885a.getClass();
        Intent intent = new Intent(context, (Class<?>) AdActivity.class);
        intent.putExtra("window_type", "window_type_activity_result");
        intent.putExtra("data_identifier", j);
        return intent;
    }
}
