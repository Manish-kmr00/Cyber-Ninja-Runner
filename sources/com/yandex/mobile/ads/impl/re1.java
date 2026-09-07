package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class re1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iw1 f10100a;

    public final boolean a(Context context) {
        cu1 cu1VarA;
        Intrinsics.checkNotNullParameter(context, "context");
        return (!oa.a(context) || (cu1VarA = this.f10100a.a(context)) == null || cu1VarA.r0()) ? false : true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ re1() {
        this(iw1.a.a());
        int i = iw1.l;
    }

    public re1(iw1 sdkSettings) {
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        this.f10100a = sdkSettings;
    }
}
