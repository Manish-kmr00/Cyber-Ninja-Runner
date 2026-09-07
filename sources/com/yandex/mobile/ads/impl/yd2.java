package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class yd2 implements yo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ub1 f10728a;
    private final ru b;

    public yd2(ub1 nativeVideoView, ru ruVar) {
        Intrinsics.checkNotNullParameter(nativeVideoView, "nativeVideoView");
        this.f10728a = nativeVideoView;
        this.b = ruVar;
    }

    @Override // com.yandex.mobile.ads.impl.yo
    public final void a(rr0 link, ap clickListenerCreator) {
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(clickListenerCreator, "clickListenerCreator");
        Context context = this.f10728a.getContext();
        xd2 xd2Var = new xd2(link, clickListenerCreator, this.b);
        Intrinsics.checkNotNull(context);
        so soVar = new so(context, xd2Var);
        ub1 ub1Var = this.f10728a;
        ub1Var.setOnTouchListener(soVar);
        ub1Var.setOnClickListener(soVar);
        ImageView imageViewA = this.f10728a.b().a();
        if (imageViewA != null) {
            imageViewA.setOnTouchListener(soVar);
            imageViewA.setOnClickListener(soVar);
        }
    }
}
