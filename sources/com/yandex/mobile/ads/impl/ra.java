package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ra implements qg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c71 f10087a;
    private final zo b;
    private final rr0 c;
    private final mh2 d;

    public ra(c71 nativeAdViewAdapter, zo clickListenerConfigurator, rr0 rr0Var, mh2 tagCreator) {
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        Intrinsics.checkNotNullParameter(clickListenerConfigurator, "clickListenerConfigurator");
        Intrinsics.checkNotNullParameter(tagCreator, "tagCreator");
        this.f10087a = nativeAdViewAdapter;
        this.b = clickListenerConfigurator;
        this.c = rr0Var;
        this.d = tagCreator;
    }

    @Override // com.yandex.mobile.ads.impl.qg2
    public final void a(ig<?> asset, yo clickListenerConfigurable) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(clickListenerConfigurable, "clickListenerConfigurable");
        rr0 rr0VarA = asset.a();
        if (rr0VarA == null) {
            rr0VarA = this.c;
        }
        this.b.a(asset, rr0VarA, this.f10087a, clickListenerConfigurable);
    }

    @Override // com.yandex.mobile.ads.impl.qg2
    public final void a(View view, ig asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getTag() == null) {
            mh2 mh2Var = this.d;
            String strB = asset.b();
            mh2Var.getClass();
            view.setTag(mh2.a(strB));
        }
    }
}
