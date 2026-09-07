package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o90 f8878a;

    public final lj a(Context context, o8 adResponse, uz1 nativeAdPrivate, List preloadedDivKitDesigns, ViewGroup container, pt nativeAdEventListener, ViewTreeObserver.OnPreDrawListener preDrawListener, ie2 videoEventController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(preloadedDivKitDesigns, "preloadedDivKitDesigns");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(preDrawListener, "preDrawListener");
        Intrinsics.checkNotNullParameter(videoEventController, "videoEventController");
        n90 n90VarA = this.f8878a.a(context, preloadedDivKitDesigns);
        return new lj(new kj(context, container, CollectionsKt.listOfNotNull(n90VarA != null ? n90VarA.a(context, adResponse, nativeAdPrivate, nativeAdEventListener, videoEventController) : null), preDrawListener));
    }

    public /* synthetic */ f90(o3 o3Var) {
        this(o3Var, new o90(o3Var));
    }

    public f90(o3 adConfiguration, o90 designProvider) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(designProvider, "designProvider");
        this.f8878a = designProvider;
    }
}
