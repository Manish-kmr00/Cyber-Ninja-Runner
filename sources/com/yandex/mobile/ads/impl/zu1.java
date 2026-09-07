package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class zu1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10852a;
    private final o8<String> b;
    private final String c;
    private final t8 d;
    private final ed0 e;
    private final id0 f;
    private final uc0 g;
    private final wg0 h;
    private final pd0 i;
    private final Context j;
    private final md0 k;
    private final dd0 l;
    private final ds m;
    private final xc0 n;
    private final View o;
    private final bw p;

    public zu1(Context context, uu1 sdkEnvironmentModule, o3 adConfiguration, o8<String> adResponse, String htmlResponse, t8 adResultReceiver, ed0 fullScreenHtmlWebViewListener, id0 fullScreenMobileAdsSchemeListener, uc0 fullScreenCloseButtonListener, wg0 htmlWebViewAdapterFactoryProvider, pd0 fullscreenAdActivityLauncher) throws lj2 {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(htmlResponse, "htmlResponse");
        Intrinsics.checkNotNullParameter(adResultReceiver, "adResultReceiver");
        Intrinsics.checkNotNullParameter(fullScreenHtmlWebViewListener, "fullScreenHtmlWebViewListener");
        Intrinsics.checkNotNullParameter(fullScreenMobileAdsSchemeListener, "fullScreenMobileAdsSchemeListener");
        Intrinsics.checkNotNullParameter(fullScreenCloseButtonListener, "fullScreenCloseButtonListener");
        Intrinsics.checkNotNullParameter(htmlWebViewAdapterFactoryProvider, "htmlWebViewAdapterFactoryProvider");
        Intrinsics.checkNotNullParameter(fullscreenAdActivityLauncher, "fullscreenAdActivityLauncher");
        this.f10852a = adConfiguration;
        this.b = adResponse;
        this.c = htmlResponse;
        this.d = adResultReceiver;
        this.e = fullScreenHtmlWebViewListener;
        this.f = fullScreenMobileAdsSchemeListener;
        this.g = fullScreenCloseButtonListener;
        this.h = htmlWebViewAdapterFactoryProvider;
        this.i = fullscreenAdActivityLauncher;
        this.j = context.getApplicationContext();
        md0 md0VarB = b();
        this.k = md0VarB;
        this.p = new cw(context, adConfiguration, new xq1().b(adResponse, adConfiguration)).a();
        this.l = c();
        ds dsVarA = a();
        this.m = dsVarA;
        xc0 xc0Var = new xc0(dsVarA);
        this.n = xc0Var;
        fullScreenCloseButtonListener.a(xc0Var);
        fullScreenHtmlWebViewListener.a(xc0Var);
        this.o = dsVarA.a(md0VarB, adResponse);
    }

    private final md0 b() throws lj2 {
        nd0 nd0Var = new nd0();
        Context context = this.j;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return nd0Var.a(context, this.b, this.f10852a);
    }

    public final wc0 f() {
        return this.n.a();
    }

    public final String e() {
        return this.b.e();
    }

    private final ds a() {
        boolean zA = h21.a(this.c);
        Context context = this.j;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        n8 n8Var = new n8(context, null, 6, 0);
        FrameLayout frameLayout = new FrameLayout(context);
        Intrinsics.checkNotNullParameter(context, "context");
        int iA = oh2.a(context, 25.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 17;
        int iA2 = oh2.a(context, 19.5f);
        layoutParams.setMargins(iA2, iA2, iA2, iA2);
        frameLayout.addView(n8Var, layoutParams);
        n8Var.setTag(mh2.a("close_button"));
        n8Var.setBorderWidth(1.0f);
        frameLayout.setOnClickListener(new op(this.g, this.l, this.p));
        return new es(new qp()).a(frameLayout, this.b, this.p, zA, this.b.S());
    }

    private final dd0 c() {
        vg0 lkVar;
        boolean zA = h21.a(this.c);
        this.h.getClass();
        if (zA) {
            lkVar = new m21();
        } else {
            lkVar = new lk();
        }
        md0 md0Var = this.k;
        ed0 ed0Var = this.e;
        id0 id0Var = this.f;
        return lkVar.a(md0Var, ed0Var, id0Var, this.g, id0Var);
    }

    public final void h() {
        this.l.a(this.c);
    }

    public final void d() {
        this.g.a((wr) null);
        this.e.a((cs) null);
        this.l.invalidate();
        this.m.d();
    }

    public final void i() {
        this.k.f();
        this.m.a();
    }

    public final void g() {
        this.m.b();
        this.k.e();
    }

    public final void a(wr wrVar) {
        this.g.a(wrVar);
    }

    public final void a(cs csVar) {
        this.e.a(csVar);
    }

    public final void a(RelativeLayout rootLayout) {
        Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
        this.m.a(rootLayout);
        rootLayout.addView(this.o);
        this.m.c();
    }

    public final Object a(Context context, t8 t8Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.d.a(t8Var);
        return this.i.a(context, new c1(new c1.a(this.b, this.f10852a, this.d).a(this)));
    }
}
