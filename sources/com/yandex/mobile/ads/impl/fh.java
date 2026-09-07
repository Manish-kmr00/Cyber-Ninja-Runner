package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<cn0> f8894a;

    /* JADX WARN: Multi-variable type inference failed */
    public fh(List<? extends cn0> assetViewConfigurators) {
        Intrinsics.checkNotNullParameter(assetViewConfigurators, "assetViewConfigurators");
        this.f8894a = assetViewConfigurators;
    }

    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        Iterator<cn0> it = this.f8894a.iterator();
        while (it.hasNext()) {
            it.next().a(uiElements);
        }
    }
}
