package com.ogury.ad.internal;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f7389a;
    public final j4 b;
    public final w5 c;

    public q6(j4 adController, h adLayout) {
        w5 oguryAds = w5.f7430a;
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(adController, "adController");
        Intrinsics.checkNotNullParameter(oguryAds, "oguryAds");
        this.f7389a = adLayout;
        this.b = adController;
        this.c = oguryAds;
    }

    public final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.c.getClass();
        if (w5.b || this.f7389a.getParent() != null) {
            return;
        }
        j4 j4Var = this.b;
        if (j4Var.A != 3) {
            d5 d5Var = j4Var.q;
            if (d5Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                d5Var = null;
            }
            if (Intrinsics.areEqual(d5Var.getAdState(), "expanded")) {
                return;
            }
            this.c.getClass();
            w5.b = true;
            h hVar = this.f7389a;
            activity.addContentView(hVar, hVar.getLayoutParams());
            if (activity.hasWindowFocus()) {
                this.b.i();
            } else {
                this.b.h();
            }
        }
    }
}
