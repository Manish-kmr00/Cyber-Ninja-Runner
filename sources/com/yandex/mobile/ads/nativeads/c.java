package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.impl.au;
import com.yandex.mobile.ads.impl.bu;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CustomClickHandler f10888a;

    public c(CustomClickHandler customClickHandler) {
        Intrinsics.checkNotNullParameter(customClickHandler, "customClickHandler");
        this.f10888a = customClickHandler;
    }

    @Override // com.yandex.mobile.ads.impl.au
    public final void a(String url, bu listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f10888a.handleCustomClick(url, new d(listener));
    }
}
