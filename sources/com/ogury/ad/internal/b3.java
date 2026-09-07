package com.ogury.ad.internal;

import android.app.Activity;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b3 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f7267a;
    public final Activity b;
    public final r c;

    public b3(FrameLayout frameLayout, Activity interstitialActivity, r closeCommandInCollapsedMode) {
        Intrinsics.checkNotNullParameter(interstitialActivity, "interstitialActivity");
        Intrinsics.checkNotNullParameter(closeCommandInCollapsedMode, "closeCommandInCollapsedMode");
        this.f7267a = frameLayout;
        this.b = interstitialActivity;
        this.c = closeCommandInCollapsedMode;
    }

    @Override // com.ogury.ad.internal.r
    public final void a(j4 adController, h adLayout) {
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(adController, "adController");
        if (adController.F) {
            this.b.finish();
            return;
        }
        adLayout.d();
        adLayout.setupDrag(false);
        adLayout.a(adLayout.e);
        FrameLayout frameLayout = this.f7267a;
        if (frameLayout != null) {
            frameLayout.addView(adLayout);
        }
        adController.a(2);
        this.b.finish();
        r rVar = this.c;
        Intrinsics.checkNotNullParameter(rVar, "<set-?>");
        adController.D = rVar;
        s0 s0Var = new s0();
        Intrinsics.checkNotNullParameter(s0Var, "<set-?>");
        adController.B = s0Var;
    }
}
