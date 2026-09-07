package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class id0 implements n11, o11 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9203a;
    private final o8<String> b;
    private final t8 c;
    private final qt1 d;

    public id0(Context context, o3 adConfiguration, o8<String> adResponse, t8 adResultReceiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adResultReceiver, "adResultReceiver");
        this.f9203a = context;
        this.b = adResponse;
        this.c = adResultReceiver;
        this.d = new qt1(adConfiguration);
    }

    @Override // com.yandex.mobile.ads.impl.n11
    public final void e() {
        this.c.a(14, null);
    }

    @Override // com.yandex.mobile.ads.impl.n11
    public final void b() {
        this.c.a(15, null);
    }

    @Override // com.yandex.mobile.ads.impl.o11
    public final void a() {
        this.d.b(this.f9203a, this.b);
        this.c.a(13, null);
    }
}
