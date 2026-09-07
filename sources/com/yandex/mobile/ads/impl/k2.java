package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l2 f9372a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k2(Context context) {
        this(context, m2.a.a(context).c());
        int i = m2.d;
    }

    public k2(Context context, l2 adBlockerStateStorage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adBlockerStateStorage, "adBlockerStateStorage");
        this.f9372a = adBlockerStateStorage;
    }

    public final i2 a() {
        return this.f9372a.b();
    }
}
