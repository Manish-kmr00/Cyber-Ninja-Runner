package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e91 f9613a;
    private final gc1 b;
    private final ab1 c;

    public /* synthetic */ m91(Context context, g5 g5Var, a51 a51Var) {
        this(context, g5Var, a51Var, new e91(context, g5Var), new gc1(g5Var));
    }

    public m91(Context context, g5 adLoadingPhasesManager, a51 nativeAdControllers, e91 nativeImagesLoader, gc1 webViewLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        Intrinsics.checkNotNullParameter(nativeImagesLoader, "nativeImagesLoader");
        Intrinsics.checkNotNullParameter(webViewLoader, "webViewLoader");
        this.f9613a = nativeImagesLoader;
        this.b = webViewLoader;
        this.c = nativeAdControllers.a();
    }

    public final void a() {
        this.c.a();
        this.f9613a.getClass();
        this.b.getClass();
    }
}
