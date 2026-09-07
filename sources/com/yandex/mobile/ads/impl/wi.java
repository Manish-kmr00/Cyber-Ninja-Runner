package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class wi extends a62 {
    private final jp0 k;
    private final nj l;
    private final et0 m;
    private boolean n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wi(Context context, o8<String> adResponse, o3 adConfiguration, jp0 adView, nj bannerShowEventListener, et0 mainThreadHandler) {
        super(context, new ua(adView), adResponse, adConfiguration);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(bannerShowEventListener, "bannerShowEventListener");
        Intrinsics.checkNotNullParameter(mainThreadHandler, "mainThreadHandler");
        this.k = adView;
        this.l = bannerShowEventListener;
        this.m = mainThreadHandler;
    }

    @Override // com.yandex.mobile.ads.impl.yj
    public final void c() {
        this.m.a();
        super.c();
    }

    @Override // com.yandex.mobile.ads.impl.n0
    public final void onLeftApplication() {
        this.l.onLeftApplication();
    }

    @Override // com.yandex.mobile.ads.impl.n0
    public final void onReturnedToApplication() {
        this.l.onReturnedToApplication();
    }

    @Override // com.yandex.mobile.ads.impl.a62
    protected final boolean k() {
        return oh2.c(this.k.findViewById(2));
    }

    @Override // com.yandex.mobile.ads.impl.a62
    protected final boolean l() {
        View viewFindViewById = this.k.findViewById(2);
        return viewFindViewById != null && oh2.b(viewFindViewById) >= 1;
    }

    @Override // com.yandex.mobile.ads.impl.a62
    protected final boolean a(int i) {
        return oh2.a(this.k.findViewById(2), i);
    }

    @Override // com.yandex.mobile.ads.impl.nk0.a
    public final void a(t4 t4Var) {
        if (this.n) {
            return;
        }
        this.n = true;
        this.l.a(t4Var);
    }
}
