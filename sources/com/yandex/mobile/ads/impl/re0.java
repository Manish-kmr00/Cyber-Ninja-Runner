package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class re0 implements qc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ue0 f10099a;
    private final we0 b;

    public /* synthetic */ re0(Context context) {
        this(context, new ue0(context), new we0(context));
    }

    public re0(Context context, ue0 gmsClientAdvertisingInfoProvider, we0 gmsServiceAdvertisingInfoProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gmsClientAdvertisingInfoProvider, "gmsClientAdvertisingInfoProvider");
        Intrinsics.checkNotNullParameter(gmsServiceAdvertisingInfoProvider, "gmsServiceAdvertisingInfoProvider");
        this.f10099a = gmsClientAdvertisingInfoProvider;
        this.b = gmsServiceAdvertisingInfoProvider;
    }

    @Override // com.yandex.mobile.ads.impl.qc
    public final lc a() {
        lc lcVarA = this.f10099a.a();
        return lcVarA == null ? this.b.a() : lcVarA;
    }
}
