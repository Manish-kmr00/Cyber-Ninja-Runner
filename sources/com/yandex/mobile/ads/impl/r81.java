package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r81 implements p41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p51 f10083a;

    @Override // com.yandex.mobile.ads.impl.p41
    public final void a(Context context, o41 nativeAdBlock, pj0 imageProvider, n41 nativeAdBinderFactory, o51 nativeAdFactoriesProvider, a51 nativeAdControllers, c51 nativeAdCreationListener) {
        m61 m61VarA;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(nativeAdBinderFactory, "nativeAdBinderFactory");
        Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        Intrinsics.checkNotNullParameter(nativeAdCreationListener, "nativeAdCreationListener");
        List<c41> listE = nativeAdBlock.c().e();
        if (listE == null || listE.isEmpty()) {
            m61VarA = null;
        } else if (listE.size() > 1) {
            m61VarA = nativeAdBinderFactory.a(context, nativeAdBlock, imageProvider, nativeAdFactoriesProvider, nativeAdControllers);
        } else {
            m61VarA = this.f10083a.a(context, nativeAdBlock, imageProvider, nativeAdBinderFactory, nativeAdFactoriesProvider, nativeAdControllers, listE.get(0));
        }
        if (m61VarA != null) {
            nativeAdCreationListener.a(m61VarA);
        } else {
            nativeAdCreationListener.a(w7.x());
        }
    }

    public /* synthetic */ r81(uu1 uu1Var) {
        this(uu1Var, new p51(uu1Var));
    }

    public r81(uu1 sdkEnvironmentModule, p51 nativeAdFactory) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(nativeAdFactory, "nativeAdFactory");
        this.f10083a = nativeAdFactory;
    }
}
