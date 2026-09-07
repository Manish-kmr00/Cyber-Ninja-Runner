package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class nb0 implements ds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pp f9716a;

    public nb0(pp closeButtonController) {
        Intrinsics.checkNotNullParameter(closeButtonController, "closeButtonController");
        this.f9716a = closeButtonController;
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final RelativeLayout a(md0 contentView, o8 adResponse) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Context context = contentView.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullParameter(context, "context");
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundColor(0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        RelativeLayout.LayoutParams layoutParamsA = m8.a(context, (o8<?>) adResponse);
        int iA = oh2.a(context, 64.0f);
        layoutParamsA.width = Math.min(layoutParamsA.width + iA, bb0.a(context, "context").widthPixels);
        layoutParamsA.height = Math.min(layoutParamsA.height + iA, bb0.a(context, "context").heightPixels);
        relativeLayout.setLayoutParams(layoutParamsA);
        relativeLayout.addView(contentView, m8.a(context, (o8<?>) adResponse));
        relativeLayout.addView(this.f9716a.d(), m8.a(context, contentView));
        return relativeLayout;
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final void c() {
        this.f9716a.c();
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final void b() {
        this.f9716a.b();
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final void d() {
        this.f9716a.invalidate();
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final void a() {
        this.f9716a.a();
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final void a(boolean z) {
        this.f9716a.a(z);
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final void a(RelativeLayout rootLayout) {
        Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
        rootLayout.setBackground(l8.f9488a);
    }
}
