package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xc0 implements m62, s82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ds f10641a;
    private Map<String, String> b;
    private boolean c;

    public xc0(ds contentPresenter) {
        Intrinsics.checkNotNullParameter(contentPresenter, "contentPresenter");
        this.f10641a = contentPresenter;
    }

    @Override // com.yandex.mobile.ads.impl.m62
    public final void a(Map<String, String> map) {
        this.b = map;
    }

    @Override // com.yandex.mobile.ads.impl.s82
    public final void a(boolean z) {
        this.c = z;
        this.f10641a.a(z);
    }

    public final wc0 a() {
        return new wc0(this.c, this.b);
    }
}
