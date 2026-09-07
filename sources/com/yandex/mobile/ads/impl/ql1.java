package com.yandex.mobile.ads.impl;

import android.widget.ProgressBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ql1 implements uc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zm0 f10033a;
    private final xm0 b;
    private final kl1 c;

    public /* synthetic */ ql1(zm0 zm0Var) {
        this(zm0Var, new xm0(), new kl1());
    }

    @Override // com.yandex.mobile.ads.impl.uc2
    public final void a(long j, long j2) {
        ym0 ym0VarA = this.f10033a.a();
        ProgressBar progressBarJ = null;
        q70 instreamAdView = ym0VarA != null ? ym0VarA.b() : null;
        if (instreamAdView != null) {
            this.b.getClass();
            Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
            gb2 adUiElements = instreamAdView.getAdUiElements();
            if (adUiElements != null) {
                progressBarJ = adUiElements.j();
            }
        }
        ProgressBar progressBar = progressBarJ;
        if (progressBar != null) {
            this.c.a(progressBar, j2, j);
        }
    }

    public ql1(zm0 instreamAdViewsHolderManager, xm0 instreamAdViewUiElementsManager, kl1 progressBarConfigurator) {
        Intrinsics.checkNotNullParameter(instreamAdViewsHolderManager, "instreamAdViewsHolderManager");
        Intrinsics.checkNotNullParameter(instreamAdViewUiElementsManager, "instreamAdViewUiElementsManager");
        Intrinsics.checkNotNullParameter(progressBarConfigurator, "progressBarConfigurator");
        this.f10033a = instreamAdViewsHolderManager;
        this.b = instreamAdViewUiElementsManager;
        this.c = progressBarConfigurator;
    }
}
