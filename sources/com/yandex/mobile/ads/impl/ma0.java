package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ma0 implements z<la0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final va0 f9616a;

    public ma0(va0 feedbackRenderer) {
        Intrinsics.checkNotNullParameter(feedbackRenderer, "feedbackRenderer");
        this.f9616a = feedbackRenderer;
    }

    @Override // com.yandex.mobile.ads.impl.z
    public final df0 a(View view, x xVar) {
        la0 action = (la0) xVar;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(action, "action");
        Context context = view.getContext();
        va0 va0Var = this.f9616a;
        Intrinsics.checkNotNull(context);
        va0Var.a(context, action);
        return new df0(false);
    }
}
