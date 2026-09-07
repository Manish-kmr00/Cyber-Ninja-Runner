package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d21 implements xo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rr0 f8659a;
    private final ap b;

    public d21(rr0 link, ap clickListenerCreator) {
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(clickListenerCreator, "clickListenerCreator");
        this.f8659a = link;
        this.b = clickListenerCreator;
    }

    @Override // com.yandex.mobile.ads.impl.xo
    public final void a(s21 view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        this.b.a(new rr0(this.f8659a.a(), this.f8659a.c(), this.f8659a.d(), url, this.f8659a.b())).onClick(view);
    }
}
