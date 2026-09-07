package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.impl.bu;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements CustomClickHandlerEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bu f10889a;

    public d(bu coreListener) {
        Intrinsics.checkNotNullParameter(coreListener, "coreListener");
        this.f10889a = coreListener;
    }

    @Override // com.yandex.mobile.ads.nativeads.CustomClickHandlerEventListener
    public final void onLeftApplication() {
        this.f10889a.onLeftApplication();
    }

    @Override // com.yandex.mobile.ads.nativeads.CustomClickHandlerEventListener
    public final void onReturnedToApplication() {
        this.f10889a.onReturnedToApplication();
    }
}
