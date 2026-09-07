package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qa0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fk f10002a;
    private final yb b;
    private final o20 c;
    private final eg2 d;
    private final je2 e;

    public qa0(fk action, yb adtuneRenderer, o20 divKitAdtuneRenderer, eg2 videoTracker, je2 videoEventUrlsTracker) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(adtuneRenderer, "adtuneRenderer");
        Intrinsics.checkNotNullParameter(divKitAdtuneRenderer, "divKitAdtuneRenderer");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(videoEventUrlsTracker, "videoEventUrlsTracker");
        this.f10002a = action;
        this.b = adtuneRenderer;
        this.c = divKitAdtuneRenderer;
        this.d = videoTracker;
        this.e = videoEventUrlsTracker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View adtune) {
        Intrinsics.checkNotNullParameter(adtune, "adtune");
        this.d.a("feedback");
        this.e.a(this.f10002a.b(), null);
        fk fkVar = this.f10002a;
        if (fkVar instanceof jb) {
            this.b.a(adtune, (jb) fkVar);
        } else if (fkVar instanceof k20) {
            o20 o20Var = this.c;
            Context context = adtune.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            o20Var.a(context, (k20) fkVar);
        }
    }
}
