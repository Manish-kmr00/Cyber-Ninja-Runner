package com.ogury.ad.internal;

import android.content.Context;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class m0 implements q8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f7351a;

    public m0(n0 n0Var) {
        this.f7351a = n0Var;
    }

    @Override // com.ogury.ad.internal.q8
    public final void a(Context context, List<c> ads) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ads, "ads");
        n0 n0Var = this.f7351a;
        g0 g0Var = n0Var.g;
        if (g0Var != null) {
            FrameLayout bannerView = n0Var.b;
            Intrinsics.checkNotNullParameter(bannerView, "bannerView");
            Intrinsics.checkNotNullParameter(ads, "ads");
            g0Var.h = bannerView;
            try {
                c cVarRemove = ads.remove(0);
                q5.a(ads);
                if (cVarRemove.v) {
                    g0Var.b.a(g0Var.f7300a, cVarRemove, new ArrayList());
                    if (!ads.isEmpty()) {
                        g0Var.a(ads.remove(0), bannerView, ads, true);
                    }
                } else {
                    g0Var.a(cVarRemove, bannerView, ads, false);
                }
            } catch (Throwable unused) {
                u3.f7411a.getClass();
                g0Var.b();
            }
        }
    }
}
