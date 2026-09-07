package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewTreeObserver;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class mj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hj f9643a;

    public final lj a(Context context, o8 adResponse, m61 nativeAdPrivate, jp0 container, x71 nativeAdEventListener, ViewTreeObserver.OnPreDrawListener preDrawListener, ie2 videoEventController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(preDrawListener, "preDrawListener");
        Intrinsics.checkNotNullParameter(videoEventController, "videoEventController");
        gj gjVarA = this.f9643a.a(context, nativeAdPrivate);
        return new lj(new kj(context, container, CollectionsKt.listOfNotNull(gjVarA != null ? gjVarA.a(context, adResponse, nativeAdPrivate, nativeAdEventListener, videoEventController) : null), preDrawListener));
    }

    public /* synthetic */ mj(o3 o3Var) {
        this(o3Var, new hj(o3Var));
    }

    public mj(o3 adConfiguration, hj designProvider) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(designProvider, "designProvider");
        this.f9643a = designProvider;
    }
}
