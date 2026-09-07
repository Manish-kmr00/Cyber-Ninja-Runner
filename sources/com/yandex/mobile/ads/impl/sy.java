package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class sy implements z<ry> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vy f10246a;

    public sy(vy deeplinkRenderer) {
        Intrinsics.checkNotNullParameter(deeplinkRenderer, "deeplinkRenderer");
        this.f10246a = deeplinkRenderer;
    }

    @Override // com.yandex.mobile.ads.impl.z
    public final df0 a(View view, x xVar) {
        ry action = (ry) xVar;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(action, "action");
        Context context = view.getContext();
        vy vyVar = this.f10246a;
        Intrinsics.checkNotNull(context);
        vyVar.a(context, action);
        return new df0(true);
    }
}
