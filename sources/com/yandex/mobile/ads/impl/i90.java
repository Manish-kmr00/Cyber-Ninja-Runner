package com.yandex.mobile.ads.impl;

import android.view.View;
import com.yandex.div.core.view2.Div2View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h90 f9191a;
    private final lp1 b;
    private final s10 c;

    public i90(h90 feedDivContextFactory, lp1 reporter, s10 div2ViewFactory) {
        Intrinsics.checkNotNullParameter(feedDivContextFactory, "feedDivContextFactory");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(div2ViewFactory, "div2ViewFactory");
        this.f9191a = feedDivContextFactory;
        this.b = reporter;
        this.c = div2ViewFactory;
    }

    public final rk1 a(y20 divKitDesign, uz1 ad) {
        Intrinsics.checkNotNullParameter(divKitDesign, "divKitDesign");
        Intrinsics.checkNotNullParameter(ad, "ad");
        try {
            to toVar = new to();
            s20 s20Var = new s20(toVar);
            g90 div2Context = this.f9191a.a(s20Var);
            div2Context.a(divKitDesign.b(), ad);
            this.c.getClass();
            Intrinsics.checkNotNullParameter(div2Context, "div2Context");
            Div2View div2View = new Div2View(div2Context, null, 0, 6, null);
            div2View.setData(divKitDesign.b(), divKitDesign.c());
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            div2View.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            return new rk1(divKitDesign, div2View, toVar, s20Var);
        } catch (Throwable th) {
            op0.b(new Object[0]);
            this.b.reportError("Failed to preload feed view", th);
            return null;
        }
    }
}
