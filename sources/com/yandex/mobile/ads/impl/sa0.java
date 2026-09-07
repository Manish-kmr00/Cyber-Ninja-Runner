package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class sa0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10189a;

    public sa0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10189a = context;
    }

    public final FrameLayout a() {
        FrameLayout frameLayout = new FrameLayout(this.f10189a);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return frameLayout;
    }
}
