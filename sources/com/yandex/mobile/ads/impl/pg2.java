package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class pg2 implements yo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f9925a;

    public pg2(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f9925a = view;
    }

    @Override // com.yandex.mobile.ads.impl.yo
    public final void a(rr0 link, ap clickListenerCreator) {
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(clickListenerCreator, "clickListenerCreator");
        Context context = this.f9925a.getContext();
        View.OnClickListener onClickListenerA = clickListenerCreator.a(link);
        Intrinsics.checkNotNull(context);
        so soVar = new so(context, onClickListenerA);
        int i = u51.e;
        a71 a71Var = new a71(context, onClickListenerA, soVar, u51.a.a());
        this.f9925a.setOnTouchListener(a71Var);
        this.f9925a.setOnClickListener(a71Var);
    }
}
