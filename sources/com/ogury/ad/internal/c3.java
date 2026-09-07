package com.ogury.ad.internal;

import android.app.Activity;
import android.graphics.Rect;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c3 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v2 f7273a;
    public final Activity b;
    public final r c;
    public final boolean d;
    public final String e;
    public final g3 f;

    public c3(v2 v2Var, Activity interstitialActivity, r closeCommandInCollapsedMode, boolean z, String adUnitId) {
        g3 lastPositionManager = g3.f7304a;
        Intrinsics.checkNotNullParameter(interstitialActivity, "interstitialActivity");
        Intrinsics.checkNotNullParameter(closeCommandInCollapsedMode, "closeCommandInCollapsedMode");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(lastPositionManager, "lastPositionManager");
        this.f7273a = v2Var;
        this.b = interstitialActivity;
        this.c = closeCommandInCollapsedMode;
        this.d = z;
        this.e = adUnitId;
        this.f = lastPositionManager;
    }

    @Override // com.ogury.ad.internal.r
    public final void a(j4 adController, h adLayout) {
        Rect rect;
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(adController, "adController");
        g3 g3Var = this.f;
        String adUnitId = this.e;
        g3Var.getClass();
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Rect rect2 = (Rect) g3.b.get(adUnitId);
        e8 e8VarA = null;
        if (rect2 == null) {
            rect = null;
        } else {
            rect = new Rect(rect2);
            ViewGroup parentAsViewGroup = adLayout.getParentAsViewGroup();
            if (parentAsViewGroup != null) {
                rect.top -= z9.a(parentAsViewGroup).top;
            }
        }
        e8 e8Var = adLayout.e;
        if (e8Var != null) {
            e8VarA = rect == null ? e8.a(e8Var, 0, 0, 31) : e8.a(e8Var, rect.left, rect.top, 7);
        }
        adLayout.a(e8VarA);
        adLayout.d();
        adLayout.setupDrag(this.d);
        v2 v2Var = this.f7273a;
        if (v2Var != null) {
            v2Var.a(adLayout);
        }
        adController.a(2);
        this.b.finish();
        r rVar = this.c;
        Intrinsics.checkNotNullParameter(rVar, "<set-?>");
        adController.D = rVar;
        f7 f7Var = new f7();
        Intrinsics.checkNotNullParameter(f7Var, "<set-?>");
        adController.B = f7Var;
    }
}
