package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hs1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final is1 f9132a;

    public hs1(qm1 rewardedListener) {
        Intrinsics.checkNotNullParameter(rewardedListener, "rewardedListener");
        this.f9132a = rewardedListener;
    }

    public final gs1 a(Context context, o8 o8Var, o3 adConfiguration) {
        nr1 nr1VarJ;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        if (o8Var == null || (nr1VarJ = o8Var.J()) == null) {
            return null;
        }
        if (nr1VarJ.e()) {
            kx1 kx1VarD = nr1VarJ.d();
            if (kx1VarD != null) {
                return new jx1(context, adConfiguration, kx1VarD, new v9(context, adConfiguration));
            }
            return null;
        }
        fp fpVarC = nr1VarJ.c();
        if (fpVarC != null) {
            return new ep(fpVarC, this.f9132a, new hw1(fpVarC.c(), fpVarC.d()));
        }
        return null;
    }
}
