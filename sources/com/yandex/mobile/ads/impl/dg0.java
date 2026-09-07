package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class dg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8692a;

    public dg0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8692a = context;
    }

    public final zs a(g2 requestPolicy) {
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        int iOrdinal = requestPolicy.ordinal();
        if (iOrdinal == 0) {
            return new g42();
        }
        if (iOrdinal == 1) {
            return new vh0(this.f8692a, ws1.a());
        }
        throw new NoWhenBranchMatchedException();
    }
}
