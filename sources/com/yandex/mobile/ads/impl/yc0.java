package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class yc0 implements ds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pp f10724a;

    public yc0(pp closeButtonController) {
        Intrinsics.checkNotNullParameter(closeButtonController, "closeButtonController");
        this.f10724a = closeButtonController;
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final RelativeLayout a(md0 contentView, o8 adResponse) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Context context = contentView.getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullParameter(context, "context");
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(contentView, new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(this.f10724a.d(), m8.a(context, contentView));
        return relativeLayout;
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final void c() {
        this.f10724a.c();
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final void b() {
        this.f10724a.b();
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final void d() {
        this.f10724a.invalidate();
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final void a() {
        this.f10724a.a();
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final void a(boolean z) {
        this.f10724a.a(z);
    }

    @Override // com.yandex.mobile.ads.impl.ds
    public final void a(RelativeLayout rootLayout) {
        Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
        rootLayout.setBackground(l8.b);
    }
}
