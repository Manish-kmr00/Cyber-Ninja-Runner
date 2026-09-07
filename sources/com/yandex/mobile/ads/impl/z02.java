package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z02 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b12 f10782a;
    private final q82 b;

    public z02(b12 socialAdInfo, q82 urlViewerLauncher) {
        Intrinsics.checkNotNullParameter(socialAdInfo, "socialAdInfo");
        Intrinsics.checkNotNullParameter(urlViewerLauncher, "urlViewerLauncher");
        this.f10782a = socialAdInfo;
        this.b = urlViewerLauncher;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Context context = v.getContext();
        String strA = this.f10782a.a();
        q82 q82Var = this.b;
        Intrinsics.checkNotNull(context);
        q82Var.a(context, strA);
    }
}
