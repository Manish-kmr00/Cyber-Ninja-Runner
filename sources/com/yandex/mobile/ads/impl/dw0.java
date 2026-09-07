package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class dw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bw0 f8739a;
    private final wl b;

    public final aw0 a(ru creative) {
        Intrinsics.checkNotNullParameter(creative, "creative");
        double d = -1.0d;
        aw0 aw0Var = null;
        for (aw0 aw0Var2 : creative.g()) {
            double d2 = Intrinsics.areEqual("video/mp4", aw0Var2.e()) ? 1.5d : 1.0d;
            int iA = this.b.a(aw0Var2);
            int iA2 = this.f8739a.a();
            int iMax = (int) Math.max(0.0d, iA);
            double dAbs = d2 / ((iMax < 100 ? 10.0d : ((double) ((int) Math.abs(iA2 - iMax))) / ((double) iA2)) + 1.0d);
            if (dAbs > d) {
                aw0Var = aw0Var2;
                d = dAbs;
            }
        }
        return aw0Var;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ dw0(Context context) {
        bw0 bw0VarA = new bo1(context).a();
        this(context, bw0VarA, new wl(bw0VarA));
    }

    public dw0(Context context, bw0 referenceMediaFileInfo, wl bitrateProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(referenceMediaFileInfo, "referenceMediaFileInfo");
        Intrinsics.checkNotNullParameter(bitrateProvider, "bitrateProvider");
        this.f8739a = referenceMediaFileInfo;
        this.b = bitrateProvider;
    }
}
