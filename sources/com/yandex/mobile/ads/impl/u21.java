package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class u21 extends ng2<s21, su0> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u21(s21 mraidWebView) {
        super(mraidWebView);
        Intrinsics.checkNotNullParameter(mraidWebView, "mraidWebView");
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void a(ig asset, qg2 viewConfigurator, su0 su0Var) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(viewConfigurator, "viewConfigurator");
        s21 s21VarB = b();
        if (s21VarB == null) {
            return;
        }
        viewConfigurator.a(s21VarB, asset);
        viewConfigurator.a((ig<?>) asset, new e21(s21VarB));
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void b(View view, su0 su0Var) {
        s21 mraidWebView = (s21) view;
        su0 media = su0Var;
        Intrinsics.checkNotNullParameter(mraidWebView, "mraidWebView");
        Intrinsics.checkNotNullParameter(media, "media");
        String strB = media.b();
        if (strB != null && strB.length() > 0) {
            mraidWebView.setAspectRatio(media.a());
            mraidWebView.c(strB);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final boolean a(View view, su0 su0Var) {
        s21 mraidWebView = (s21) view;
        su0 media = su0Var;
        Intrinsics.checkNotNullParameter(mraidWebView, "mraidWebView");
        Intrinsics.checkNotNullParameter(media, "media");
        return true;
    }
}
