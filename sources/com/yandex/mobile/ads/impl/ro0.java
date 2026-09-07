package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ro0 implements mf2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lg2 f10128a;
    private final to0 b;

    public ro0(dt adBreak, rb2 videoAdInfo, id2 statusController, so0 viewProvider, lg2 containerVisibleAreaValidator, to0 videoVisibleStartValidator) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(statusController, "statusController");
        Intrinsics.checkNotNullParameter(viewProvider, "viewProvider");
        Intrinsics.checkNotNullParameter(containerVisibleAreaValidator, "containerVisibleAreaValidator");
        Intrinsics.checkNotNullParameter(videoVisibleStartValidator, "videoVisibleStartValidator");
        this.f10128a = containerVisibleAreaValidator;
        this.b = videoVisibleStartValidator;
    }

    @Override // com.yandex.mobile.ads.impl.mf2
    public final boolean a() {
        return this.b.a() && this.f10128a.a();
    }
}
