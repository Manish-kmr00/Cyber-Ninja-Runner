package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g1 implements m1, wr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RelativeLayout f8956a;
    private final j1 b;
    private final Window c;
    private final hf1 d;
    private final tc0 e;
    private final fd0 f;
    private final o8<?> g;
    private final zu1 h;

    public g1(Context context, RelativeLayout rootLayout, v1 adActivityListener, Window window, cd0 fullScreenDataHolder, hf1 orientationConfigurator, tc0 fullScreenBackButtonController, fd0 fullScreenInsetsController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(fullScreenDataHolder, "fullScreenDataHolder");
        Intrinsics.checkNotNullParameter(orientationConfigurator, "orientationConfigurator");
        Intrinsics.checkNotNullParameter(fullScreenBackButtonController, "fullScreenBackButtonController");
        Intrinsics.checkNotNullParameter(fullScreenInsetsController, "fullScreenInsetsController");
        this.f8956a = rootLayout;
        this.b = adActivityListener;
        this.c = window;
        this.d = orientationConfigurator;
        this.e = fullScreenBackButtonController;
        this.f = fullScreenInsetsController;
        this.g = fullScreenDataHolder.a();
        zu1 zu1VarB = fullScreenDataHolder.b();
        this.h = zu1VarB;
        zu1VarB.a(this);
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void g() {
        this.c.requestFeature(1);
        this.c.addFlags(1024);
        this.c.addFlags(16777216);
        this.f.a(this.c, this.f8956a);
        this.d.a();
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void c() {
        this.h.a(this.f8956a);
        Bundle bundle = new Bundle();
        Map<String, String> mapA = this.h.f().a();
        bundle.putSerializable("extra_tracking_parameters", mapA instanceof Serializable ? (Serializable) mapA : null);
        this.b.a(0, bundle);
        this.b.a(5, null);
        op0.d(new Object[0]);
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final boolean e() {
        return this.e.a() && !(this.h.f().b() && this.g.P());
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void onAdClosed() {
        this.b.a(4, null);
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void a() {
        this.b.a(2, null);
        this.h.i();
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void b() {
        this.b.a(3, null);
        this.h.g();
    }

    @Override // com.yandex.mobile.ads.impl.wr
    public final void f() {
        this.b.a();
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void d() {
        this.h.d();
    }
}
