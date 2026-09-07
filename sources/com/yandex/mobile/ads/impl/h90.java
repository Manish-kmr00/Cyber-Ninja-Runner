package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ContextThemeWrapper;
import com.yandex.div.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9075a;
    private final lp1 b;
    private final yz1 c;

    public final g90 a(s20 clickHandler) {
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        xz1 xz1Var = new xz1(this.b);
        yz1 yz1Var = this.c;
        Context context = this.f9075a;
        yz1Var.getClass();
        return new g90(new ContextThemeWrapper(this.f9075a, R.style.Div), yz1.a(context, xz1Var, clickHandler), xz1Var);
    }

    public /* synthetic */ h90(Context context, lp1 lp1Var) {
        this(context, lp1Var, new yz1());
    }

    public h90(Context appContext, lp1 reporter, yz1 sliderDivConfigurationCreator) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(sliderDivConfigurationCreator, "sliderDivConfigurationCreator");
        this.f9075a = appContext;
        this.b = reporter;
        this.c = sliderDivConfigurationCreator;
    }
}
