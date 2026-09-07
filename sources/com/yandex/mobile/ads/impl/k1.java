package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.Window;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 implements m1, wr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9369a;
    private final RelativeLayout b;
    private final Window c;
    private final m61 d;
    private final j1 e;
    private final o3 f;
    private final tc0 g;
    private final fd0 h;
    private final vd0 i;

    public k1(Context context, RelativeLayout container, Window window, m61 nativeAdPrivate, o8 adResponse, v1 adActivityListener, e1 eventController, o3 adConfiguration, int i, tc0 fullScreenBackButtonController, fd0 fullScreenInsetsController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        Intrinsics.checkNotNullParameter(eventController, "eventController");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(fullScreenBackButtonController, "fullScreenBackButtonController");
        Intrinsics.checkNotNullParameter(fullScreenInsetsController, "fullScreenInsetsController");
        this.f9369a = context;
        this.b = container;
        this.c = window;
        this.d = nativeAdPrivate;
        this.e = adActivityListener;
        this.f = adConfiguration;
        this.g = fullScreenBackButtonController;
        this.h = fullScreenInsetsController;
        this.i = new ae0(context, adResponse, container, this, eventController, i, adActivityListener, adConfiguration).a(context, nativeAdPrivate, this);
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void g() {
        this.e.a(this.f9369a.getResources().getConfiguration().orientation == 1 ? 7 : 6);
        this.c.requestFeature(1);
        this.c.addFlags(1024);
        this.c.addFlags(16777216);
        this.h.a(this.c, this.b);
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void c() {
        if (this.f.b() != qs.i) {
            this.b.setBackground(l8.f9488a);
        }
        this.i.c();
        this.e.a(0, null);
        this.e.a(5, null);
        Object[] args = new Object[0];
        int i = op0.b;
        Intrinsics.checkNotNullParameter(args, "args");
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final boolean e() {
        return this.g.a();
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void onAdClosed() {
        this.d.destroy();
        this.e.a(4, null);
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void a() {
        this.e.a(2, null);
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void b() {
        this.e.a(3, null);
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void d() {
        this.i.invalidate();
    }

    @Override // com.yandex.mobile.ads.impl.wr
    public final void f() {
        this.e.a();
    }
}
