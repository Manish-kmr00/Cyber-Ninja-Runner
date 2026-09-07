package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p2 f8660a;
    private final cg2 b;

    public d3(Context context, p2 adBreak) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        this.f8660a = adBreak;
        this.b = new cg2(context);
    }

    public final void c() {
        this.b.a(this.f8660a, "breakStart");
    }

    public final void a() {
        this.b.a(this.f8660a, "breakEnd");
    }

    public final void b() {
        this.b.a(this.f8660a, "error");
    }
}
