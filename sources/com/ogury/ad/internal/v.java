package com.ogury.ad.internal;

import android.content.Context;
import com.ogury.ad.common.OnAdsInitListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7416a;
    public final String b;
    public final OnAdsInitListener c;

    public v(Context context, String str, OnAdsInitListener onAdsInitListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onAdsInitListener, "onAdsInitListener");
        this.f7416a = context;
        this.b = str;
        this.c = onAdsInitListener;
    }

    public final String a() {
        return this.b;
    }

    public final Context b() {
        return this.f7416a;
    }

    public final OnAdsInitListener c() {
        return this.c;
    }
}
