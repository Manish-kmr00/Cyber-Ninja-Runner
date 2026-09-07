package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class zi extends do1 implements nj {
    private final jp0 C;
    private final yi D;
    private final ie2 E;
    private final bj F;
    private final aj G;
    private final pg0 H;
    private dj I;
    private dj J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zi(Context context, jp0 adView, yi bannerAdListener, g5 adLoadingPhasesManager, ie2 videoEventController, bj bannerAdSizeValidator, aj adResponseControllerFactoryCreator, pg0 htmlAdResponseReportManager) {
        super(context, adView, adLoadingPhasesManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(bannerAdListener, "bannerAdListener");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(videoEventController, "videoEventController");
        Intrinsics.checkNotNullParameter(bannerAdSizeValidator, "bannerAdSizeValidator");
        Intrinsics.checkNotNullParameter(adResponseControllerFactoryCreator, "adResponseControllerFactoryCreator");
        Intrinsics.checkNotNullParameter(htmlAdResponseReportManager, "htmlAdResponseReportManager");
        this.C = adView;
        this.D = bannerAdListener;
        this.E = videoEventController;
        this.F = bannerAdSizeValidator;
        this.G = adResponseControllerFactoryCreator;
        this.H = htmlAdResponseReportManager;
        a(adView);
        bannerAdListener.a(htmlAdResponseReportManager);
    }

    private static void a(jp0 jp0Var) {
        jp0Var.setHorizontalScrollBarEnabled(false);
        jp0Var.setVerticalScrollBarEnabled(false);
        jp0Var.setVisibility(8);
        jp0Var.setBackgroundColor(0);
    }

    public final jp0 C() {
        return this.C;
    }

    public final ie2 D() {
        return this.E;
    }

    public final String B() {
        dj djVar = this.J;
        if (djVar != null) {
            return djVar.getAdInfo();
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.do1, com.yandex.mobile.ads.impl.bk
    public final void d() {
        super.d();
        this.D.a((vs) null);
        rg2.a(this.C, true);
        this.C.setVisibility(8);
        oh2.a((ViewGroup) this.C);
    }

    @Override // com.yandex.mobile.ads.impl.bk
    public final void u() {
        super.u();
        dj djVar = this.I;
        if (djVar != this.J) {
            dj[] djVarArr = new dj[1];
            if (djVar != null) {
                djVar.a(l());
            }
            this.I = this.J;
        }
        zy1 zy1VarR = f().r();
        if (zy1.a.d != (zy1VarR != null ? zy1VarR.a() : null) || this.C.getLayoutParams() == null) {
            return;
        }
        this.C.getLayoutParams().height = -2;
    }

    @Override // com.yandex.mobile.ads.impl.bk
    public final void e() {
        dj[] djVarArr = {this.I, this.J};
        for (int i = 0; i < 2; i++) {
            dj djVar = djVarArr[i];
            if (djVar != null) {
                djVar.a(l());
            }
        }
        super.e();
    }

    @Override // com.yandex.mobile.ads.impl.nj
    public final void a(t4 t4Var) {
        this.D.a(t4Var);
    }

    @Override // com.yandex.mobile.ads.impl.bk, com.yandex.mobile.ads.impl.qq1.b
    public final void a(o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        super.a((o8) adResponse);
        this.H.a(adResponse);
        this.H.a(f());
        dj djVarA = this.G.a(adResponse).a(this);
        this.J = djVarA;
        djVarA.a(l(), adResponse);
    }

    @Override // com.yandex.mobile.ads.impl.nj
    public final void onLeftApplication() {
        this.D.b();
    }

    @Override // com.yandex.mobile.ads.impl.nj
    public final void onReturnedToApplication() {
        this.D.c();
    }

    public final void A() {
        this.D.a();
    }

    public final boolean z() {
        o8<String> o8VarK = k();
        zy1 zy1VarM = o8VarK != null ? o8VarK.M() : null;
        if (zy1VarM != null) {
            zy1 zy1VarR = f().r();
            o8<String> o8VarK2 = k();
            if (o8VarK2 != null && zy1VarR != null && bz1.a(l(), o8VarK2, zy1VarM, this.F, zy1VarR)) {
                return true;
            }
        }
        return false;
    }

    public final void a(vs vsVar) {
        a(this.D);
        this.D.a(vsVar);
    }
}
